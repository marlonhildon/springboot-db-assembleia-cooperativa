package br.com.marlonhildon.assembleia.cooperativa.service.impl;

import br.com.marlonhildon.assembleia.cooperativa.domain.SessaoPautaDomain;
import br.com.marlonhildon.assembleia.cooperativa.exception.AssembleiaException;
import br.com.marlonhildon.assembleia.cooperativa.exception.erroenum.AssembleiaErroEnum;
import br.com.marlonhildon.assembleia.cooperativa.repository.SessaoPautaRepository;
import br.com.marlonhildon.assembleia.cooperativa.service.SessaoPautaService;
import br.com.marlonhildon.assembleia.cooperativa.util.SessaoPautaUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.JdbiException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class SessaoPautaServiceImpl implements SessaoPautaService {

    private final SessaoPautaRepository sessaoPautaRepository;
    private final SessaoPautaUtil sessaoPautaUtil;

    @Override
    public SessaoPautaDomain criarSessaoPauta(SessaoPautaDomain body) {
        try {
            log.info("Inicio do Service de criar sessao");
            sessaoPautaUtil.tratarTempoSessao(body);
            int idGerada = sessaoPautaRepository.criarSessaoPauta(body);
            body.setId(idGerada);
            return body;
        } catch (JdbiException jdbiException) {
            throw new AssembleiaException(AssembleiaErroEnum.ERRO_INTERNO_BD);
        }
    }

    @Override
    public SessaoPautaDomain obterSessaoPautaPorId(Integer id) {
        try {
            log.info("Inicio do Service de consulta de sessao");
            Optional<SessaoPautaDomain> sessaoPautaObtidoBase = sessaoPautaRepository.obterSessaoPautaPorId(id);
            return sessaoPautaObtidoBase.orElseThrow(() -> new AssembleiaException(AssembleiaErroEnum.ITEM_NAO_ENCONTRADO));
        } catch (JdbiException jdbiException) {
            throw new AssembleiaException(AssembleiaErroEnum.ERRO_INTERNO_BD);
        }
    }

}
