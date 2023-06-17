package com.alkemy.disney.controller;

import com.alkemy.disney.dto.get.RolGetDto;
import com.alkemy.disney.dto.post.RolPostDto;
import com.alkemy.disney.service.RolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
@Validated
public class RolController {

    private final RolService rolService;
    @GetMapping()
    public ResponseEntity<List<RolGetDto>> findAll(){
        return ResponseEntity.ok(rolService.findAll());
    }

    @GetMapping("/{rolName}")
    public ResponseEntity<Long> findIdByName(@PathVariable String rolName) throws Exception {
        return ResponseEntity.ok(rolService.findIdByName(rolName));
    }

    @PostMapping()
    public ResponseEntity<Boolean> save(@Valid  @RequestBody RolPostDto rolPostDto) throws Exception {
        return ResponseEntity.ok(rolService.create(rolPostDto));
    }

    @PutMapping()
    public ResponseEntity<Boolean> update(@Valid @RequestBody RolPostDto rolPostDto) throws Exception {
        return ResponseEntity.ok(rolService.update(rolPostDto));
    }

    @DeleteMapping("/{rolName}")
    public ResponseEntity<Boolean> delete(@PathVariable String rolName) throws Exception {
         rolService.delete(rolName);
         return ResponseEntity.ok(true);
    }
}
