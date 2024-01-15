package com.sulimann.casadocodigo.usecases.obterdetalhecompra;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.casadocodigo.handlers.controllerexceptionhandler.exceptions.ResourceNotFoundException;
import com.sulimann.casadocodigo.models.Compra;
import com.sulimann.casadocodigo.utils.Path;

@RestController
@RequestMapping(value = Path.COMPRA)
public class ObterDetalheCompraController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ObterDetalheCompraResponse> obterDetalheCompra(@PathVariable Long id){
        Optional<Compra> opCompra = Optional.ofNullable(this.manager.find(Compra.class, id));
        if(!opCompra.isPresent()){
            throw new ResourceNotFoundException("Compra não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ObterDetalheCompraResponse(opCompra.get()));
    }
    
}
