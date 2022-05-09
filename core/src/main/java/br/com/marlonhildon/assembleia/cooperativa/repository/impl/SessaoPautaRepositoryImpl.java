package br.com.marlonhildon.assembleia.cooperativa.repository.impl;

import br.com.marlonhildon.assembleia.cooperativa.domain.SessaoPautaDomain;
import br.com.marlonhildon.assembleia.cooperativa.repository.SessaoPautaRepository;
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
public interface SessaoPautaRepositoryImpl extends SessaoPautaRepository {

    @Override
    @SqlUpdate
    @GetGeneratedKeys
    int criarSessaoPauta(@BindBean("sessao") SessaoPautaDomain body);

    @Override
    @SqlQuery
    @RegisterBeanMapper(SessaoPautaDomain.class)
    Optional<SessaoPautaDomain> obterSessaoPautaPorId(@Bind Integer id);

}
