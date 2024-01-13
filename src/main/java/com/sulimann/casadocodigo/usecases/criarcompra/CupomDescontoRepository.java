package com.sulimann.casadocodigo.usecases.criarcompra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sulimann.casadocodigo.models.CupomDesconto;

@Repository
public interface CupomDescontoRepository extends JpaRepository<CupomDesconto, Long>{

    CupomDesconto findByCodigo(String codigo);

}
