package com.bridgelab.greetingmessageapp.service;

import com.bridgelab.greetingmessageapp.dto.GreetingAppDTO;
import com.bridgelab.greetingmessageapp.dto.GreetingUserDTO;
import com.bridgelab.greetingmessageapp.model.GreetingAppModel;

import java.util.List;
import java.util.Optional;

public interface IGreetingAppService {
    GreetingAppModel getMessage();


    GreetingAppModel greetingMessage(GreetingUserDTO greetingUserDTO);

    Optional<GreetingAppModel> message(long id);

    List<GreetingAppModel> getAllMessages();

    GreetingAppModel editMessage(long id, GreetingAppDTO greetingAppDTO);

    GreetingAppModel deleteMessage(long id);
}
