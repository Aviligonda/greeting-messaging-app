package com.bridgelab.greetingmessageapp.contorller;

import com.bridgelab.greetingmessageapp.dto.GreetingAppDTO;
import com.bridgelab.greetingmessageapp.service.IGreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingAppController {
    private static final String TEMPLATE = "Hello , %s !!";
    private static final AtomicLong count = new AtomicLong();
    @Autowired
    IGreetingAppService greetingAppService;

    //UC1
    @GetMapping("/getmessage")
    public GreetingAppDTO sayHello(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new GreetingAppDTO(count.incrementAndGet(), String.format(TEMPLATE, name));
    }

    //UC2
    @GetMapping("/get")
    public GreetingAppDTO sayHello() {
        return greetingAppService.getMessage();
    }
}
