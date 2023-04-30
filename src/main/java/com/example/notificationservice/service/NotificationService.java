package com.example.notificationservice.service;

import com.example.notificationservice.client.UserServiceClient;
import com.example.notificationservice.dto.Picture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final UserServiceClient userServiceClient;
    public void notifyUserOnAccountExpiration(long pictureId) {
        var picture = userServiceClient.getPicture(pictureId);
        notifyUser(picture);
    }
    private void notifyUser(Picture picture){
        System.out.println("Dear user picture id " + picture.id() + " is about to expire");
    }
}
