package com.kc.learnings.spring.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
public class HelloWorldController {

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

}


