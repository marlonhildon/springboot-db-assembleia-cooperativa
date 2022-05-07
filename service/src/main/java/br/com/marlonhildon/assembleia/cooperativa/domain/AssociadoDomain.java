package br.com.marlonhildon.assembleia.cooperativa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssociadoDomain {
    
    private Integer id;
    private String nome;
    private String cpf;
    private String flagAtivo;
    private OffsetDateTime dataHoraInsercao;
    private OffsetDateTime dataHoraAlteracao;
    private String nomeUsuarioAuditoria;
    
}
