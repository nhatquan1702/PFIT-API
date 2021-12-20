package com.example.pfitapi.controller;

import com.example.pfitapi.dto.PnsRequest;
import com.example.pfitapi.entity.Status;
import com.example.pfitapi.service.FCMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushNotificationController {
    @Autowired
    private FCMService fcmService;

    @PostMapping("/notification")
    public ResponseEntity<?> sendSampleNotification(@RequestBody PnsRequest pnsRequest) {
        try {
            fcmService.pushNotification(pnsRequest);
            return ResponseEntity.ok(new Status(1));
        }
        catch(Exception e){
            return ResponseEntity.ok(new Status(0));
        }
    }
}
