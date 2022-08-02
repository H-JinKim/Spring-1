package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetAPIController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
//two are the same. the one below is the old way
    @RequestMapping(path ="/hi", method = RequestMethod.GET)
    public String hi(){
        return "Hi";
    }

    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name = "id") String pathName){
        System.out.println("Path variable = "+pathName);
        return pathName;
    }

    @GetMapping("/query-parameter")
    public String querypram(@RequestParam Map<String, String>queryParam){
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

            sb.append(entry.getKey() + " -- " + entry.getValue());


        });
        return sb.toString();
    }



}
