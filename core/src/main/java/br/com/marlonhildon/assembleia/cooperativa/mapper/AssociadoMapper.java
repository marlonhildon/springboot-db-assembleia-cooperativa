package br.com.marlonhildon.assembleia.cooperativa.mapper;

import br.com.marlonhildon.assembleia.cooperativa.domain.AssociadoDomain;
import br.com.marlonhildon.assembleia.cooperativa.domain.NovoNomeStatusDomain;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.AssociadoGenerated;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.NovoNomeStatusGenerated;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper automático das entidades domain para generated (geradas pelo contrato Swagger).<br>
 * Os mappers são gerados na compilação Maven.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface AssociadoMapper {

    AssociadoDomain paraAssociadoDomain(AssociadoGenerated objetoOrigem);
    AssociadoGenerated paraAssociadoGenerated(AssociadoDomain objetoOrigem);
    NovoNomeStatusGenerated paraNovoNomeStatusGenerated(NovoNomeStatusDomain objetoOrigem);
    NovoNomeStatusDomain paraNovoNomeStatusDomain(NovoNomeStatusGenerated objetoOrigem);

}
