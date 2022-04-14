package com.github.guramkankava.restcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "rest")
@RestController
public class DemoRestController {

    @GetMapping(path = "demo")
    public ResponseEntity<String> demo () {
        return ResponseEntity.ok("Demo Reached");
    }

}
