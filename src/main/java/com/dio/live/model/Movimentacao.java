package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movimentacao {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class MovimentacaoId implements Serializable {
        private long idMovimento;
        private long idUsuario;
    }

    @EmbeddedId
    @Column
    private MovimentacaoId id;
    @Column
    private LocalDateTime dataEntrada;
    @Column
    private LocalDateTime dataSaida;
    @Column
    private BigDecimal periodo;
    @Column
    private Ocorrencia ocorrencia;
    @Column
    private Caleandario caleandario;
}
