package br.com.fiap.gestao_residuos.repository;

import br.com.fiap.gestao_residuos.dto.coleta.ReadColetaDto;
import br.com.fiap.gestao_residuos.model.ColetaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface IColetaRepository extends JpaRepository<ColetaModel, Long> {

}
