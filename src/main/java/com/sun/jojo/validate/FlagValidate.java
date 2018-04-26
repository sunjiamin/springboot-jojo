package com.sun.jojo.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * description: 自定义验证注解
 * 我们先来创建一个注解，注解内部需要对应验证注解的验证实现类，所以创建后会报错
 * Constraint注解，里面传入了一个validatedBy的字段，这个就是我们自定义注解的实现类的类型
 *
 * @author sunjiamin
 * @date 2018-04-25 15:11
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = FlagValidateClass.class)
public @interface FlagValidate {

    String values();

    String message() default "flag不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

//
//    //flag的有效值多个使用','隔开
//    String values();
//
//    //提示内容
//    String message() default "flag不存在";
//
//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default {};
}