package com.sulimann.casadocodigo.usecases.criarcupom;

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

import com.sulimann.casadocodigo.models.CupomDesconto;
import com.sulimann.casadocodigo.utils.Path;


@RestController
@RequestMapping(value = Path.CUPOM_DESCONTO)
public class CriarCupomController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<CriarCupomResponse> criarcupom(@RequestBody @Valid CriarCupomRequest request) {
        CupomDesconto cupomDesconto = request.toModel();
        this.manager.persist(cupomDesconto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CriarCupomResponse(cupomDesconto));
    }
    
}
