package by.academy.mvc.validation;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.academy.mvc.init.WebAppCfg;
import by.academy.pojos.User;

@Component
public class UserValidator implements Validator {
	static Logger logger= Logger.getLogger(UserValidator.class.getName());
	
	private final static String EMPLOYEES_NUMBER = "emplNumber";

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.info("++++++++ validate ++++++++++");
		User user = (User) target;
		
	//	Integer emplNumber = user.getEmplNumber();
		
		ValidationUtils.rejectIfEmpty(errors, "userName", "user.name.empty");
	//	ValidationUtils.rejectIfEmpty(errors, EMPLOYEES_NUMBER, "shop.emplNumber.empty");
		
	//	if (emplNumber != null && emplNumber < 1)
	//		errors.rejectValue(EMPLOYEES_NUMBER, "shop.emplNumber.lessThenOne");

	}

}
