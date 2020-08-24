package com.sagar.utils;

import java.security.SecureRandom;


public class PwdUtils {
	private final static String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	public static String generateRandomPassword(int len)
	{
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < len; i++) {
			int randomIndex = random.nextInt(ALPHA_NUMERIC_STRING.length());
			sb.append(ALPHA_NUMERIC_STRING.charAt(randomIndex));
		}
		return sb.toString();
	}

}
