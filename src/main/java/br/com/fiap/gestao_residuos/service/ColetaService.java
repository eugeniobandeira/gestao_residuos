package br.com.fiap.gestao_residuos.service;

import br.com.fiap.gestao_residuos.dto.coleta.CreateColetaDto;
import br.com.fiap.gestao_residuos.dto.coleta.ReadColetaDto;
import br.com.fiap.gestao_residuos.exception.NotFoundException;
import br.com.fiap.gestao_residuos.model.ColetaModel;
import br.com.fiap.gestao_residuos.repository.IColetaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColetaService {

    @Autowired
    IColetaRepository _coletaRepository;

    public ReadColetaDto cadastrar(CreateColetaDto createColetaDto) {
        ColetaModel coleta = new ColetaModel();
        BeanUtils.copyProperties(createColetaDto, coleta);

        return new ReadColetaDto(_coletaRepository.save(coleta));
    }

    public ReadColetaDto atualizar(CreateColetaDto createColetaDto) {
        ColetaModel coleta = new ColetaModel();
        BeanUtils.copyProperties(createColetaDto, coleta);

        ColetaModel coletaAtualizada = _coletaRepository.save(coleta);

        return new ReadColetaDto(coletaAtualizada);
    }

    public Page<ReadColetaDto> listarColetas(Pageable paginacao) {
        return _coletaRepository
                .findAll(paginacao)
                .map(ReadColetaDto::new);
    }

    public ReadColetaDto listarPorid(Long id) {
        Optional<ColetaModel> coletaOptional = _coletaRepository.findById(id);
        if (coletaOptional.isPresent()) {
            return new ReadColetaDto(coletaOptional.get());
        } else {
            throw new NotFoundException("Coleta não encontrada!");
        }
    }

    public void excluir(Long id) {
        Optional<ColetaModel> coletaOptional = _coletaRepository.findById(id);
        if (coletaOptional.isPresent()) {
            _coletaRepository.delete(coletaOptional.get());
        } else {
            throw new NotFoundException("Coleta não encontrada!");
        }
    }
}
