package br.com.marlonhildon.assembleia.cooperativa.service.impl;

import br.com.marlonhildon.assembleia.cooperativa.domain.VotacaoApuradaDomain;
import br.com.marlonhildon.assembleia.cooperativa.domain.VotacaoDomain;
import br.com.marlonhildon.assembleia.cooperativa.exception.AssembleiaException;
import br.com.marlonhildon.assembleia.cooperativa.exception.erroenum.AssembleiaErroEnum;
import br.com.marlonhildon.assembleia.cooperativa.repository.VotoRepository;
import br.com.marlonhildon.assembleia.cooperativa.service.VotoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.JdbiException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class VotoServiceImpl implements VotoService {

    private final VotoRepository votoRepository;

    @Override
    public VotacaoApuradaDomain apurarVotosSessao(Integer idSessaoPauta) {
        try {
            log.info("Inicio do service da apuracao de votos");
            Optional<VotacaoApuradaDomain> votacaoApurada = votoRepository.apurarVotosSessao(idSessaoPauta);
            return votacaoApurada.orElseThrow(() -> new AssembleiaException(AssembleiaErroEnum.SESSAO_AINDA_VIGENTE));
        } catch(JdbiException jdbiException) {
            throw new AssembleiaException(AssembleiaErroEnum.ERRO_INTERNO_BD, jdbiException);
        }
    }

    @Override
    public VotacaoDomain votarSessaoPauta(VotacaoDomain body) {
        try {
            log.info("Inicio do service de insercao de voto");
            Integer idGeradoNovoVoto = votoRepository.votarSessaoPauta(body);
            if (idGeradoNovoVoto == null) {
                throw new AssembleiaException(AssembleiaErroEnum.SESSAO_JA_FINALIZADA_OU_JA_VOTOU);
            } else {
                body.setId(idGeradoNovoVoto);
                return body;
            }
        } catch(JdbiException jdbiException) {
            throw new AssembleiaException(AssembleiaErroEnum.ERRO_INTERNO_BD, jdbiException);
        }
    }

}
