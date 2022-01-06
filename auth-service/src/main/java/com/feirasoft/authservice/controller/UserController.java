package com.feirasoft.authservice.controller;

import com.feirasoft.authservice.dto.ProfileDto;
import com.feirasoft.authservice.dto.UserDto;
import com.feirasoft.authservice.model.User;
import com.feirasoft.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService service;

    @GetMapping
    public ResponseEntity retrieveAllUsers(Principal principal) {
        if(principal == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Collection<UserDto> users = service.retrieveAllUsers(user.getUsername());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/profile")
    public ResponseEntity getUserDetails(Principal principal) {
        if(principal == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        UserDto userDto = service.getUserDetails(principal.getName());

        if (userDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/profile")
    public ResponseEntity addUserDetails(@RequestBody ProfileDto profileDto, Principal principal) {
        if(principal == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        UserDto user = service.getUserDetails(principal.getName());
        service.addUserProfile(profileDto, user.getId());
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/profile")
    public ResponseEntity updateUserDetails(@RequestBody ProfileDto profileDto, Principal principal) {
        if(principal == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        UserDto user = service.getUserDetails(principal.getName());
        service.updateUserProfile(profileDto, user.getId());
        return ResponseEntity.noContent().build();
    }
}
