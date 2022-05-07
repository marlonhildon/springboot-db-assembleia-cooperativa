package br.com.marlonhildon.assembleia.cooperativa.controller;

import br.com.marlonhildon.assembleia.cooperativa.domain.AssociadoDomain;
import br.com.marlonhildon.assembleia.cooperativa.domain.NovoNomeStatusDomain;
import br.com.marlonhildon.assembleia.cooperativa.gerado.api.AssociadoApi;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.AssociadoGenerated;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.ManipulacaoEntidadeGenerated;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.NovoNomeStatusGenerated;
import br.com.marlonhildon.assembleia.cooperativa.mapper.AssociadoMapper;
import br.com.marlonhildon.assembleia.cooperativa.service.AssociadoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller para manipulação dos dados do associado.
 */
@Slf4j
@RestController
@AllArgsConstructor
public class AssociadoController implements AssociadoApi {

    private AssociadoService associadoService;
    private AssociadoMapper associadoMapper;

    @Override
    public ResponseEntity<ManipulacaoEntidadeGenerated> apagarAssociado(String cpf) {
        log.info("Inicio da remocao logica do associado");
        associadoService.apagarAssociado(cpf);
        log.info("Associado apagado com sucesso");
        return new ResponseEntity<>(new ManipulacaoEntidadeGenerated().mensagem(ManipulacaoEntidadeGenerated.MensagemEnum.APAGADO_SUCESSO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AssociadoGenerated> criarAssociado(AssociadoGenerated body) {
        log.info("Inicio do cadastro de associado");
        AssociadoDomain bodyDomain = associadoMapper.paraAssociadoDomain(body);
        AssociadoDomain associadoCadastradoDomain = associadoService.criarAssociado(bodyDomain);
        AssociadoGenerated associadoCadastradoGenerated = associadoMapper.paraAssociadoGenerated(associadoCadastradoDomain);
        log.info("Associado cadastrado com sucesso");
        return new ResponseEntity<>(associadoCadastradoGenerated, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ManipulacaoEntidadeGenerated> editarAssociado(String cpf, NovoNomeStatusGenerated body) {
        log.info("Inicio da edicao de associado");
        NovoNomeStatusDomain novoNomeStatusGenerated = associadoMapper.paraNovoNomeStatusDomain(body);
        associadoService.editarAssociado(cpf, novoNomeStatusGenerated);
        log.info("Associado editado com sucesso");
        return new ResponseEntity<>(new ManipulacaoEntidadeGenerated().mensagem(ManipulacaoEntidadeGenerated.MensagemEnum.EDITADO_SUCESSO), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<AssociadoGenerated> obterAssociado(String cpf) {
        log.info("Inicio da consulta de associado");
        AssociadoDomain associadoConsultadoDomain = associadoService.obterAssociado(cpf);
        AssociadoGenerated associadoCadastradoGenerated = associadoMapper.paraAssociadoGenerated(associadoConsultadoDomain);
        log.info("Associado retornado com sucesso");
        return new ResponseEntity<>(associadoCadastradoGenerated, HttpStatus.OK);
    }
}
