package com.bridgelab.greetingmessageapp.service;

import com.bridgelab.greetingmessageapp.dto.GreetingUserDTO;
import com.bridgelab.greetingmessageapp.model.GreetingAppModel;
import com.bridgelab.greetingmessageapp.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingAppService implements IGreetingAppService {
    private static final String TEMPLATE = "Hello ,%s ";
    private static final AtomicLong count = new AtomicLong();
    @Autowired
    private GreetingAppRepository greetingAppRepository;

    @Override
    public GreetingAppModel getMessage() {
        return greetingAppRepository.save(new GreetingAppModel(String.format(TEMPLATE, "Srinivas !!")));
    }

    @Override
    public GreetingAppModel greetingMessage(GreetingUserDTO greetingUserDTO) {
        return greetingAppRepository.save(new GreetingAppModel(String.format(TEMPLATE, greetingUserDTO.getFirstName()) + greetingUserDTO.getLastName()));
    }

    @Override
    public Optional<GreetingAppModel> message(long id) {
        Optional<GreetingAppModel> getMessage = greetingAppRepository.findById(id);
        if (getMessage.isPresent()) {

            return getMessage;
        } else {
            throw new RuntimeException();
        }

    }
}
