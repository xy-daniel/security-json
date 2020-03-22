package org.javaboy.securityjson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daniel
 * @version 1.0.0
 * @date 2020/3/22 17:40
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello filter";
    }
}
