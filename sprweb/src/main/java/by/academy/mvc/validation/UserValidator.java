package by.academy.mvc.validation;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.academy.dto.UserRoleDto;

@Component
public class UserValidator implements Validator {
	static Logger logger= Logger.getLogger(UserValidator.class.getName());
	

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRoleDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.info("++++++++ validate ++++++++++");
		UserRoleDto user = (UserRoleDto) target;
		
	//	Integer emplNumber = user.getEmplNumber();
		
		ValidationUtils.rejectIfEmpty(errors, "userName", "user.name.empty");
		
		ValidationUtils.rejectIfEmpty(errors, "password", "user.password.empty");
		
	//	if (emplNumber != null && emplNumber < 1)
	//		errors.rejectValue(EMPLOYEES_NUMBER, "shop.emplNumber.lessThenOne");

	}

}
