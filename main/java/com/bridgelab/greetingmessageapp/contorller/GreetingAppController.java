package com.bridgelab.greetingmessageapp.contorller;

import com.bridgelab.greetingmessageapp.dto.GreetingAppDTO;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingAppController {
    private static final String TEMPLATE = "Hello , %s !!";
    private static final AtomicLong count = new AtomicLong();

    @GetMapping("/getmessage")
    public GreetingAppDTO sayHello(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new GreetingAppDTO(count.incrementAndGet(), String.format(TEMPLATE, name));
    }
}
