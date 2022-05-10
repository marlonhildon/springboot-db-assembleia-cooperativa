package br.com.marlonhildon.assembleia.cooperativa.service;

import br.com.marlonhildon.assembleia.cooperativa.domain.VotacaoApuradaDomain;
import br.com.marlonhildon.assembleia.cooperativa.domain.VotacaoDomain;

/**
 * Contrato para implentações das regras de Voto.
 */
public interface VotoService {

    VotacaoApuradaDomain apurarVotosSessao(Integer idSessaoPauta);
    VotacaoDomain votarSessaoPauta(VotacaoDomain body);

}
