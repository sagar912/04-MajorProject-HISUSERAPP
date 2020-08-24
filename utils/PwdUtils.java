package com.sagar.utils;

import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sagar.constants.AppConstants;
import com.sagar.controller.forgotPasswordController;

public class PwdUtils {
	private final static String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final Logger logger = LoggerFactory.getLogger(PwdUtils.class);

	public static String generateRandomPassword(int len)
	{
        logger.debug(AppConstants.METHOD_EXECUTION_START);
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < len; i++) {
			int randomIndex = random.nextInt(ALPHA_NUMERIC_STRING.length());
			sb.append(ALPHA_NUMERIC_STRING.charAt(randomIndex));
		}
        logger.debug(AppConstants.METHOD_EXECUTION_ENDED);
		return sb.toString();
	}

}
