package br.com.fiap.gestao_residuos.controller;

import br.com.fiap.gestao_residuos.dto.usuario.CreateUsuarioDto;
import br.com.fiap.gestao_residuos.dto.usuario.ReadUsuarioDto;
import br.com.fiap.gestao_residuos.exception.NotFoundException;
import br.com.fiap.gestao_residuos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService _service;

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public ReadUsuarioDto gravar(
            @RequestBody
            @Valid
            CreateUsuarioDto createUsuarioDto) {
        return _service.cadastrar(createUsuarioDto);
    }

    @GetMapping("/usuario")
    @ResponseStatus(HttpStatus.OK)
    public Page<ReadUsuarioDto> listarTodos(Pageable paginacao) {
        return _service.listarTodosOsUsuarios(paginacao);
    }

    @GetMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ReadUsuarioDto> listarUsuarioPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(_service.buscarPorId(id));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        _service.excluir(id);
    }

}
