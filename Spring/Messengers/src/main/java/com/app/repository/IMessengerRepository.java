package com.app.repository;

import com.app.model.Messenger;

import java.util.List;

public interface IMessengerRepository {
    List<Messenger> getMessengers();
    Messenger getMenssengerById(int id);
}
