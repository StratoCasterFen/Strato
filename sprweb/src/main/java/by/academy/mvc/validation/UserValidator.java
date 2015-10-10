package by.academy.mvc.validation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.academy.dto.UserRoleDto;
import by.academy.service.srv.UserService;

@Component
public class UserValidator implements Validator {
	static Logger logger= Logger.getLogger(UserValidator.class.getName());
	
	@Autowired
	UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserRoleDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.info("++++++++ validate ++++++++++");
		UserRoleDto user = (UserRoleDto) target;
		
		ValidationUtils.rejectIfEmpty(errors, "userName", "user.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "user.password.empty");
		
		if (false
			|| user.getUserName()==null  
			|| user.getUserName().length() < 3)
		{errors.rejectValue("userName", "user.name.lessThen3");	}
		if (false
			|| user.getPassword()==null  
			|| user.getPassword().length() < 5)
		{errors.rejectValue("password", "user.password.lessThen5");}
		
		if (userService.getUserByName(user.getUserName())!=null){
			logger.error("user with that name allready exist");
			errors.rejectValue("userName", "user.name.exist");
		}	
	}

}
