package com.sulimann.casadocodigo.usecases.criarautor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.casadocodigo.models.Autor;
import com.sulimann.casadocodigo.utils.Path;

@RestController
@RequestMapping(value = Path.AUTOR)
public class CriarAutorController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<CriarAutorResponse> criarAutor(@RequestBody @Valid CriarAutorRequest request){
        Autor autor = request.toModel();
        this.manager.persist(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CriarAutorResponse(autor));
    }
    
}
