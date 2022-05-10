package br.com.marlonhildon.assembleia.cooperativa.controller;

import br.com.marlonhildon.assembleia.cooperativa.domain.VotacaoApuradaDomain;
import br.com.marlonhildon.assembleia.cooperativa.domain.VotacaoDomain;
import br.com.marlonhildon.assembleia.cooperativa.gerado.api.VotoApi;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.VotacaoApuradaGenerated;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.VotacaoGenerated;
import br.com.marlonhildon.assembleia.cooperativa.mapper.VotoMapper;
import br.com.marlonhildon.assembleia.cooperativa.service.VotoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class VotoController implements VotoApi {

    private final VotoService votoService;
    private final VotoMapper votoMapper;

    @Override
    public ResponseEntity<VotacaoApuradaGenerated> apurarVotosSessao(Integer idSessaoPauta) {
        log.info("Iniciando apuracao dos votos para a pauta {}", idSessaoPauta);
        VotacaoApuradaDomain retornoServico = votoService.apurarVotosSessao(idSessaoPauta);
        VotacaoApuradaGenerated retornoContrato = votoMapper.paraVotacaoApuradaGenerated(retornoServico);
        log.info("Retornando votos apurados");
        return new ResponseEntity<>(retornoContrato, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VotacaoGenerated> votarSessaoPauta(VotacaoGenerated body) {
        log.info("Iniciando inserção do voto da sessão");
        VotacaoDomain requestDomain = votoMapper.paraVotacaoDomain(body);
        VotacaoDomain retornoServico = votoService.votarSessaoPauta(requestDomain);
        VotacaoGenerated retornoContrato = votoMapper.paraVotacaoGenerated(retornoServico);
        log.info("Voto computado com sucesso");
        return new ResponseEntity<>(retornoContrato, HttpStatus.CREATED);
    }

}
