package br.com.fiap.gestao_residuos.dto.usuario;

import br.com.fiap.gestao_residuos.enums.UsuarioRoleEnum;
import br.com.fiap.gestao_residuos.model.UsuarioModel;

public record ReadUsuarioDto(
        Long id,
        String nome,
        String email,
        UsuarioRoleEnum role
) {
    public ReadUsuarioDto(UsuarioModel usuarioModel) {
        this(
                usuarioModel.getId(),
                usuarioModel.getNome(),
                usuarioModel.getEmail(),
                usuarioModel.getRole()

        );
    }
}
