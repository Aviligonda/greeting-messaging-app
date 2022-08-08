package com.bridgelab.greetingmessageapp.service;

import com.bridgelab.greetingmessageapp.dto.GreetingAppDTO;
import com.bridgelab.greetingmessageapp.dto.GreetingUserDTO;

public interface IGreetingAppService {
    GreetingAppDTO getMessage();


    GreetingAppDTO greetingMessage(GreetingUserDTO greetingUserDTO);
}
