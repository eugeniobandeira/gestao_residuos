package br.com.fiap.gestao_residuos.dto.coleta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateColetaDto(
        Long id,

        @NotBlank(message = "O endereço é obrigatório!")
        String endereco,

        @NotNull(message = "A data não pode ser nula!")
        LocalDateTime data,

        Integer urgente
) {
}
