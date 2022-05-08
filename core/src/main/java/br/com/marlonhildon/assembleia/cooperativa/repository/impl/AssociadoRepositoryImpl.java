package br.com.marlonhildon.assembleia.cooperativa.repository.impl;

import br.com.marlonhildon.assembleia.cooperativa.domain.AssociadoDomain;
import br.com.marlonhildon.assembleia.cooperativa.repository.AssociadoRepository;
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
public interface AssociadoRepositoryImpl extends AssociadoRepository {

    @Override
    @SqlUpdate
    @GetGeneratedKeys
    int criarAssociado(@BindBean("associado") AssociadoDomain associadoDomain);

    @Override
    @SqlQuery
    @RegisterBeanMapper(AssociadoDomain.class)
    Optional<AssociadoDomain> obterAssociado(@Bind String cpf);

}
