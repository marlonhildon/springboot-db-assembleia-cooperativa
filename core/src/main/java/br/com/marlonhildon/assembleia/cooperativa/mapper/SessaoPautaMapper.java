package br.com.marlonhildon.assembleia.cooperativa.mapper;

import br.com.marlonhildon.assembleia.cooperativa.domain.SessaoPautaDomain;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.SessaoPautaGenerated;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface SessaoPautaMapper {

    SessaoPautaGenerated paraSessaoPautaGenerated(SessaoPautaDomain objetoOrigem);
    SessaoPautaDomain paraSessaoPautaDomain(SessaoPautaGenerated objetoOrigem);

}
