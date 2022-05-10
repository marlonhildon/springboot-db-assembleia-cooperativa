package br.com.marlonhildon.assembleia.cooperativa.config;

import br.com.marlonhildon.assembleia.cooperativa.repository.AssociadoRepository;
import br.com.marlonhildon.assembleia.cooperativa.repository.SessaoPautaRepository;
import br.com.marlonhildon.assembleia.cooperativa.repository.VotoRepository;
import br.com.marlonhildon.assembleia.cooperativa.repository.impl.AssociadoRepositoryImpl;
import br.com.marlonhildon.assembleia.cooperativa.repository.impl.SessaoPautaRepositoryImpl;
import br.com.marlonhildon.assembleia.cooperativa.repository.impl.VotoRepositoryImpl;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class JdbiConfig {

    /**
     * Configura o DataSource para ser utilizado pelo JDBI.
     * @param ds o DataSource (auto-injetado pelo Spring)
     * @param jdbiPlugins plugins do JDBI (auto-injetado pelo Spring)
     * @param rowMappers row mappers a serem utilizados no JDBI (auto-injetado pelo Spring)
     * @return instância de {@link org.jdbi.v3.core.Jdbi} pronto para operações com bases de dados
     */
    @Bean
    public Jdbi jdbi(DataSource ds, List<JdbiPlugin> jdbiPlugins, List<RowMapper<?>> rowMappers) {
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(ds);
        Jdbi jdbi = Jdbi
                .create(proxy)
                .installPlugin(new SqlObjectPlugin());

        jdbiPlugins.forEach(jdbi::installPlugin);
        rowMappers.forEach(jdbi::registerRowMapper);

        return jdbi;
    }

    @Bean
    public AssociadoRepository obterAssociadoRepositoryBean(Jdbi jdbi) {
        return jdbi.onDemand(AssociadoRepositoryImpl.class);
    }

    @Bean
    public SessaoPautaRepository obterSessaoPautaRepositoryBean(Jdbi jdbi) {
        return jdbi.onDemand(SessaoPautaRepositoryImpl.class);
    }

    @Bean
    public VotoRepository obterVotoRepositoryBean(Jdbi jdbi) {
        return jdbi.onDemand(VotoRepositoryImpl.class);
    }
}
