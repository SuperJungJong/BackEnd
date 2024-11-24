package org.sherlockhomes.homes.infra.rdb.config

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager


@Configuration
@EnableJpaRepositories(
    basePackages = ["org.sherlockhomes.homes.infra.rdb.repository.apt"],
    transactionManagerRef = "aptTransactionManager",
    entityManagerFactoryRef = "aptEntityManager",
)
class AptDBConfig {

    @Bean(name = ["aptDBSource"])
    @ConfigurationProperties(prefix = "spring.datasource-apt")
    fun aptDBSource() =
        DataSourceBuilder.create().build()

    @Bean(name = ["aptEntityManager"])
    fun aptEntityManager(): LocalContainerEntityManagerFactoryBean {
        val em = LocalContainerEntityManagerFactoryBean()

        em.dataSource = aptDBSource()
        em.setPackagesToScan(*arrayOf("org.sherlockhomes.homes.infra.rdb.entity.apt"))
        em.jpaVendorAdapter = HibernateJpaVendorAdapter()

        val properties = HashMap<String, Any?>()
        properties["hibernate.hbm2ddl.auto"] = "validate"
        properties["hibernate.show_sql"] = "true"
        properties["hibernate.physical_naming_strategy"] = CamelCaseToUnderscoresNamingStrategy::class.java.name
        properties["hibernate.implicit_naming_strategy"] = SpringImplicitNamingStrategy::class.java.name

        em.setJpaPropertyMap(properties)

        return em
    }

    @Bean(name = ["aptTransactionManager"])
    fun aptTransactionManager(): PlatformTransactionManager {
        val transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = aptEntityManager().getObject()
        return transactionManager
    }

}