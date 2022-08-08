package com.bridgelab.greetingmessageapp.service;

import com.bridgelab.greetingmessageapp.dto.GreetingAppDTO;
import com.bridgelab.greetingmessageapp.dto.GreetingUserDTO;
import com.bridgelab.greetingmessageapp.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingAppService implements IGreetingAppService {
    private static final String TEMPLATE = "Hello ,%s ";
    private static final AtomicLong count = new AtomicLong();
    @Autowired
    private GreetingAppRepository greetingAppRepository;

    @Override
    public GreetingAppDTO getMessage() {
        return greetingAppRepository.save(new GreetingAppDTO(String.format(TEMPLATE, "Srinivas !!")));
    }

    @Override
    public GreetingAppDTO greetingMessage(GreetingUserDTO greetingUserDTO) {
        return greetingAppRepository.save(new GreetingAppDTO(String.format(TEMPLATE, greetingUserDTO.getFirstName()) + greetingUserDTO.getLastName()));
    }
}
