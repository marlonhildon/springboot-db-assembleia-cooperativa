package br.com.marlonhildon.assembleia.cooperativa.controller;

import br.com.marlonhildon.assembleia.cooperativa.domain.SessaoPautaDomain;
import br.com.marlonhildon.assembleia.cooperativa.gerado.api.SessaoPautaApi;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.SessaoPautaGenerated;
import br.com.marlonhildon.assembleia.cooperativa.mapper.SessaoPautaMapper;
import br.com.marlonhildon.assembleia.cooperativa.service.SessaoPautaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller para manipulação dos dados de SessaoPauta.
 */
@Slf4j
@RestController
@AllArgsConstructor
public class SessaoPautaController implements SessaoPautaApi {

    private final SessaoPautaService sessaoPautaService;
    private final SessaoPautaMapper sessaoPautaMapper;

    @Override
    public ResponseEntity<SessaoPautaGenerated> criarSessaoPauta(SessaoPautaGenerated body) {
        log.info("Inicio da criacao de sessao");
        SessaoPautaDomain sessaoPautaDomain = sessaoPautaMapper.paraSessaoPautaDomain(body);
        SessaoPautaDomain sessaoPautaRetornoService = sessaoPautaService.criarSessaoPauta(sessaoPautaDomain);
        SessaoPautaGenerated sessaoPautaCriada = sessaoPautaMapper.paraSessaoPautaGenerated(sessaoPautaRetornoService);
        log.info("Sessao criada com sucesso");

        return new ResponseEntity<>(sessaoPautaCriada, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SessaoPautaGenerated> obterSessaoPautaPorId(Integer id) {
        log.info("Inicio da consulta de sessao");
        SessaoPautaDomain sessaoPautaRetornoService = sessaoPautaService.obterSessaoPautaPorId(id);
        SessaoPautaGenerated sessaoPautaConsultada = sessaoPautaMapper.paraSessaoPautaGenerated(sessaoPautaRetornoService);
        log.info("Sessao consultada com sucesso");

        return new ResponseEntity<>(sessaoPautaConsultada, HttpStatus.OK);
    }

}
