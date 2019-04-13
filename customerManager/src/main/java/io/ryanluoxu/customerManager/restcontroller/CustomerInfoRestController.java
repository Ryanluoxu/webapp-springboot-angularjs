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
import io.ryanluoxu.customerManager.bean.input.CustomerInfoInput;
import io.ryanluoxu.customerManager.bean.vo.CustomerInfoVO;
import io.ryanluoxu.customerManager.bean.vo.ResponseModel;
import io.ryanluoxu.customerManager.controller.CustomerInfoController;

@RestController
@RequestMapping("/rest/customerInfo")
public class CustomerInfoRestController {

	@Autowired
	private CustomerInfoController customerInfoController;

	@PostMapping("/add")
	ResponseModel<CustomerInfoVO> add(@RequestBody CustomerInfoInput customerInfoInput){
		ResponseModel<CustomerInfoVO> response = new ResponseModel<>();
		try {
			customerInfoController.validate(customerInfoInput, ActionTypeConstant.ACTION_TYPE_ADD);
			CustomerInfoVO customerInfoVO = customerInfoController.add(customerInfoInput);
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(customerInfoVO);
		} catch (CommonException e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.getErrorMsg());
		}
		return response;
	}

	@PostMapping("/update")
	ResponseModel<CustomerInfoVO> update(@RequestBody CustomerInfoInput customerInfoInput){
		ResponseModel<CustomerInfoVO> response = new ResponseModel<>();
		try {
			customerInfoController.validate(customerInfoInput, ActionTypeConstant.ACTION_TYPE_UPDATE);
			CustomerInfoVO customerInfoVO = customerInfoController.update(customerInfoInput);
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(customerInfoVO);
		} catch (CommonException e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.getErrorMsg());
		}
		return response;
	}

	@PostMapping("/delete")
	ResponseModel<CustomerInfoVO> delete(@RequestBody CustomerInfoInput customerInfoInput){
		ResponseModel<CustomerInfoVO> response = new ResponseModel<>();
		try {
			customerInfoController.validate(customerInfoInput, ActionTypeConstant.ACTION_TYPE_DELETE);
			CustomerInfoVO customerInfoVO = customerInfoController.delete(customerInfoInput);
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(customerInfoVO);
		} catch (CommonException e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.getErrorMsg());
		}
		return response;
	}

	@GetMapping("/findAll")
	ResponseModel<List<CustomerInfoVO>> findAll(){
		ResponseModel<List<CustomerInfoVO>> response = new ResponseModel<>();
		try {
			List<CustomerInfoVO> customerInfoVOs = customerInfoController.findAll();
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(customerInfoVOs);
		} catch (Exception e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.toString());
		}
		return response;
	}

}
