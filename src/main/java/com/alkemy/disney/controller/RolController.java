package com.alkemy.disney.controller;

import com.alkemy.disney.dto.post.RolPostDto;
import com.alkemy.disney.security.model.dto.MessageDto;
import com.alkemy.disney.service.RolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
@Validated
public class RolController {

    private final RolService rolService;

    @GetMapping()
    public ResponseEntity<MessageDto<java.util.List<com.alkemy.disney.dto.get.RolGetDto>>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto<>(HttpStatus.OK, false, rolService.findAll()));
    }

    @GetMapping("/{rolName}")
    public ResponseEntity<MessageDto<Long>> findIdByName(@PathVariable String rolName) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto<>(HttpStatus.OK, false, rolService.findIdByName(rolName)));
    }

    @PostMapping()
    public ResponseEntity<MessageDto<Boolean>> save(@Valid @RequestBody RolPostDto rolPostDto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto<>(HttpStatus.OK, false, rolService.create(rolPostDto)));
    }

    @PutMapping()
    public ResponseEntity<MessageDto<Boolean>> update(@Valid @RequestBody RolPostDto rolPostDto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto<>(HttpStatus.OK, false, rolService.update(rolPostDto)));

    }

    @DeleteMapping("/{rolName}")
    public ResponseEntity<MessageDto<Boolean>> delete(@PathVariable String rolName) throws Exception {
        rolService.delete(rolName);

        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto<>(HttpStatus.OK, false, true));
    }
}
