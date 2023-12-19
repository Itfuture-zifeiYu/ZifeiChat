package com.zifeiyu.zifeichat.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: wxh
 * @version:
 * @date: 2023/12/19 16:35
 * @description:
 */
@SpringBootApplication(scanBasePackages = {"com.zifeiyu.zifeichat"})
@ServletComponentScan
public class ZifeichatCustomApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZifeichatCustomApplication.class,args);
    }
}
