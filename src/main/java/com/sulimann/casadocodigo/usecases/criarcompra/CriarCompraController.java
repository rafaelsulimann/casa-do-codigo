package com.sulimann.casadocodigo.usecases.criarcompra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.casadocodigo.models.Compra;
import com.sulimann.casadocodigo.utils.Path;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping(value = Path.COMPRA)
@RequiredArgsConstructor
public class CriarCompraController {

    @PersistenceContext
    private EntityManager manager;

    private final EstadoPertenceAPaisValidator estadoPertencePaisValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(estadoPertencePaisValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CriarCompraResponse> criarCompra(@RequestBody @Valid CriarCompraRequest request) {
        Compra compra = request.toModel(this.manager);
        this.manager.persist(compra);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CriarCompraResponse(compra));
    }
    
    
}
