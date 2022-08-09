package com.bridgelab.greetingmessageapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class GreetingAppModel {
    String message;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public GreetingAppModel(String message) {
        this.message = message;
    }

    public GreetingAppModel() {

    }
}
