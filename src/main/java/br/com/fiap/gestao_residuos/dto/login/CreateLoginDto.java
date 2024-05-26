package br.com.fiap.gestao_residuos.dto.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateLoginDto(
        @NotNull(message = "O email é obrigatório!")
        @Email(message = "O email informado não é válido")
        String email,

        @NotBlank(message = "A senha é obrigatória!")
        @Size(min = 6, max = 20, message = "A deve conter entre 6 e 20 caracteres!")
        String senha
) {
}
