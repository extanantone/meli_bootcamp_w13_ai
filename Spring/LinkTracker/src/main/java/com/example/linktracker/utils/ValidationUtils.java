package com.example.linktracker.utils;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class ValidationUtils {
    public boolean isValidURL(String url){
        if(url == null){
            return false;
        } else {
            URI uri;
            try {
                uri = new URI(url);
            } catch (URISyntaxException var5) {
                return false;
            }

        }
        return true;
    }

}
