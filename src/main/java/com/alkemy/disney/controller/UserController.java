package com.alkemy.disney.controller;

import com.alkemy.disney.dto.get.RolGetDto;
import com.alkemy.disney.dto.get.UserGetDto;
import com.alkemy.disney.dto.post.RolPostDto;
import com.alkemy.disney.dto.post.UserPostDto;
import com.alkemy.disney.security.model.dto.MessageDto;
import com.alkemy.disney.service.RolService;
import com.alkemy.disney.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Validated
public class UserController {

    private final UserService userService;
    @GetMapping()
    public ResponseEntity<List<UserGetDto>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{identification}")
    public ResponseEntity<MessageDto> findUserByIdentification(@PathVariable Long identification) throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body( new MessageDto(HttpStatus.OK, false,
                userService.findUserByIdentification(identification) ));
    }

    @GetMapping("/find/{email}")
    public ResponseEntity<MessageDto> findUserByEmail(@PathVariable String email) throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body( new MessageDto(HttpStatus.OK, false,
                userService.findUserByEmail(email) ));
    }

    @PostMapping()
    public ResponseEntity<MessageDto> save(@Valid  @RequestBody UserPostDto userPostDto) throws Exception {

       userService.create(userPostDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDto(HttpStatus.CREATED,
                false, "The user is successfully created"));
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
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDto(HttpStatus.OK, false,
                "Correctly eliminated" ) );
    }
}
