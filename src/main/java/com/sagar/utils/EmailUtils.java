package com.sagar.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.sagar.model.HIS_USERS;


@Component
public class EmailUtils {

	//========================================= Sending Email For Temporary Password ============================================//
	@Autowired(required=true)
	private JavaMailSender javaMailSender;

	public boolean SendUserAccUnlockEmail(HIS_USERS hIS_USERS) {

		try {

			MimeMessage mimeMsg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);

			helper.setTo(hIS_USERS.getEmail());
			helper.setSubject("Unlock User Account");
			helper.setText(getUnlockAccEmailBody(hIS_USERS), true);
			javaMailSender.send(mimeMsg);
			return true;
		} catch (Exception e) {
		
			return false;

		}
	}

	private String getUnlockAccEmailBody(HIS_USERS hIS_USERS) throws IOException {
		StringBuffer sb = new StringBuffer("");
		FileReader fr = new FileReader("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");		
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			line = br.readLine();
		}
		
		br.close();
		
		String mailBody = sb.toString();
		mailBody = mailBody.replace("{FNAME}", hIS_USERS.getFirstName());
		mailBody = mailBody.replace("{LNAME}", hIS_USERS.getLastName());
		mailBody = mailBody.replace("{TEMP-PWD}",hIS_USERS.getPwd());
		mailBody = mailBody.replace("{EMAIL}", hIS_USERS.getEmail());
		return mailBody;
	}
	
	}

