package io.ryanluoxu.customerManager.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ryanluoxu.customerManager.base.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.bean.input.ProductInfoInput;
import io.ryanluoxu.customerManager.bean.vo.ProductInfoVO;
import io.ryanluoxu.customerManager.bean.vo.ResponseModel;
import io.ryanluoxu.customerManager.controller.ProductInfoController;

@RestController
@RequestMapping("/rest/productInfo")
@Secured("ROLE_USER")
public class ProductInfoRestController {

	@Autowired
	private ProductInfoController productInfoController;

	@PostMapping("/add")
	ResponseModel<ProductInfoVO> add(@RequestBody ProductInfoInput productInfoInput){
		ResponseModel<ProductInfoVO> response = new ResponseModel<>();
		try {
			productInfoController.validate(productInfoInput, ActionTypeConstant.ACTION_TYPE_ADD);
			ProductInfoVO productInfoVO = productInfoController.add(productInfoInput);
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(productInfoVO);
		} catch (CommonException e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.getErrorMsg());
		}
		return response;
	}
	
	@PostMapping("/update")
	ResponseModel<ProductInfoVO> update(@RequestBody ProductInfoInput productInfoInput){
		ResponseModel<ProductInfoVO> response = new ResponseModel<>();
		try {
			productInfoController.validate(productInfoInput, ActionTypeConstant.ACTION_TYPE_UPDATE);
			ProductInfoVO productInfoVO = productInfoController.update(productInfoInput);
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(productInfoVO);
		} catch (CommonException e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.getErrorMsg());
		}
		return response;
	}

	@PostMapping("/delete")
	ResponseModel<ProductInfoVO> delete(@RequestBody ProductInfoInput productInfoInput){
		ResponseModel<ProductInfoVO> response = new ResponseModel<>();
		try {
			productInfoController.validate(productInfoInput, ActionTypeConstant.ACTION_TYPE_DELETE);
			ProductInfoVO productInfoVO = productInfoController.delete(productInfoInput);
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(productInfoVO);
		} catch (CommonException e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.getErrorMsg());
		}
		return response;
	}

	@GetMapping("/findAll")
	ResponseModel<List<ProductInfoVO>> findAll(){
		ResponseModel<List<ProductInfoVO>> response = new ResponseModel<>();
		try {
			List<ProductInfoVO> productInfoVOs = productInfoController.findAll();
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(productInfoVOs);
		} catch (Exception e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.toString());
		}
		return response;
	}

}
