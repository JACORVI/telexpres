package com.example.telexpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuperAdminController {



    @GetMapping("")
    public String index(){

        return "SuperAdmin/inicio_superadmin";
    }

    @GetMapping("/dashboard_superadmin")
    public String dashboardSuperadmin() {


        return "SuperAdmin/dashboard_superadmin";
    }

    @GetMapping("/inventario_superadmin")
    public String inventarioSuperadmin() {


        return "SuperAdmin/inventario_superadmin";
    }

    @GetMapping("/gestion_coordinadores")
    public String gestionCoordinadoresSuperadmin() {


        return "SuperAdmin/gestion_coordinadores";
    }

    @GetMapping("/gestion_usuarios")
    public String gestionUsuariosSuperadmin() {


        return "SuperAdmin/gestion_usuarios";
    }

    @GetMapping("/gestion_agentes")
    public String gestionAgentesSuperadmin() {


        return "SuperAdmin/gestion_agentes";
    }



}