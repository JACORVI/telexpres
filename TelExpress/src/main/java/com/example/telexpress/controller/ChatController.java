// Ubicación: /src/main/java/com/example/chatapp/controller/ChatController.java

package com.example.telexpress.controller;

import com.example.telexpress.entity.Message;
import com.example.telexpress.entity.Usuario;
import com.example.telexpress.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {

    @Autowired
    private ChatRoomService chatRoomService;

    @MessageMapping("/chat/{room}")
    @SendTo("/topic/room/{room}")
    public Message sendMessage(@DestinationVariable String room, Message message, SimpMessageHeaderAccessor headerAccessor) {
        chatRoomService.markRoomAsActive(room);

        // Devolver el mensaje si todo está bien
        return message;
    }
}
