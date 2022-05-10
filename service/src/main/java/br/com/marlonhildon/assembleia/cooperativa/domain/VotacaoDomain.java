package br.com.marlonhildon.assembleia.cooperativa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VotacaoDomain {

    private Integer id;
    private Integer idAssociado;
    private Integer idSessaoVotacao;
    private String flagVotoAssociado;
    
}
