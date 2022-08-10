package com.bridgelab.greetingmessageapp.service;

import com.bridgelab.greetingmessageapp.dto.GreetingAppDTO;
import com.bridgelab.greetingmessageapp.dto.GreetingUserDTO;
import com.bridgelab.greetingmessageapp.exception.GreetingMessageAppException;
import com.bridgelab.greetingmessageapp.model.GreetingAppModel;
import com.bridgelab.greetingmessageapp.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
            throw new GreetingMessageAppException(400, "Greeting not found");

        }

    }

    @Override
    public List<GreetingAppModel> getAllMessages() {
        List<GreetingAppModel> getAllMessages = greetingAppRepository.findAll();
        if (getAllMessages.size() > 0) {
            return getAllMessages;
        } else {
            throw new GreetingMessageAppException(400, "Greeting not found");

        }
    }

    @Override
    public GreetingAppModel editMessage(long id, GreetingAppDTO greetingAppDTO) {
        Optional<GreetingAppModel> isMessagePresent = greetingAppRepository.findById(id);
        if (isMessagePresent.isPresent()) {
            isMessagePresent.get().setMessage(greetingAppDTO.getMessage());
            greetingAppRepository.save(isMessagePresent.get());
            return isMessagePresent.get();
        } else {
            throw new GreetingMessageAppException(400, "Greeting not found");
        }
    }

    @Override
    public GreetingAppModel deleteMessage(long id) {
        Optional<GreetingAppModel> isIdPresent = greetingAppRepository.findById(id);
        if (isIdPresent.isPresent()) {
            greetingAppRepository.delete(isIdPresent.get());
            return isIdPresent.get();
        } else {
            throw new GreetingMessageAppException(400, "Greeting Not Found");
        }
    }

}
