package com.messenger.messenger.model;

public class Telegraph implements Courier{
    private final int messengerType = 1;
    private final String messengerName = "Telegraph";

    @Override
    public String showMessage(String message) {
        return "Pip piripipip pip pip <<"+message+"!>>\n";
    }

    @Override
    public String getMessengerName() {
        return messengerName;
    }
}
