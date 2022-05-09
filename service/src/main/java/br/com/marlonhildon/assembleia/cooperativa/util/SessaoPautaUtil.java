package br.com.marlonhildon.assembleia.cooperativa.util;

import br.com.marlonhildon.assembleia.cooperativa.domain.SessaoPautaDomain;
import br.com.marlonhildon.assembleia.cooperativa.exception.AssembleiaException;
import br.com.marlonhildon.assembleia.cooperativa.exception.erroenum.AssembleiaErroEnum;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneId;

/**
 * Utilitário para regras de negócio de SessaoPauta.
 */
@Component
public class SessaoPautaUtil {

    public static final long QTDE_MINUTOS_PADRAO_SESSAO = 1L;
    public static final ZoneId ZONE_ID_AMERICA_SP = ZoneId.of("America/Sao_Paulo");

    public void tratarTempoSessao(SessaoPautaDomain body) {
        if(body.getDataHoraInicioSessao() == null) {
            OffsetDateTime dataHoraAgoraComFuso = OffsetDateTime.now(ZONE_ID_AMERICA_SP);
            body.setDataHoraInicioSessao(dataHoraAgoraComFuso);
            body.setDataHoraFimSessao(obterTempoSessaoPadrao(dataHoraAgoraComFuso));
        } else if(body.getDataHoraFimSessao() == null || body.getDataHoraInicioSessao().isAfter(body.getDataHoraFimSessao())) {
            throw new AssembleiaException(AssembleiaErroEnum.SESSAO_INICIO_FIM_VALIDOS);
        }
    }

    private OffsetDateTime obterTempoSessaoPadrao(OffsetDateTime dataHoraInicioSessao) {
        return dataHoraInicioSessao.plusMinutes(QTDE_MINUTOS_PADRAO_SESSAO);
    }

}
