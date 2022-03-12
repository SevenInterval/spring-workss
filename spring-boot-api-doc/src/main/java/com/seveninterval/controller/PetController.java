package com.seveninterval.controller;

import com.seveninterval.dto.Pet;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "Benim Pet API Dokümantasyonum")
public class PetController {

    private List<Pet> petList = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Pet> kaydet(@RequestBody Pet pet) {
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> tumunuListele() {
        return ResponseEntity.ok(petList);
    }
}
