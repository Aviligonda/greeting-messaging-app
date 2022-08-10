package com.bridgelab.greetingmessageapp.model;

import com.bridgelab.greetingmessageapp.dto.GreetingAppDTO;
import com.bridgelab.greetingmessageapp.dto.GreetingUserDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class GreetingAppModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String message;


    public GreetingAppModel(String message) {
        this.message = message;
    }

    public GreetingAppModel() {

    }
}
