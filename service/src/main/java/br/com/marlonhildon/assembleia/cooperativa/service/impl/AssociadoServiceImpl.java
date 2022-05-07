package br.com.marlonhildon.assembleia.cooperativa.service.impl;

import br.com.marlonhildon.assembleia.cooperativa.domain.AssociadoDomain;
import br.com.marlonhildon.assembleia.cooperativa.domain.NovoNomeStatusDomain;
import br.com.marlonhildon.assembleia.cooperativa.service.AssociadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Implementação do service de Associado
 */
@Slf4j
@Service
public class AssociadoServiceImpl implements AssociadoService {
    @Override
    public void apagarAssociado(String cpf) {
        log.info("Inicio do service de apagar associado");
    }

    @Override
    public AssociadoDomain criarAssociado(AssociadoDomain body) {
        log.info("Inicio do service de criar associado");
        return body;
    }

    @Override
    public void editarAssociado(String cpf, NovoNomeStatusDomain body) {
        log.info("Inicio do service de editar associado");
    }

    @Override
    public AssociadoDomain obterAssociado(String cpf) {
        log.info("Inicio do service de obter associado");
        return new AssociadoDomain();
    }
}
