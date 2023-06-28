package com.alkemy.disney.controller;

import com.alkemy.disney.dto.post.UserPostDto;
import com.alkemy.disney.security.model.dto.MessageDto;
import com.alkemy.disney.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Validated
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<MessageDto> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false, userService.findAll()));
    }

    @GetMapping("/{identification}")
    public ResponseEntity<MessageDto> findUserByIdentification(@PathVariable Long identification) throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false,
                userService.findUserByIdentification(identification)));
    }

    @GetMapping("/find/{email}")
    public ResponseEntity<MessageDto> findUserByEmail(@PathVariable String email) throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false,
                userService.findUserByEmail(email)));
    }

    @PutMapping()
    public ResponseEntity<MessageDto> update(@Valid @RequestBody UserPostDto userPostDto) throws Exception {
        userService.update(userPostDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDto(HttpStatus.CREATED,
                false, "The user is updated correctly"));
    }

    @DeleteMapping("/{identification}")
    public ResponseEntity<MessageDto> delete(@PathVariable Long identification) throws Exception {
        userService.delete(identification);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(HttpStatus.OK, false,
                "Correctly eliminated"));
    }
}
