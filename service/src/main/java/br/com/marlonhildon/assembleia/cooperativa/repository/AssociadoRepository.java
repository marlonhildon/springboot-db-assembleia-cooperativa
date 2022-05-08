package br.com.marlonhildon.assembleia.cooperativa.repository;

import br.com.marlonhildon.assembleia.cooperativa.domain.AssociadoDomain;
import br.com.marlonhildon.assembleia.cooperativa.domain.NovoNomeStatusDomain;

import java.util.Optional;

/**
 * Repositório de Associado para acesso ao Banco de Dados.
 */
public interface AssociadoRepository {

    Optional<AssociadoDomain> obterAssociado(String cpf);
//    int editarAssociado(String cpf, NovoNomeStatusDomain body);
    int criarAssociado(AssociadoDomain associadoDomain);
//    int apagarAssociado(String cpf);

}
