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
import io.ryanluoxu.customerManager.bean.input.OrderInfoInput;
import io.ryanluoxu.customerManager.bean.vo.OrderInfoVO;
import io.ryanluoxu.customerManager.bean.vo.ResponseModel;
import io.ryanluoxu.customerManager.controller.OrderInfoController;

@RestController
@RequestMapping("/rest/orderInfo")
public class OrderInfoRestController {

	@Autowired
	private OrderInfoController orderInfoController;

	@PostMapping("/add")
	ResponseModel<OrderInfoVO> add(@RequestBody OrderInfoInput orderInfoInput){
		ResponseModel<OrderInfoVO> response = new ResponseModel<>();
		try {
			orderInfoController.validate(orderInfoInput, ActionTypeConstant.ACTION_TYPE_ADD);
			OrderInfoVO orderInfoVO = orderInfoController.add(orderInfoInput);
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(orderInfoVO);
		} catch (CommonException e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.getErrorMsg());
		}
		return response;
	}
	
	@PostMapping("/update")
	ResponseModel<OrderInfoVO> update(@RequestBody OrderInfoInput orderInfoInput){
		ResponseModel<OrderInfoVO> response = new ResponseModel<>();
		try {
			orderInfoController.validate(orderInfoInput, ActionTypeConstant.ACTION_TYPE_UPDATE);
			OrderInfoVO orderInfoVO = orderInfoController.update(orderInfoInput);
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(orderInfoVO);
		} catch (CommonException e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.getErrorMsg());
		}
		return response;
	}

	@PostMapping("/delete")
	ResponseModel<OrderInfoVO> delete(@RequestBody OrderInfoInput orderInfoInput){
		ResponseModel<OrderInfoVO> response = new ResponseModel<>();
		try {
			orderInfoController.validate(orderInfoInput, ActionTypeConstant.ACTION_TYPE_DELETE);
			OrderInfoVO orderInfoVO = orderInfoController.delete(orderInfoInput);
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(orderInfoVO);
		} catch (CommonException e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.getErrorMsg());
		}
		return response;
	}

	@GetMapping("/findAll")
	ResponseModel<List<OrderInfoVO>> findAll(){
		ResponseModel<List<OrderInfoVO>> response = new ResponseModel<>();
		try {
			List<OrderInfoVO> orderInfoVOs = orderInfoController.findAll();
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(orderInfoVOs);
		} catch (Exception e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.toString());
		}
		return response;
	}
	
	@PostMapping("/findByCustomerInfoId")
	ResponseModel<List<OrderInfoVO>> findByCustomerInfoId(@RequestBody OrderInfoInput orderInfoInput){
		ResponseModel<List<OrderInfoVO>> response = new ResponseModel<>();
		try {
			orderInfoController.validate(orderInfoInput, ActionTypeConstant.ACTION_TYPE_FIND);
			List<OrderInfoVO> orderInfoVOs = orderInfoController.findByCustomerInfoId(orderInfoInput.getCustomerInfoId());
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(orderInfoVOs);
		} catch (Exception e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.toString());
		}
		return response;
	}
	
	
	

}
