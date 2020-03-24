package com.cs.automationframework.utilities;

public class RunParameters {
	
	// credentials/secrets are read from environment variables and are not committed to the repo
	public static String TESTSCIENCE_ORG_INSTANCE_URL = System.getProperty("TESTSCIENCE_ORG_INSTANCE_URL");
	public static String TESTSCIENCE_SYSADMIN_USERNAME = System.getProperty("TESTSCIENCE_SYSADMIN_USERNAME");
	public static String TESTSCIENCE_SYSADMIN_PASSWORD = System.getProperty("TESTSCIENCE_SYSADMIN_PASSWORD");
	public static String TESTSCIENCE_SYSADMIN_SECURITY_TOKEN = System.getProperty("TESTSCIENCE_SYSADMIN_SECURITY_TOKEN");
	public static String SOAP_API_AUTH_ENDPOINT = "https://login.salesforce.com/services/Soap/u/34.0/";




	
}