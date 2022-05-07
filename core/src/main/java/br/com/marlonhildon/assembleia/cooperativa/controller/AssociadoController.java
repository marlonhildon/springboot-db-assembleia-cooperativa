package br.com.marlonhildon.assembleia.cooperativa.controller;

import br.com.marlonhildon.assembleia.cooperativa.gerado.api.AssociadoApi;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.AssociadoGenerated;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.ManipulacaoEntidadeGenerated;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.NovoNomeStatusGenerated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AssociadoController implements AssociadoApi {
    @Override
    public ResponseEntity<ManipulacaoEntidadeGenerated> apagarAssociado(String cpf) {
        log.info("Teste de log info");
        log.warn("Teste de log warn");
        log.error("Teste de log error");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<AssociadoGenerated> criarAssociado(AssociadoGenerated body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
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
