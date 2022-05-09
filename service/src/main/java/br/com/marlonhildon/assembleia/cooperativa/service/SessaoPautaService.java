package br.com.marlonhildon.assembleia.cooperativa.service;

import br.com.marlonhildon.assembleia.cooperativa.domain.SessaoPautaDomain;

/**
 * Representa as operações com o SessaoPauta na camada Service.
 */
public interface SessaoPautaService {

    SessaoPautaDomain criarSessaoPauta(SessaoPautaDomain body);
    SessaoPautaDomain obterSessaoPautaPorId(Integer id);

}
