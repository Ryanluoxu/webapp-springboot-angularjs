package io.ryanluoxu.customerManager.validator;

import io.ryanluoxu.customerManager.base.exception.CommonException;

public interface BaseValidator<TInput> {

	void validateMandatoryFields(TInput input, String actionType) throws CommonException;
	void validateInputValue(TInput input, String actionType) throws CommonException;

}
