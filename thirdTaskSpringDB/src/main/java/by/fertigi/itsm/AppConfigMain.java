package by.fertigi.itsm;

import by.fertigi.itsm.processors.EnableAuditOperation;
import by.fertigi.itsm.util.Salt;
import liquibase.exception.DatabaseException;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.vibur.dbcp.ViburDBCPDataSource;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@ComponentScan("by.fertigi.itsm")
@PropertySource(value = "classpath:app.properties")
@EnableTransactionManagement
public class AppConfigMain {

    @Autowired
    private ConfigurableEnvironment environment;

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

    @Value("${security.salt}")
    private String salt;

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean
    public DataSource dataSource() {
        ViburDBCPDataSource ds = new ViburDBCPDataSource();

        ds.setDriverClassName(driver);
        ds.setJdbcUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);

        ds.start();

        return ds;
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


    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public Properties jpaProperties() {
        Properties properties = new Properties();

        properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
        properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));

        return properties;
    }

    @Bean
    @DependsOn("liquibase")
    public LocalContainerEntityManagerFactoryBean sessionFactory(
            JpaVendorAdapter jpaVendorAdapter, Properties jpaProperties, DataSource ds) {
        LocalContainerEntityManagerFactoryBean factoryBean
                = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(ds);
        factoryBean.setPackagesToScan("by.fertigi.itsm.entity");
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setJpaProperties(jpaProperties);

        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager txManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public Salt salt(){
        return new Salt(salt);
    }
}
