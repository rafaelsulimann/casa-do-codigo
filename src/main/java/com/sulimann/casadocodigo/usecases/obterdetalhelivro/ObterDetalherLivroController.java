package com.sulimann.casadocodigo.usecases.obterdetalhelivro;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.casadocodigo.models.Livro;
import com.sulimann.casadocodigo.utils.Assert;
import com.sulimann.casadocodigo.utils.Path;

@RestController
@RequestMapping(value = Path.LIVRO)
public class ObterDetalherLivroController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ObterDetalheLivroResponse> obterDetalheLivro(@PathVariable Long id){
        Optional<Livro> opLivro = Optional.ofNullable(this.manager.find(Livro.class, id));
        Assert.existsObject(opLivro.isPresent(), "Livro não encontrado");
        return ResponseEntity.status(HttpStatus.OK).body(new ObterDetalheLivroResponse(opLivro.get()));
    }
    
}
