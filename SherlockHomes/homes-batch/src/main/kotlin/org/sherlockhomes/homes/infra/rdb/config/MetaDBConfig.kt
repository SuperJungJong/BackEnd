package org.sherlockhomes.homes.infra.rdb.config//package org.sherlockhomes.homes.infra.rdb.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.DataSourceTransactionManager

@Configuration
class MetaDBConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource-meta")
    fun metaDBSource() =
        DataSourceBuilder.create().build()

    @Bean
    @Primary
    fun metaTransactionManager() =
        DataSourceTransactionManager(metaDBSource())
}