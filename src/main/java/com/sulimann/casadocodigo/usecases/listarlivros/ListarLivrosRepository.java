package com.sulimann.casadocodigo.usecases.listarlivros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sulimann.casadocodigo.models.Livro;

@Repository
public interface ListarLivrosRepository extends JpaRepository<Livro, Long>, JpaSpecificationExecutor<Livro>{

}
