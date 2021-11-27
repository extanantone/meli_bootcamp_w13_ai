package com.socialmeli.socialmeli.dto;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@NoArgsConstructor
public class ResponseSuccessfullyDTO {
    public Map<String,Object> buildJson(String detail){

        Map<String, Object> message = new HashMap<String, Object>();

        message.put("detail", detail);
        message.put("summary", "Successfully.");
        message.put("code", 200);

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("success", true);
        json.put("message", message);
        return json;
    }
}
