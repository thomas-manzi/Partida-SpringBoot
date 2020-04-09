package com.spring.partida.controller;

import com.spring.partida.models.Partida;
import com.spring.partida.repository.PartidaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import java.util.List;

@RestController
@RequestMapping({"/partida"})
public class PartidaController {

    private PartidaRepository pr;

    PartidaController (PartidaRepository repo){
        this.pr = repo;
    }

    @GetMapping
    public List findAll(){
        return pr.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return pr.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Partida newMatch(@RequestBody Partida partida){
        return pr.save(partida);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delMatch(@PathVariable long id){
        return pr.findById(id)
                .map(record -> {
                    pr.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
