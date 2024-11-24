package org.sherlockhomes.homes.batch.application.batch

import org.sherlockhomes.homes.batch.application.batch.reader.MonoRentBatchReader
import org.sherlockhomes.homes.batch.application.port.outbound.SearchMonoRentQueryPort
import org.sherlockhomes.homes.batch.domain.MonoRent
import org.sherlockhomes.homes.batch.domain.mapper.toEntity
import org.sherlockhomes.homes.infra.rdb.entity.mono.MonoRentEntity
import org.sherlockhomes.homes.infra.rdb.repository.mono.MonoRentRepository
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
class MonoRentBatch(
    private val jobRepository: JobRepository,
    private val platformTransactionManager: PlatformTransactionManager,
    private val jobParameterBeforeListener: JobParameterBeforeListener,

    private val searchMonoRentQueryPort: SearchMonoRentQueryPort,
    private val monoRentRepository: MonoRentRepository,
) {

    @Bean
    fun monoRentJob(): Job {
        return JobBuilder("monoRent", jobRepository)
            .start(monoRentStep())
            .build()
    }

    @Bean
    fun monoRentStep(): Step {
        return StepBuilder("monoRentStep", jobRepository)
            .chunk<MonoRent, MonoRentEntity>(10, platformTransactionManager)
            .reader(MonoRentReader())
            .processor(MonoRentItemProccess())
            .writer(MonoRentWriter())
            .listener(jobParameterBeforeListener)
            .build()
    }

    @Bean
    fun MonoRentReader(): ItemReader<MonoRent> {
        return MonoRentBatchReader(searchMonoRentQueryPort)
    }

    @Bean
    fun MonoRentItemProccess(): ItemProcessor<MonoRent, MonoRentEntity> {

        return ItemProcessor<MonoRent, MonoRentEntity> { item ->
            item.toEntity()
        }
    }

    @Bean
    fun MonoRentWriter(): RepositoryItemWriter<MonoRentEntity> {
        return RepositoryItemWriterBuilder<MonoRentEntity>()
            .repository(monoRentRepository)
            .methodName("save")
            .build()
    }
}