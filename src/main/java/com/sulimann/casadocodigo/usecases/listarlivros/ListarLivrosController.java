package com.sulimann.casadocodigo.usecases.listarlivros;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.casadocodigo.models.Livro;
import com.sulimann.casadocodigo.utils.Path;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = Path.LIVRO)
@RequiredArgsConstructor
public class ListarLivrosController {

    private final ListarLivrosRepository repository;

    @GetMapping
    public ResponseEntity<Page<ListarLivrosResponse>> listarLivros(
            ListarLivrosSpecification spec,
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Livro> livros = this.repository.findAll(spec, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(livros.map(ListarLivrosResponse::new));
    }

}
