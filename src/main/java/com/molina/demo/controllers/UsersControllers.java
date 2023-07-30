package com.molina.demo.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersControllers {

    @GetMapping
    public String getUsers() {
        return "Hellow http users";
    }

    // Query parameters to filter data
   /* @GetMapping
    public String getUsersQuer(@RequestParam(value = ("page")),@RequestParam(value =("limit"))) {
        return "";
    } */

    // path parameter
   @GetMapping(path="/{UserId}")
    public String getUser(@PathVariable String UserId) {
        return "Hellow http get user:"+UserId;
    }

    @PostMapping
    public String CreateUsers() {
        return " create users";
    }

    @PutMapping
    public  String UpdateUsers() {
        return " update users";
    }

    @DeleteMapping
    public String DeleteUsers() {
        return "delete users";
    }


}
