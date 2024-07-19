package com.techieemma.learning;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

        @GetMapping("/hello")
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public String hello() {
            return "Hello World from controller";
        }
}
