package com.aspire.traineesservices.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.aspire.traineesservices.exception.ErrorMessage;
import com.aspire.traineesservices.exception.Error;
/**
 * 
 * @author vinoth.madhu
 *
 */
public class ValidationUtil {
	
    private ValidationUtil()
    {
    	
    }
    /**
     * 
     * @param bindingResult
     * @return
     */
    public static ErrorMessage getErrorMessage(BindingResult bindingResult)
    {
        ErrorMessage errorMessage = new ErrorMessage();
        for (Object object : bindingResult.getAllErrors())
        {
            if (object instanceof FieldError)
            {
                FieldError fieldError = (FieldError) object;
                errorMessage.addError(new Error(fieldError.getDefaultMessage(), fieldError.getField()));
                System.out.println("1----"+fieldError.getDefaultMessage()+fieldError.getField());
            }
        }

        return errorMessage;
    }
}
