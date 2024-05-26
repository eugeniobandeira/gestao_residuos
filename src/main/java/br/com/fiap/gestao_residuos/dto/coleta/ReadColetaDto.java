package br.com.fiap.gestao_residuos.dto.coleta;

import br.com.fiap.gestao_residuos.model.ColetaModel;

import java.time.LocalDateTime;

public record ReadColetaDto(
        Long id,
        String endereco,
        LocalDateTime data,
        Integer urgente
) {
    public ReadColetaDto(ColetaModel coletaModel) {
        this(
                coletaModel.getId(),
                coletaModel.getEndereco(),
                coletaModel.getData(),
                coletaModel.getUrgente()
        );
    }
}
