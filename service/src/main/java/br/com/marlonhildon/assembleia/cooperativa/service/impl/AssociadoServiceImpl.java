package br.com.marlonhildon.assembleia.cooperativa.service.impl;

import br.com.marlonhildon.assembleia.cooperativa.domain.AssociadoDomain;
import br.com.marlonhildon.assembleia.cooperativa.domain.NovoNomeStatusDomain;
import br.com.marlonhildon.assembleia.cooperativa.repository.AssociadoRepository;
import br.com.marlonhildon.assembleia.cooperativa.service.AssociadoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementação do service de Associado
 */
@Slf4j
@Service
@AllArgsConstructor
public class AssociadoServiceImpl implements AssociadoService {

    private AssociadoRepository associadoRepository;

    @Override
    public void apagarAssociado(String cpf) {
        log.info("Inicio do service de apagar associado");
    }

    @Override
    public AssociadoDomain criarAssociado(AssociadoDomain body) {
        log.info("Inicio do service de criar associado");
        int chaveGeradaAssociadoDomain = associadoRepository.criarAssociado(body);
        body.setId(chaveGeradaAssociadoDomain);
        log.debug("Chave gerada do novo associado: {}", chaveGeradaAssociadoDomain);
        return body;
    }

    @Override
    public void editarAssociado(String cpf, NovoNomeStatusDomain body) {
        log.info("Inicio do service de editar associado");
    }

    @Override
    public AssociadoDomain obterAssociado(String cpf) {
        log.info("Inicio do service de obter associado");
        Optional<AssociadoDomain> associadoObtido = associadoRepository.obterAssociado(cpf);

        if(associadoObtido.isPresent()) {
            return associadoObtido.get();
        } else {
            throw new RuntimeException("Associado não encontrado"); //TODO: criar padrão de exceções + exceção customizada
        }
    }
}
