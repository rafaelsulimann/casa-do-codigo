package com.sulimann.casadocodigo.usecases.criarlivro;

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

import com.sulimann.casadocodigo.models.Livro;
import com.sulimann.casadocodigo.utils.Path;

@RestController
@RequestMapping(value = Path.LIVRO)
public class CriarLivroController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<CriarLivroResponse> criarLivro(@RequestBody @Valid CriarLivroRequest request){
        Livro livro = request.toModel(this.manager);
        this.manager.persist(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CriarLivroResponse(livro));
    }
    
}
