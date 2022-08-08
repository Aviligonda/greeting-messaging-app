package com.bridgelab.greetingmessageapp.repository;

import com.bridgelab.greetingmessageapp.model.GreetingAppModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingAppRepository extends JpaRepository<GreetingAppModel, Long> {
}
