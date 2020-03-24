package com.cs.automationframework.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class SessionManager {
	

	public static String getAuthenticatedURL(String baseUrl, String username, String userpass, String sectoken) throws MalformedURLException, IOException {
		return baseUrl + "/secur/frontdoor.jsp?sid=" + getSessionID(username, userpass, sectoken);
	}
	
	public static String getSessionID(String username, String userpass, String sectoken) throws MalformedURLException, IOException {
		String input = readInput(doOutput(username, userpass, sectoken));
		return input.replaceAll("^.*<sessionId>(.*)</sessionId>.*$","$1").trim();
	}
	
	public static String getMetadataServerUrl(String username, String userpass, String sectoken) throws MalformedURLException, IOException {
		String input = readInput(doOutput(username, userpass, sectoken));
		return input.replaceAll("^.*<metadataServerUrl>(.*)</metadataServerUrl>.*$","$1").trim();
	}
	
	public static String getSOAPServerUrl(String username, String userpass, String sectoken) throws MalformedURLException, IOException {
		String input = readInput(doOutput(username, userpass, sectoken));
		String soap = input.replaceAll("^.*<serverUrl>(.*)</serverUrl>.*$","$1").trim();
	    System.out.println("soap: " + soap);

		return soap;
	}
	
	private static String readInput(HttpURLConnection conn) throws IOException {
		InputStream in = conn.getInputStream();
		StringBuilder b = new StringBuilder();
		byte[] buf = new byte[2000];
		int n = 0;
		while((n=in.read(buf))!=-1) {
			b.append(new String(buf,0,n));
		}
		return b.toString();
	}
	
	private static HttpURLConnection doOutput(String username, String userpass, String sectoken) throws UnsupportedEncodingException, IOException {
		HttpURLConnection conn = getConnection();
		OutputStream out = conn.getOutputStream();
		out.write(getLoginRequestXML(username, userpass, sectoken));
		out.flush();
		return conn;
	}
	
	private static byte[] getLoginRequestXML(String username, String password, String securityToken) throws UnsupportedEncodingException {
	    System.out.println("logging in with: " + username + ", " + password);
		byte[] msg = new String(
				"<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n"+
				"<env:Envelope xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n"+
				"              xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"+
				"              xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"+
				"    <env:Body>\n"+
		        "        <n1:login xmlns:n1=\"urn:partner.soap.sforce.com\">\n"+
		        "            <n1:username>"+username+"</n1:username>\n"+
		        "            <n1:password>"+password+securityToken+"</n1:password>\n"+
		        "        </n1:login>\n"+
		        "    </env:Body>\n"+
		        "</env:Envelope>\n").getBytes("UTF-8");
		return msg;
	}
	
	private static HttpURLConnection getConnection() throws MalformedURLException, IOException {
		HttpURLConnection conn = (HttpURLConnection) new URL(RunParameters.SOAP_API_AUTH_ENDPOINT).openConnection();
		conn.setDoOutput(true);
		conn.addRequestProperty("Content-Type", "text/xml");
		conn.addRequestProperty("SOAPAction", "login");
		return conn;
	}
	

	
	
}
