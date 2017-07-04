package com.aop.pack;

import com.aop.pack.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAOPTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AspectConfig.class);
        ctx.refresh();
        UserService userService = ctx.getBean(UserService.class);
        userService.multiply(2, 3);
//        userService.divide(5, 0);
    }
}
