package com.bridgelab.greetingmessageapp.repository;

import com.bridgelab.greetingmessageapp.dto.GreetingAppDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingAppRepository extends JpaRepository<GreetingAppDTO, Long> {
}
