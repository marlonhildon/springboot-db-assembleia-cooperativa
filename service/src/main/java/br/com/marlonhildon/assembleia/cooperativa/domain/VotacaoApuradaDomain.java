package br.com.marlonhildon.assembleia.cooperativa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VotacaoApuradaDomain {
    
    private Integer idSessaoPauta;
    private String nomePauta;
    private Integer qtdeVotosSim;
    private Integer qtdeVotosNao;
    
}
