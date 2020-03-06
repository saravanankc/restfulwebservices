package com.kc.learnings.spring.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.Locale;

//@Controller
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    //@RequestMapping(method = RequestMethod.GET, path = "/hello-world") //Alternatively use @GetMapping
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

//    @GetMapping(path = "/hello-world-internationalized")
//    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required = false) Locale locale){
//        return messageSource.getMessage("good.morning.message", null, locale);
//    }


    //Instead of pass locale parameter to controller method, user LocalContectHolder.getLocale() to automatically detect Accept-Language header
    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(){
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
}


