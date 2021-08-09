package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity

public class Caleandario {


    @Id
    private long id;

    @OneToOne
    @JoinColumn
    private TipoData tipoData;
    private String descricao;
    private LocalDateTime dataEspecial;
}

