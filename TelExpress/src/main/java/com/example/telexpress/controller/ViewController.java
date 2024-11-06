// Ubicación: /src/main/java/com/example/chatapp/controller/ViewController.java

package com.example.telexpress.controller;

import com.example.telexpress.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class ViewController {

    @Autowired
    private ChatRoomService chatRoomService;

    // Página principal de inicio
    @GetMapping("/home")
    public String getHomePage() {
        return "home";
    }

    // Página de monitor de salas activas
    @GetMapping("/monitor")
    public ModelAndView getMonitorPage() {
        ModelAndView modelAndView = new ModelAndView("monitor");

        // Obtener las salas activas del servicio
        Set<String> activeRooms = chatRoomService.getActiveRooms();
        modelAndView.addObject("activeRooms", activeRooms);

        return modelAndView;
    }

    // Página para unirse al chat (unir al usuario o monitor a una sala existente)
    @GetMapping("/chat")
    public ModelAndView getChatPage(String room, String name) {
        ModelAndView modelAndView = new ModelAndView("chat");
        modelAndView.addObject("room", room);
        modelAndView.addObject("name", name);
        return modelAndView;
    }

    // Unirse a una sala desde el monitor
    @GetMapping("/join-chat")
    public ModelAndView joinChat(@RequestParam("name") String name) {
        // Crear o redirigir al usuario a su sala
        String room = chatRoomService.createOrJoin(name);

        // Redirigir al usuario a la sala asignada
        ModelAndView modelAndView = new ModelAndView("redirect:/chat");
        modelAndView.addObject("room", room);
        modelAndView.addObject("name", name);
        return modelAndView;
    }

    @GetMapping("/join-chat-admin")
    public ModelAndView joinChatAdmin(@RequestParam("name") String name, @RequestParam("room") String room) {
        // Crear o redirigir al usuario a su sala


        // Redirigir al usuario a la sala asignada
        ModelAndView modelAndView = new ModelAndView("redirect:/chat");
        modelAndView.addObject("room", room);
        modelAndView.addObject("name", name);
        return modelAndView;
    }



}