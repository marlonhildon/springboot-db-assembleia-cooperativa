package br.com.marlonhildon.assembleia.cooperativa.service.impl;

import br.com.marlonhildon.assembleia.cooperativa.domain.AssociadoDomain;
import br.com.marlonhildon.assembleia.cooperativa.domain.NovoNomeStatusDomain;
import br.com.marlonhildon.assembleia.cooperativa.exception.AssembleiaException;
import br.com.marlonhildon.assembleia.cooperativa.exception.erroenum.AssembleiaErroEnum;
import br.com.marlonhildon.assembleia.cooperativa.repository.AssociadoRepository;
import br.com.marlonhildon.assembleia.cooperativa.service.AssociadoService;
import br.com.marlonhildon.assembleia.cooperativa.util.ValidacaoUtil;
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
    private final ValidacaoUtil validacaoUtil;

    @Override
    public void apagarAssociado(String cpf) {
        try {
            log.info("Inicio do service de apagar associado");
            validacaoUtil.validarAtualizacaoBD(associadoRepository.apagarAssociado(cpf));
        } catch(JdbiException exception) {
            throw new AssembleiaException(AssembleiaErroEnum.ERRO_INTERNO_BD, exception);
        }
    }

    @Override
    public AssociadoDomain criarAssociado(AssociadoDomain body) {
        try {
            log.info("Inicio do service de criar associado");
            Optional<Integer> chaveGeradaAssociadoDomain = associadoRepository.criarAssociado(body);
            body.setId(chaveGeradaAssociadoDomain.orElseThrow(() -> new AssembleiaException(AssembleiaErroEnum.ASSOCIADO_JA_EXISTE)));
            return body;
        } catch(JdbiException exception) {
            throw new AssembleiaException(AssembleiaErroEnum.ERRO_INTERNO_BD, exception);
        }


    }

    @Override
    public void editarAssociado(String cpf, NovoNomeStatusDomain body) {
        try {
        log.info("Inicio do service de editar associado");
        validacaoUtil.validarAtualizacaoBD(associadoRepository.editarAssociado(cpf, body));
        } catch(JdbiException exception) {
            throw new AssembleiaException(AssembleiaErroEnum.ERRO_INTERNO_BD, exception);
        }
    }

    @Override
    public AssociadoDomain obterAssociado(String cpf) {
        try {
            log.info("Inicio do service de obter associado");
            Optional<AssociadoDomain> associadoObtido = associadoRepository.obterAssociado(cpf);
            return associadoObtido.orElseThrow(()->new AssembleiaException(AssembleiaErroEnum.ITEM_NAO_ENCONTRADO));
        } catch(JdbiException exception) {
            throw new AssembleiaException(AssembleiaErroEnum.ERRO_INTERNO_BD, exception);
        }
    }
}
