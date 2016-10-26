package shop.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import shop.entity.User;

/**
 * Created by Администратор on 25.10.2016.
 */
@Component
public class UserValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        User user =(User)o;
//        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\\\"(?:[\\\\x01-\\\\x08\\\\x0b\\\\x0c\\\\x0e-\\\\x1f\\\\x21\\\\x23-\\\\x5b\\\\x5d-\\\\x7f]|\\\\\\\\[\\\\x01-\\\\x09\\\\x0b\\\\x0c\\\\x0e-\\\\x7f])*\\\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\\\x01-\\\\x08\\\\x0b\\\\x0c\\\\x0e-\\\\x1f\\\\x21-\\\\x5a\\\\x53-\\\\x7f]|\\\\\\\\[\\\\x01-\\\\x09\\\\x0b\\\\x0c\\\\x0e-\\\\x7f])+)\\\\])");


//        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", "name.empty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName", "lastName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", "email.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "password.empty");
//

//        Matcher matcher;
//        if(!(matcher=pattern.matcher(user.getEmail())).matches()){
//            errors.rejectValue("email", "bad.email");
//        }
    }
}