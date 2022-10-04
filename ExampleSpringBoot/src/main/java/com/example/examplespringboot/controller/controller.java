package com.example.examplespringboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/calculation")
@CrossOrigin("*")
public class controller {

    @PostMapping(value = "/add/{a}/{b}")
    public ResponseEntity<?> add(@PathVariable("a") double a,@PathVariable("b") double b){
        double result = a + b;
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @PostMapping(value = "/sub/{a}/{b}")
    public ResponseEntity<?> Sub(@PathVariable("a") double a,@PathVariable("b") double b){
        double result = a - b;
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @PostMapping(value = "/multiple/{a}/{b}")
    public ResponseEntity<?> Multiple(@PathVariable("a") double a,@PathVariable("b") double b){
        double result = a * b;
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @PostMapping(value = "/devide/{a}/{b}")
    public ResponseEntity<?> devide(@PathVariable("a") double a, @PathVariable("b") double b){
        if(b == 0)
            return new ResponseEntity<>("can't devide 0" , HttpStatus.BAD_REQUEST);
        double result = a / b;
        return new ResponseEntity<>(result , HttpStatus.OK);
    }


}
