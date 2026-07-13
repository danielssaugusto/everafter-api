package org.example.controller;

import org.example.dto.CreateGuestsListRequest;
import org.example.model.Admin;
import org.example.model.GuestsList;
import org.example.model.User;
import org.example.service.AdminService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @PostMapping("/lists")
    public GuestsList createList(@RequestBody CreateGuestsListRequest request) {
        return adminService.createList(
                request.getListName(),
                request.getIdsGuests()
        );
    }

    @PostMapping("/register")
    public void registerAdmin(@RequestBody Admin admin) {
        userService.registerUser(admin);
    }

    @GetMapping("/test")
    public String test() {
        return "AdminController funcionando!";
    }
}

