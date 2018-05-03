package com.sun.jojo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-05-03 08:34
 */
@Controller
@RequestMapping(value = "error")
public class BaseErrorController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "error/error";
    }

    @RequestMapping
    public String error() {
        return getErrorPath();
    }
}
