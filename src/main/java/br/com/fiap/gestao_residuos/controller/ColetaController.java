package br.com.fiap.gestao_residuos.controller;

import br.com.fiap.gestao_residuos.dto.coleta.CreateColetaDto;
import br.com.fiap.gestao_residuos.dto.coleta.ReadColetaDto;
import br.com.fiap.gestao_residuos.exception.NotFoundException;
import br.com.fiap.gestao_residuos.service.ColetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coleta")
public class ColetaController {

    @Autowired
    private ColetaService _coletaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReadColetaDto gravar(
            @RequestBody
            @Valid
            CreateColetaDto createColetaDto
    ) {
        return _coletaService.cadastrar(createColetaDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ReadColetaDto put(
            @RequestBody
            @Valid
            CreateColetaDto coletaDto
    ) {
        return _coletaService.atualizar(coletaDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ReadColetaDto> listarTodasColetas(Pageable paginacao) {
        return _coletaService.listarColetas(paginacao);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ReadColetaDto> listarColetaPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(_coletaService.listarPorid(id));
        } catch (NotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        _coletaService.excluir(id);
    }
}
