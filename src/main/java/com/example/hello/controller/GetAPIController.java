package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
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
    public String querypram(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

            sb.append(entry.getKey() + " -- " + entry.getValue());


        });
        return sb.toString();
    }

    @GetMapping("/query-parameter2")
    public String querypram2(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + email + age;

    }


    @GetMapping("/query-parameter3")
    public String querypram3(UserRequest userRequest){

        System.out.println((userRequest.getName()));
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();

    }
        //same way as the one above, but it is more simple when we know the input.
    // go to "dto" package  to see another method-recommended method


}
