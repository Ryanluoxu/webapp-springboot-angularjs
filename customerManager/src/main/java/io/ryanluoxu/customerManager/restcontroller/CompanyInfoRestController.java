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
import io.ryanluoxu.customerManager.bean.input.CompanyInfoInput;
import io.ryanluoxu.customerManager.bean.vo.CompanyInfoVO;
import io.ryanluoxu.customerManager.bean.vo.ResponseModel;
import io.ryanluoxu.customerManager.controller.CompanyInfoController;

@RestController
@RequestMapping("/rest/companyInfo")
public class CompanyInfoRestController {

	@Autowired
	private CompanyInfoController companyInfoController;

	@PostMapping("/add")
	ResponseModel<CompanyInfoVO> add(@RequestBody CompanyInfoInput companyInfoInput){
		ResponseModel<CompanyInfoVO> response = new ResponseModel<>();
		try {
			companyInfoController.validate(companyInfoInput, ActionTypeConstant.ACTION_TYPE_ADD);
			CompanyInfoVO companyInfoVO = companyInfoController.add(companyInfoInput);
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(companyInfoVO);
		} catch (CommonException e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.getErrorMsg());
		}
		return response;
	}
	
	@PostMapping("/update")
	ResponseModel<CompanyInfoVO> update(@RequestBody CompanyInfoInput companyInfoInput){
		ResponseModel<CompanyInfoVO> response = new ResponseModel<>();
		try {
			companyInfoController.validate(companyInfoInput, ActionTypeConstant.ACTION_TYPE_UPDATE);
			CompanyInfoVO companyInfoVO = companyInfoController.update(companyInfoInput);
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(companyInfoVO);
		} catch (CommonException e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.getErrorMsg());
		}
		return response;
	}

	@PostMapping("/delete")
	ResponseModel<CompanyInfoVO> delete(@RequestBody CompanyInfoInput companyInfoInput){
		ResponseModel<CompanyInfoVO> response = new ResponseModel<>();
		try {
			companyInfoController.validate(companyInfoInput, ActionTypeConstant.ACTION_TYPE_DELETE);
			CompanyInfoVO companyInfoVO = companyInfoController.delete(companyInfoInput);
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(companyInfoVO);
		} catch (CommonException e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.getErrorMsg());
		}
		return response;
	}

	@GetMapping("/findAll")
	ResponseModel<List<CompanyInfoVO>> findAll(){
		ResponseModel<List<CompanyInfoVO>> response = new ResponseModel<>();
		try {
			List<CompanyInfoVO> companyInfoVOs = companyInfoController.findAll();
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(companyInfoVOs);
		} catch (Exception e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.toString());
		}
		return response;
	}

}
