package com.sulimann.casadocodigo.usecases.criarautor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.casadocodigo.models.Autor;
import com.sulimann.casadocodigo.utils.Path;

@RestController
@RequestMapping(value = Path.AUTOR)
public class Controller {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Response> criarAutor(@RequestBody @Valid Request request){
        Autor autor = request.toModel();
        this.manager.persist(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response(autor));
    }
    
}
