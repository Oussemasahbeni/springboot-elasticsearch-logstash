package com.elasticsearch.demo.controller;

import com.elasticsearch.demo.models.UserElastic;
import com.elasticsearch.demo.models.UserPostgre;
import com.elasticsearch.demo.service.UserServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/count")
    private Long getCountUser(){
        return userService.getCount();
    }

    @GetMapping("")
    private Page<UserPostgre> geAllUser(@RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "20") Integer size){
        return userService.getAllUser(page,size);
    }

    @GetMapping("/elastic")
    private Page<UserElastic> geAllUserByElastic(@RequestParam(defaultValue = "0") Integer page,
                                                 @RequestParam(defaultValue = "20") Integer size){
        return userService.getAllUserForElastic(page,size);
    }

    @GetMapping("/elastic/count")
    private Long getCountByElastic(){
        return userService.getElasticCount();
    }

    @GetMapping("/elastic/name/{name}")
    private UserElastic getUserByNameFromElastic(@PathVariable(name = "name") String name){
        return userService.getUserByNameFromElastic(name);
    }

    @GetMapping("/name/{name}")
    private UserPostgre getUserByName(@PathVariable(name = "name") String name){
        return userService.getUserByName(name);
    }

}