package com.techieemma.learning;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

        @GetMapping("/hello")
        public String hello() {
            return "Hello World from controller";
        }

        @PostMapping("/create")
        @ResponseStatus(HttpStatus.CREATED)
        public String create(@RequestBody String name) {
          return "Hello " + name;
       }

    @PostMapping("/order")
    public String postOrder(@RequestBody OrderRecord order) {
        return "Hello " + order.toString();
    }
}
