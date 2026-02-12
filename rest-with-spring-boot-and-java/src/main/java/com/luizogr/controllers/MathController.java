package com.luizogr.controllers;

import com.luizogr.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private MathService service;

    @RequestMapping("/sum/{num1}/{num2}")
    public Double sum(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception{
        return service.sum(num1, num2);
    }

    @RequestMapping("/subtraction/{num1}/{num2}")
    public Double subtraction(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception{
        return service.subtraction(num1, num2);
    }

    @RequestMapping("/multiplication/{num1}/{num2}")
    public Double multiplication(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception{
        return service.multiplication(num1, num2);
    }

    @RequestMapping("/division/{num1}/{num2}")
    public Double division(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception{
        return service.division(num1, num2);
    }

    @RequestMapping("/mean/{num1}/{num2}")
    public Double mean(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception{
        return service.mean(num1, num2);
    }

    @RequestMapping("/squareRoot/{num}")
    public Double squareRoot(@PathVariable("num") String num) throws Exception{
        return service.squareRoot(num);
    }


}
