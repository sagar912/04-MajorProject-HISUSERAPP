package com.sagar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sagar.constants.AppConstants;
import com.sagar.entities.HisUsersEntity;
import com.sagar.model.UnlockAccount;
import com.sagar.services.HIS_USERService;


@Controller
public class UnlockLoginController {

	@Autowired
	private HIS_USERService service;


	// =================================== save changed password and unlock account //========================================//

	@PostMapping(value = { "/unlockAcc" })
	public String unlockUser(@ModelAttribute("unlockAcc") UnlockAccount acc, Model model) {
		HisUsersEntity hisUsersEntity = new HisUsersEntity();
		String tempPwd = acc.getTempPwd();
		BeanUtils.copyProperties(acc, hisUsersEntity);
		try {
			HisUsersEntity hisUsersEntityResponse = service.findByPwd(tempPwd);
			if (tempPwd.equals(hisUsersEntityResponse.getPwd())) {
				hisUsersEntityResponse.setPwd(acc.getNewPwd());

			}
			// ======================= Set Permanent Password =======================//

			boolean updateUser = service.updateUser(hisUsersEntityResponse);

			if (updateUser == true) {
				model.addAttribute("SuccessMsg", "Your Registration is Successful");

			} else if (updateUser == false) {
				return AppConstants.UNLOCK_USER_PAGE;

			}
			return AppConstants.UNLOCK_USER_SUCCESS_MSG_PAGE;

		} catch (Exception e) {
			model.addAttribute("ExMsg", "Account is not unlock due to incorrect temp pwd");
			return AppConstants.UNLOCK_USER_PAGE;
		}

	}
}