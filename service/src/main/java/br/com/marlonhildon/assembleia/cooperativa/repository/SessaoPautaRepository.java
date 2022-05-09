package br.com.marlonhildon.assembleia.cooperativa.repository;

import br.com.marlonhildon.assembleia.cooperativa.domain.SessaoPautaDomain;

import java.util.Optional;

/**
 * Interface de desacoplamento para o repositório de SessaoPauta.
 */
public interface SessaoPautaRepository {

    int criarSessaoPauta(SessaoPautaDomain body);
    Optional<SessaoPautaDomain> obterSessaoPautaPorId(Integer id);

}
