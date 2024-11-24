package org.sherlockhomes.homes.batch.application.batch

import org.sherlockhomes.homes.batch.application.batch.reader.MonoTradeBatchReader
import org.sherlockhomes.homes.batch.application.port.outbound.SearchMonoTradeQueryPort
import org.sherlockhomes.homes.batch.domain.MonoTrade
import org.sherlockhomes.homes.batch.domain.mapper.toEntity
import org.sherlockhomes.homes.infra.rdb.entity.mono.MonoTradeEntity
import org.sherlockhomes.homes.infra.rdb.repository.mono.MonoTradeRepository
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
class MonoTradeBatch(
    private val jobRepository: JobRepository,
    private val platformTransactionManager: PlatformTransactionManager,
    private val jobParameterStepListener: JobParameterBeforeListener,

    private val searchMonoTradeQueryPort: SearchMonoTradeQueryPort,
    private val monoTradeRepository: MonoTradeRepository,
) {

    @Bean
    fun monoTradeJob(): Job {
        return JobBuilder("monoTrade", jobRepository)
            .start(monoTradeStep())
            .build()
    }

    @Bean
    fun monoTradeStep(): Step {
        return StepBuilder("monoTradeStep", jobRepository)
            .chunk<MonoTrade, MonoTradeEntity>(10, platformTransactionManager)
            .reader(MonoTradeReader())
            .processor(MonoTradeItemProccess())
            .writer(MonoTradeWriter())
            .listener(jobParameterStepListener)
            .build()
    }

    @Bean
    fun MonoTradeReader(): ItemReader<MonoTrade> {
        return MonoTradeBatchReader(searchMonoTradeQueryPort)
    }

    @Bean
    fun MonoTradeItemProccess(): ItemProcessor<MonoTrade, MonoTradeEntity> {

        return ItemProcessor<MonoTrade, MonoTradeEntity> { item ->
            item.toEntity()
        }
    }

    @Bean
    fun MonoTradeWriter(): RepositoryItemWriter<MonoTradeEntity> {
        return RepositoryItemWriterBuilder<MonoTradeEntity>()
            .repository(monoTradeRepository)
            .methodName("save")
            .build()
    }
}