package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by haoyuexun on 2018/7/5.
 */

public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
