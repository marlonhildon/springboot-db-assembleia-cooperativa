package br.com.marlonhildon.assembleia.cooperativa.service;

import br.com.marlonhildon.assembleia.cooperativa.domain.AssociadoDomain;
import br.com.marlonhildon.assembleia.cooperativa.domain.NovoNomeStatusDomain;

/**
 * Representa as operações com o Associado na camada Service
 */
public interface AssociadoService {

    void apagarAssociado(String cpf);
    AssociadoDomain criarAssociado(AssociadoDomain body);
    void editarAssociado(String cpf, NovoNomeStatusDomain body);
    AssociadoDomain obterAssociado(String cpf);

}
