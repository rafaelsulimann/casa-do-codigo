package com.sulimann.casadocodigo.usecases.criarpais;

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

import com.sulimann.casadocodigo.models.Pais;
import com.sulimann.casadocodigo.utils.Path;

@RestController
@RequestMapping(value = Path.PAIS)
public class CriarPaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<CriarPaisResponse> criarPais(@RequestBody @Valid CriarPaisRequest request){
        Pais pais = request.toModel();
        this.manager.persist(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CriarPaisResponse(pais));
        
    }
    
}
