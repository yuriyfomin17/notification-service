package com.example.notificationservice.controller;

import com.example.notificationservice.dto.Picture;
import com.example.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping
    public void notifyUserOnAccountExpiration(@RequestBody Picture picture) {
        notificationService.notifyUserOnAccountExpiration(picture.id());
    }
}