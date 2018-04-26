package com.sun.jojo.controller;

import com.sun.jojo.model.Person;
import com.sun.jojo.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-04-24 15:43
 */
@RestController
@RequestMapping(value = "/api")
public class HelloController  {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private PersonService personService;

    /**
     * logback
     */
    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "hello")
    public   Person sayHello(@Valid @RequestBody Person person, BindingResult result){
        logger.debug("记录debug日志");
        logger.info("访问了index方法");
        logger.error("记录error错误日志");
        return person;
    }

    @RequestMapping(value = "personlist")
    public   List<Person> sayHello(){

        return personService.list();
    }

    /**
     * SpringBoot因为采用了hibernate-validator，所以我们直接使用hibernate-validator就可以进行数据校验
     * @param person
     * @param result
     * @return
     */
    @RequestMapping(value = "valid")
    public String validHello(@Valid @RequestBody Person person, BindingResult result){
        logger.debug("记录debug日志");
        logger.info("访问了index方法");
        logger.error("记录error错误日志");
        System.out.println("控制台输出日志");
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            Locale locale = LocaleContextHolder.getLocale();
            StringBuilder sb = new StringBuilder();
            for (FieldError fieldError : fieldErrors) {
                String message = messageSource.getMessage(fieldError, locale);
                sb.append(fieldError.getField()+" "+message+" ");
            }
            return sb.toString();
        }

        return person.toString();
    }

    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,

                                          HttpServletRequest request) {
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/upload");
            String filePath = realPath+"/file/";

            System.out.println(filePath);

            File file1 = new File(filePath);
            if(!file1.exists()){
                file1.mkdir();
            }
            executeUpload(filePath,file);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传文件失败";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "上传成功";
    }

    @RequestMapping(value = "multiupload",method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile[] file,

                                          HttpServletRequest request) {
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/upload");
            String filePath = realPath+"file/";

            System.out.println(filePath);

            File file1 = new File(filePath);
            if(!file1.exists()){
                file1.mkdir();
            }
            for (MultipartFile multipartFile : file) {
                executeUpload(filePath,multipartFile);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "上传文件失败";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "上传成功";
    }

    //

    /**
     * 提取上传方法为公共方法
     * @param uploadDir 上传文件目录
     * @param file 上传对象
     * @throws Exception
     */
    private void executeUpload(String uploadDir,MultipartFile file) throws Exception
    {
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }



}
