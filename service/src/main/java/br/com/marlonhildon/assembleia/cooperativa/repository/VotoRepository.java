package br.com.marlonhildon.assembleia.cooperativa.repository;

import br.com.marlonhildon.assembleia.cooperativa.domain.VotacaoApuradaDomain;
import br.com.marlonhildon.assembleia.cooperativa.domain.VotacaoDomain;

import java.util.Optional;

/**
 * Camada de abstração para desacoplar as atividades BD de Voto.
 */
public interface VotoRepository {


    Optional<VotacaoApuradaDomain> apurarVotosSessao(Integer idSessaoPauta);
    Integer votarSessaoPauta(VotacaoDomain body);

}
