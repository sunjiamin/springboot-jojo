package com.sun.jojo.model;

import com.sun.jojo.validate.FlagValidate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-04-24 15:51
 */
public class Person implements Serializable {

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @NotBlank
    @Length(min =4,max = 20)
    private String name;

    @Min(value = 18)
    private int age;

    /**
     * 自定义验证 字段flag，需要验证flag字段内容仅为1,2,3
     */
    @FlagValidate(values = "1,2,3")
    private String flag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
