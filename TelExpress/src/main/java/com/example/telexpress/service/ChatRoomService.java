// Ubicación: /src/main/java/com/example/chatapp/service/ChatRoomService.java

package com.example.telexpress.service;

import com.example.telexpress.entity.Usuario;
import com.example.telexpress.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChatRoomService {

    private final Map<String, Set<String>> roomUsers = new HashMap<>();
    private final Set<String> activeRooms = new HashSet<>();

    @Autowired
    private UsuarioRepository usuarioRepository; // Asegúrate de tener este repositorio

    @PostConstruct
    public void initializeRooms() {
        // Obtener todos los usuarios de la base de datos
        List<Usuario> usuarios = usuarioRepository.findAll();

        for (Usuario usuario : usuarios) {
            if (usuario.getIdSuperior() != null) {
                String roomId = "chat" +" "+ usuario.getIdSuperior();
                activeRooms.add(roomId);

                // Añadir el cliente y el agente al room
                roomUsers.putIfAbsent(roomId, new HashSet<>());
                roomUsers.get(roomId).add(usuario.getNombre());
                roomUsers.get(roomId).add(usuario.getIdSuperior());
            }
        }
    }

    private String getAgenteName(Integer id) {
        // Este método debería obtener el nombre del agente basado en su ID
        Usuario agente = usuarioRepository.findById(id);
        return agente != null ? agente.getNombre() : "Agente Desconocido";
    }
    public void markRoomAsActive(String room) {
        activeRooms.add(room);
    }
    public Set<String> getActiveRooms() {
        return activeRooms;
    }
    public String createOrJoinRoom(String userName) {
        // Lógica para crear o unirse a una sala de chat
        String roomId = "room_" + userName;
        // Aquí puedes agregar lógica para verificar si el room ya existe
        return roomId;
    }

    public String createOrJoin(String userName) {
        // Lógica para crear o unirse a una sala de chat
        String roomId = "room_" + userName;
        // Aquí puedes agregar lógica para verificar si el room ya existe
        return roomId;
    }
}
