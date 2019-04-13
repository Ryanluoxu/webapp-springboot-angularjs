package io.ryanluoxu.customerManager.restcontroller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.bean.vo.ResponseModel;
import io.ryanluoxu.customerManager.bean.vo.UserDetailsVO;

@RestController
public class MainRestController {

	@GetMapping("/getCredential")
	ResponseModel<UserDetailsVO> getCredential(){
		ResponseModel<UserDetailsVO> response = new ResponseModel<>();
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication == null) {
				return null;
			}
			UserDetailsVO userDetailsVO = new UserDetailsVO();
			String authorities = authentication.getAuthorities().toString(); //  [ROLE_USER]
			userDetailsVO.setUserName(authentication.getName());
			userDetailsVO.setRole(authorities.substring(authorities.indexOf("_")+1, authorities.indexOf("]")));
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(userDetailsVO);
		} catch (Exception e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.toString());
		}
		return response;
	}

}
