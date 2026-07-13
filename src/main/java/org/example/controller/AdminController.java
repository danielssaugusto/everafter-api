package org.example.controller;

import org.example.dto.CreateGuestsListRequest;
import org.example.model.Admin;
import org.example.model.GuestsList;
import org.example.service.AdminService;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final UserService userService;

    public AdminController(
            AdminService adminService,
            UserService userService
    ) {
        this.adminService = adminService;
        this.userService = userService;
    }

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