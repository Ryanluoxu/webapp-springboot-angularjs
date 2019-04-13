package io.ryanluoxu.customerManager.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.bean.vo.AuditTrailVO;
import io.ryanluoxu.customerManager.bean.vo.ResponseModel;
import io.ryanluoxu.customerManager.controller.AuditTrailController;

@RestController
@RequestMapping("/rest/auditTrail")
public class AuditTrailRestController {

	@Autowired
	private AuditTrailController userInfoController;

	@GetMapping("/findAll")
	ResponseModel<List<AuditTrailVO>> findAll(){
		ResponseModel<List<AuditTrailVO>> response = new ResponseModel<>();
		try {
			List<AuditTrailVO> userInfoVOs = userInfoController.findAll();
			response.setStatus(StatusConstant.RESPONSE_SUCCESS);
			response.setData(userInfoVOs);
		} catch (Exception e) {
			response.setStatus(StatusConstant.RESPONSE_FAIL);
			response.setErrorMsg(e.toString());
		}
		return response;
	}

}
