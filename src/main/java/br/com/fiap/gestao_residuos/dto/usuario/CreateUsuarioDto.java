package br.com.fiap.gestao_residuos.dto.usuario;

import br.com.fiap.gestao_residuos.enums.UsuarioRoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateUsuarioDto(

        Long id,

        @NotBlank(message = "O nome é obrigatório!")
        String nome,

        @NotNull(message = "O email é obrigatório!")
        @Email(message = "O email informado não é válido!")
        String email,

        @NotBlank(message = "A senha éobrigatória!")
        @Size(min = 6, max = 80, message = "A senha deve ter entre 6 e 80 caracteres!")
        String senha,

        UsuarioRoleEnum role
) {

}
