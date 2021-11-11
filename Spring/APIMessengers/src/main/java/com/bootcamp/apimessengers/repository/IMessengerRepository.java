package com.bootcamp.apimessengers.repository;

import com.bootcamp.apimessengers.entitiy.Messenger;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface IMessengerRepository {

    Optional<Messenger> getMessenger(Long idMessenger);

    Set<Map.Entry<Long,Messenger>> findAll();
}
