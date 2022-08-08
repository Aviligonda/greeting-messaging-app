package com.bridgelab.greetingmessageapp.service;

import com.bridgelab.greetingmessageapp.dto.GreetingAppDTO;
import org.springframework.web.bind.annotation.RequestParam;

public interface IGreetingAppService {
    GreetingAppDTO getMessage( );
}
