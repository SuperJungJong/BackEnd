package org.sherlockhomes.homes.batch.application.batch

import org.sherlockhomes.homes.batch.application.batch.reader.AptTradeBatchReader
import org.sherlockhomes.homes.batch.application.port.outbound.SearchAptTradeQueryPort
import org.sherlockhomes.homes.batch.domain.AptTrade
import org.sherlockhomes.homes.batch.domain.mapper.toEntity
import org.sherlockhomes.homes.infra.rdb.entity.apt.AptTradeEntity
import org.sherlockhomes.homes.infra.rdb.repository.apt.AptTradeRepository
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.data.RepositoryItemWriter
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class AptTradeBatch(
    private val jobRepository: JobRepository,
    private val platformTransactionManager: PlatformTransactionManager,
    private val jobParameterStepListener: JobParameterBeforeListener,

    private val searchAptTradeQueryPort: SearchAptTradeQueryPort,
    private val aptTradeRepository: AptTradeRepository,
) {
    @Bean
    fun aptTradeJob(): Job {
        return JobBuilder("aptTrade", jobRepository)
            .start(aptTradeStep())
            .build()
    }

    @Bean
    fun aptTradeStep(): Step {
        return StepBuilder("aptTradeStep", jobRepository)
            .chunk<AptTrade, AptTradeEntity>(10, platformTransactionManager)
            .reader(aptTradeReader())
            .processor(aptTradeItemProccess())
            .writer(aptTradeWriter())
            .listener(jobParameterStepListener)
            .build()
    }

    @Bean
    fun aptTradeReader(): ItemReader<AptTrade> {
        return AptTradeBatchReader(searchAptTradeQueryPort)
    }

    @Bean
    fun aptTradeItemProccess(): ItemProcessor<AptTrade, AptTradeEntity> {

        return ItemProcessor<AptTrade, AptTradeEntity> { item ->
            item.toEntity()
        }
    }

    @Bean
    fun aptTradeWriter(): RepositoryItemWriter<AptTradeEntity> {
        return RepositoryItemWriterBuilder<AptTradeEntity>()
            .repository(aptTradeRepository)
            .methodName("save")
            .build()
    }
}