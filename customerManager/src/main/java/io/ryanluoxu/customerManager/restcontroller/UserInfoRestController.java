package io.ryanluoxu.customerManager.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ryanluoxu.customerManager.base.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.bean.input.UserInfoInput;
import io.ryanluoxu.customerManager.bean.vo.ResponseModel;
import io.ryanluoxu.customerManager.bean.vo.UserInfoVO;
import io.ryanluoxu.customerManager.controller.UserInfoController;

@RestController
@RequestMapping("/rest/userInfo")
public class UserInfoRestController {

	@Autowired
	private UserInfoController userInfoController;

	@PostMapping("/add")
	ResponseModel<UserInfoVO> add(@RequestBody UserInfoInput userInfoInput){
		ResponseModel<UserInfoVO> response = new ResponseModel<>();
		try {
			userInfoController.validate(userInfoInput, ActionTypeConstant.ACTION_TYPE_ADD);
			UserInfoVO userInfoVO = userInfoController.add(userInfoInput);
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(userInfoVO);
		} catch (CommonException e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.getErrorMsg());
		}
		return response;
	}
	
	@PostMapping("/update")
	ResponseModel<UserInfoVO> update(@RequestBody UserInfoInput userInfoInput){
		ResponseModel<UserInfoVO> response = new ResponseModel<>();
		try {
			userInfoController.validate(userInfoInput, ActionTypeConstant.ACTION_TYPE_UPDATE);
			UserInfoVO userInfoVO = userInfoController.update(userInfoInput);
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(userInfoVO);
		} catch (CommonException e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.getErrorMsg());
		}
		return response;
	}

	@PostMapping("/delete")
	ResponseModel<UserInfoVO> delete(@RequestBody UserInfoInput userInfoInput){
		ResponseModel<UserInfoVO> response = new ResponseModel<>();
		try {
			userInfoController.validate(userInfoInput, ActionTypeConstant.ACTION_TYPE_DELETE);
			UserInfoVO userInfoVO = userInfoController.delete(userInfoInput);
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(userInfoVO);
		} catch (CommonException e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.getErrorMsg());
		}
		return response;
	}

	@GetMapping("/findAll")
	ResponseModel<List<UserInfoVO>> findAll(){
		ResponseModel<List<UserInfoVO>> response = new ResponseModel<>();
		try {
			List<UserInfoVO> userInfoVOs = userInfoController.findAll();
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(userInfoVOs);
		} catch (Exception e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.toString());
		}
		return response;
	}

}
