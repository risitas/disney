package com.alkemy.disney.controller;

import com.alkemy.disney.dto.post.UserPostDto;
import com.alkemy.disney.security.model.dto.MessageDto;
import com.alkemy.disney.security.model.dto.SessionDTO;
import com.alkemy.disney.service.SessionService;
import com.alkemy.disney.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
@Validated
public class AuthController {

    private final UserService userService;
    private final SessionService sessionService;

    @PostMapping("/login")
    public ResponseEntity<MessageDto> login(@Valid @RequestBody SessionDTO loginUser) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false,
                sessionService.login(loginUser)));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<MessageDto> createUser(@Valid @RequestBody UserPostDto user) throws Exception {
        userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDto(HttpStatus.CREATED,
                false, "User successfully created"));
    }

}
