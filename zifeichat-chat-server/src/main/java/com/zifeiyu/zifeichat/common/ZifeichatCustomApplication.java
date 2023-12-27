package com.zifeiyu.zifeichat.common;

import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan({"com.zifeiyu.zifeichat.common.**.mapper"})
public class ZifeichatCustomApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZifeichatCustomApplication.class,args);
    }
}
