package com.example.Extreme.controllers;

import com.example.Extreme.models.Klub;
import com.example.Extreme.services.KlubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/klub")
public class KlubController {
    private final KlubService klubService;

    @Autowired
    private KlubController(KlubService klubService) {
        this.klubService = klubService;
    }

    @GetMapping
    public ResponseEntity<List<Klub>> getWszystkie() {
        return ResponseEntity.ok(klubService.pobierzWszystkie());
    }

    @PostMapping
    public ResponseEntity<Klub> dodajKlub(@RequestBody Klub klub) {
        Klub response = klubService.dodajKlub(klub);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> usunKlub(@PathVariable("id") Long id) {
        klubService.usun(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
