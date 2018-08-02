package com.sun.jojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JojoApplication {

	public static void main(String[] args) {
		/**
		 * 隐藏banner启动方式
		 *
		 * SpringApplication springApplication = new SpringApplication(JojoApplication.class);
		 * //设置banner的模式为隐藏
		 * springApplication.setBannerMode(Banner.Mode.OFF);
		 * //启动springboot应用程序
		 * springApplication.run(args);
         */
		SpringApplication.run(JojoApplication.class, args);
	}
}
