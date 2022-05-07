package br.com.marlonhildon.assembleia.cooperativa.controller;

import br.com.marlonhildon.assembleia.cooperativa.domain.AssociadoDomain;
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

@Slf4j
@RestController
@AllArgsConstructor
public class AssociadoController implements AssociadoApi {

    private AssociadoService associadoService;
    private AssociadoMapper associadoMapper;

    @Override
    public ResponseEntity<ManipulacaoEntidadeGenerated> apagarAssociado(String cpf) {
        log.info("Teste de log info");
        log.warn("Teste de log warn");
        log.error("Teste de log error");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
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
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<AssociadoGenerated> obterAssociado(String cpf) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
