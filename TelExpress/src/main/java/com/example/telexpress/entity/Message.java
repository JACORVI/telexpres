// Ubicación: /src/main/java/com/example/chatapp/entity/Message.java

package com.example.telexpress.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

    // Contenido del mensaje
    private String content;

    // Nombre del usuario que envía el mensaje
    private String sender;

    // Sala de chat a la que pertenece el mensaje
    private String room;
}
