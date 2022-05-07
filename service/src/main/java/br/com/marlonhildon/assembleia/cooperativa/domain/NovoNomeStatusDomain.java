package br.com.marlonhildon.assembleia.cooperativa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NovoNomeStatusDomain {

    private String nome;
    private String flagAtivo;

}
