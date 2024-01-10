package com.sulimann.casadocodigo.usecases.criarestado;

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

import com.sulimann.casadocodigo.models.Estado;
import com.sulimann.casadocodigo.utils.Path;

@RestController
@RequestMapping(value = Path.ESTADO)
public class CriarEstadoController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<CriarEstadoResponse> criarEstado(@RequestBody @Valid CriarEstadoRequest request){
        Estado estado = request.toModel(this.manager);
        this.manager.persist(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CriarEstadoResponse(estado));
    }
    
}
