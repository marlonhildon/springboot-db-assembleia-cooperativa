package br.com.marlonhildon.assembleia.cooperativa.mapper;

import br.com.marlonhildon.assembleia.cooperativa.domain.VotacaoApuradaDomain;
import br.com.marlonhildon.assembleia.cooperativa.domain.VotacaoDomain;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.VotacaoApuradaGenerated;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.VotacaoGenerated;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface VotoMapper {

    VotacaoApuradaGenerated paraVotacaoApuradaGenerated(VotacaoApuradaDomain objetoOrigem);
    VotacaoGenerated paraVotacaoGenerated(VotacaoDomain objetoOrigem);
    VotacaoDomain paraVotacaoDomain(VotacaoGenerated objetoOrigem);

}
