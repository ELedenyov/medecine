package by.fertigi.itsm;

import by.fertigi.itsm.processors.EnableAuditOperation;
import liquibase.exception.DatabaseException;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@ComponentScan("by.fertigi.itsm")
@PropertySource(value = "classpath:app.properties")
@EnableTransactionManagement
public class AppConfigMain {
    @Value("${db.driver}")
    private String driver;

    @Value("${db.url}")
    private String url;

    @Value("${db.user}")
    private String user;

    @Value("${db.password}")
    private String password;

    @Value("${audit.status}")
    private boolean status;

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);

        return ds;
    }

    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public EnableAuditOperation flagAuditOperation(){
        EnableAuditOperation enableAuditOperation = new EnableAuditOperation(status);
        return enableAuditOperation;
    }

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) throws SQLException, DatabaseException {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:changelogs/db.changelog.config.xml");
        liquibase.setContexts("development, production");
        return liquibase;
    }
}
