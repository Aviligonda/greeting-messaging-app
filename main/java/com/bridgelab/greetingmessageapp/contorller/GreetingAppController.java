package com.bridgelab.greetingmessageapp.contorller;

import com.bridgelab.greetingmessageapp.dto.GreetingAppDTO;
import com.bridgelab.greetingmessageapp.dto.GreetingUserDTO;
import com.bridgelab.greetingmessageapp.model.GreetingAppModel;
import com.bridgelab.greetingmessageapp.service.IGreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
    public GreetingAppModel sayHello() {
        return greetingAppService.getMessage();
    }

    //UC3
    @PostMapping("/post")
    private GreetingAppModel sayHello(@RequestBody GreetingUserDTO greetingUserDTO) {
        return greetingAppService.greetingMessage(greetingUserDTO);
    }

    //UC5
    @GetMapping("/readdata/{id}")
    public Optional<GreetingAppModel> getMessage(@PathVariable long id) {
        return greetingAppService.message(id);
    }

    //UC6
    @GetMapping("/readalldata")
    public List<GreetingAppModel> getAllMessages() {
        return greetingAppService.getAllMessages();
    }

    //UC7
    @PutMapping("editmessage/{id}")
    public GreetingAppModel editMessage(@PathVariable long id, @RequestBody GreetingAppDTO greetingAppDTO) {
        return greetingAppService.editMessage(id, greetingAppDTO);
    }

    //UC8
    @DeleteMapping("deletemessage/{id}")
    public GreetingAppModel deleteMessage(@PathVariable long id) {
        return greetingAppService.deleteMessage(id);
    }
}
