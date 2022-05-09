package br.com.marlonhildon.assembleia.cooperativa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessaoPautaDomain {
    
    private Integer id;
    private String nomePauta;
    private OffsetDateTime dataHoraInicioSessao;
    private OffsetDateTime dataHoraFimSessao;
    private String nomeUsuarioAuditoria;
    
}
