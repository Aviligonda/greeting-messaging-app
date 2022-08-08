package com.bridgelab.greetingmessageapp.service;

import com.bridgelab.greetingmessageapp.dto.GreetingUserDTO;
import com.bridgelab.greetingmessageapp.model.GreetingAppModel;

public interface IGreetingAppService {
    GreetingAppModel getMessage();


    GreetingAppModel greetingMessage(GreetingUserDTO greetingUserDTO);
}
