package org.example;

import org.example.service.AdminService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.CommandLinePropertySource;

import java.util.Collections;

public class Runner implements CommandLineRunner {

    private final AdminService adminService;

    public Runner(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public void run(String... args) {
        var lista = adminService.createList(
                "Lista de Casamento",
                Collections.singletonList(12345677L));

        System.out.println(lista);
    }}