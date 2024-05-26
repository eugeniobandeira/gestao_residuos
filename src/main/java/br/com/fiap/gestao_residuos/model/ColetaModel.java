package br.com.fiap.gestao_residuos.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_COLETAS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ColetaModel {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_COLETAS"
    )
    @SequenceGenerator(
            name = "SEQ_COLETAS",
            sequenceName = "SEQ_COLETAS",
            allocationSize = 1
    )
    private Long id;
    private String endereco;
    private LocalDateTime data;
    private Integer urgente;
}
