package com.sulimann.casadocodigo.usecases.criarcategoria;

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

import com.sulimann.casadocodigo.models.Categoria;
import com.sulimann.casadocodigo.utils.Path;

@RestController
@RequestMapping(value = Path.CATEGORIA)
public class CriarCategoriaController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<CriarCategoriaResponse> criarCategoria(@RequestBody @Valid CriarCategoriaRequest request){
        Categoria categoria = request.toModel();
        this.manager.persist(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CriarCategoriaResponse(categoria));
    }
    
}
