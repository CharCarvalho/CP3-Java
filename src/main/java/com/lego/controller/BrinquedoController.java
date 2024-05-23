package com.lego.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lego.model.Brinquedo;
import com.lego.repository.BrinquedoRepository;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoRepository brinquedosRepository;

    @GetMapping
    public List<Brinquedo> listarBrinquedos() {
        return brinquedosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Brinquedo>> buscarBrinquedoPorId(@PathVariable Long id) {
        Optional<Brinquedo> brinquedo = brinquedosRepository.findById(id);
        if (brinquedo.isPresent()) {
            EntityModel<Brinquedo> resource = EntityModel.of(brinquedo.get());
            Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BrinquedoController.class).buscarBrinquedoPorId(id)).withSelfRel();
            resource.add(selfLink);
            return ResponseEntity.ok(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Brinquedo> criarBrinquedo(@RequestBody Brinquedo brinquedo) {
        Brinquedo savedBrinquedo = brinquedosRepository.save(brinquedo);
        return ResponseEntity.ok(savedBrinquedo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brinquedo> atualizarBrinquedo(@PathVariable Long id, @RequestBody Brinquedo brinquedo) {
        if (brinquedosRepository.existsById(id)) {
            brinquedo.setId(id);
            Brinquedo updatedBrinquedo = brinquedosRepository.save(brinquedo);
            return ResponseEntity.ok(updatedBrinquedo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBrinquedo(@PathVariable Long id) {
        if (brinquedosRepository.existsById(id)) {
            brinquedosRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}