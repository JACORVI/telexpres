package com.example.telexpress.repository;


import com.example.telexpress.entity.Proveedor;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    long countByEstadoProveedor(String estado);
}
