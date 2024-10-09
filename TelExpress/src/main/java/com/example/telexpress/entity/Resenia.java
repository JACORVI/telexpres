package com.example.telexpress.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="resenias")
public class Resenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idresenias;
    private String descripcion;
    private String calidad;
    private int puntuacion;
    @ManyToOne
    @JoinColumn(name = "productos_idproductos", nullable = false)
    private Producto producto;
}