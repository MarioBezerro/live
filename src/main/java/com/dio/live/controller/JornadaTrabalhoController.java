package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = {"/jornada"}, method = RequestMethod.GET)
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaList() {
        return jornadaService.findAll();
    }

    @GetMapping("/{idjornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaById(@PathVariable("idjornada") Long idjornada) {
        return ResponseEntity.ok(jornadaService.getByID(idjornada).orElseThrow(() -> new NoSuchElementException("Not found")));
    }

    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaService.updateJornada(jornadaTrabalho);
    }


    @DeleteMapping("/{idjornada}")
    public ResponseEntity<JornadaTrabalho> deleteById(@PathVariable("idjornada") Long idjornada) {
        try {
            jornadaService.deleteJornada(idjornada);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();
    }
}