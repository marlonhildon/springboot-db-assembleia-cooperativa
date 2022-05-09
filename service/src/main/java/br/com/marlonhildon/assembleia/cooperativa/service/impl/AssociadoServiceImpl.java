package br.com.marlonhildon.assembleia.cooperativa.service.impl;

import br.com.marlonhildon.assembleia.cooperativa.domain.AssociadoDomain;
import br.com.marlonhildon.assembleia.cooperativa.domain.NovoNomeStatusDomain;
import br.com.marlonhildon.assembleia.cooperativa.exception.AssociadoException;
import br.com.marlonhildon.assembleia.cooperativa.exception.erroenum.AssociadoErroEnum;
import br.com.marlonhildon.assembleia.cooperativa.repository.AssociadoRepository;
import br.com.marlonhildon.assembleia.cooperativa.service.AssociadoService;
import br.com.marlonhildon.assembleia.cooperativa.util.ValidacaoAssociadoUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.JdbiException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementação do service de Associado
 */
@Slf4j
@Service
@AllArgsConstructor
public class AssociadoServiceImpl implements AssociadoService {

    private final AssociadoRepository associadoRepository;
    private final ValidacaoAssociadoUtil validacaoAssociadoUtil;

    @Override
    public void apagarAssociado(String cpf) {
        try {
            log.info("Inicio do service de apagar associado");
            validacaoAssociadoUtil.validarAtualizacaoAssociado(associadoRepository.apagarAssociado(cpf));
        } catch(JdbiException exception) {
            throw new AssociadoException(AssociadoErroEnum.ASSOCIADO_ERRO_INTERNO_BD, exception);
        }
    }

    @Override
    public AssociadoDomain criarAssociado(AssociadoDomain body) {
        try {
            log.info("Inicio do service de criar associado");
            Optional<Integer> chaveGeradaAssociadoDomain = associadoRepository.criarAssociado(body);
            body.setId(chaveGeradaAssociadoDomain.orElseThrow(() -> new AssociadoException(AssociadoErroEnum.ASSOCIADO_JA_EXISTE)));
            return body;
        } catch(JdbiException exception) {
            throw new AssociadoException(AssociadoErroEnum.ASSOCIADO_ERRO_INTERNO_BD, exception);
        }


    }

    @Override
    public void editarAssociado(String cpf, NovoNomeStatusDomain body) {
        try {
        log.info("Inicio do service de editar associado");
        validacaoAssociadoUtil.validarAtualizacaoAssociado(associadoRepository.editarAssociado(cpf, body));
        } catch(JdbiException exception) {
            throw new AssociadoException(AssociadoErroEnum.ASSOCIADO_ERRO_INTERNO_BD, exception);
        }
    }

    @Override
    public AssociadoDomain obterAssociado(String cpf) {
        try {
            log.info("Inicio do service de obter associado");
            Optional<AssociadoDomain> associadoObtido = associadoRepository.obterAssociado(cpf);
            return associadoObtido.orElseThrow(()->new AssociadoException(AssociadoErroEnum.ASSOCIADO_NAO_ENCONTRADO));
        } catch(JdbiException exception) {
            throw new AssociadoException(AssociadoErroEnum.ASSOCIADO_ERRO_INTERNO_BD, exception);
        }
    }
}
