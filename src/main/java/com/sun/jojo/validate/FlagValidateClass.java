package com.sun.jojo.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-04-25 15:14
 */
public class FlagValidateClass implements ConstraintValidator<FlagValidate,Object> {

    /**
     * 临时变量保存flag 列表
     */
    String values;
    
    @Override
    public void initialize(FlagValidate constraintAnnotation) {
        this.values = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        String[] value_array = values.split(",");
        boolean isValid = false;
        for (String s : value_array) {
            if(s.equals(o)){
                isValid = true;
                break;
            }
        }
        return isValid;
    }
}
