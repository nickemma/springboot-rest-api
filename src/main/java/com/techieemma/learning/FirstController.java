package com.techieemma.learning;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

        @GetMapping("/products")
        public String hello() {
            return "Hello World from controller";
        }

        @PostMapping("/create")
        @ResponseStatus(HttpStatus.CREATED)
        public String create(@RequestBody String name) {
          return "Hello " + name;
       }
}
