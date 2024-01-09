package com.sulimann.casadocodigo.usecases.listarlivros;

import org.springframework.data.jpa.domain.Specification;

import com.sulimann.casadocodigo.models.Livro;

import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@And({
        @Spec(path = "titulo", spec = LikeIgnoreCase.class),
        @Spec(path = "isbn", spec = Like.class)
})
public interface ListarLivrosSpecification extends Specification<Livro>{}
