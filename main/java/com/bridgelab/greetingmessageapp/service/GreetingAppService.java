package com.bridgelab.greetingmessageapp.service;

import com.bridgelab.greetingmessageapp.dto.GreetingAppDTO;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingAppService implements IGreetingAppService{
    private static final String TEMPLATE="Hello ,%s !!";
    private static final AtomicLong count=new AtomicLong();
    @Override
    public GreetingAppDTO getMessage() {
return new GreetingAppDTO(count.incrementAndGet(),String.format(TEMPLATE,"Srinivas !!"));
    }
}
