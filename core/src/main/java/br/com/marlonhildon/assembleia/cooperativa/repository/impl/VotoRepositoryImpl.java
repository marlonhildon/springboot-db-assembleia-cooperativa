package br.com.marlonhildon.assembleia.cooperativa.repository.impl;

import br.com.marlonhildon.assembleia.cooperativa.domain.VotacaoApuradaDomain;
import br.com.marlonhildon.assembleia.cooperativa.domain.VotacaoDomain;
import br.com.marlonhildon.assembleia.cooperativa.repository.VotoRepository;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@UseClasspathSqlLocator
public interface VotoRepositoryImpl extends VotoRepository {

    @Override
    @SqlQuery
    @RegisterBeanMapper(VotacaoApuradaDomain.class)
    Optional<VotacaoApuradaDomain> apurarVotosSessao(@Bind Integer idSessaoPauta);

    @Override
    @SqlUpdate
    @GetGeneratedKeys
    Integer votarSessaoPauta(@BindBean("voto") VotacaoDomain body);

}
