package org.sherlockhomes.homes.batch.application.batch

import org.sherlockhomes.homes.batch.application.batch.reader.AptRentBatchReader
import org.sherlockhomes.homes.batch.application.port.outbound.SearchAptRentQueryPort
import org.sherlockhomes.homes.batch.domain.AptRent
import org.sherlockhomes.homes.batch.domain.mapper.toEntity
import org.sherlockhomes.homes.infra.rdb.entity.apt.AptRentEntity
import org.sherlockhomes.homes.infra.rdb.repository.apt.AptRentRepository
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
class AptRentBatch(
    private val jobRepository: JobRepository,
    private val platformTransactionManager: PlatformTransactionManager,
    private val jobParameterStepListener: JobParameterBeforeListener,

    private val searchAptRentQueryPort: SearchAptRentQueryPort,
    private val aptRentRepository: AptRentRepository,
) {


    @Bean
    fun aptRentJob(): Job {
        return JobBuilder("aptRent", jobRepository)
            .start(aptRentStep())
            .build()
    }

    @Bean
    fun aptRentStep(): Step {
        return StepBuilder("aptRentStep", jobRepository)
            .chunk<AptRent, AptRentEntity>(10, platformTransactionManager)
            .reader(aptRentReader())
            .processor(aptRentItemProccess())
            .writer(aptRentWriter())
            .listener(jobParameterStepListener)
            .build()
    }

    @Bean
    fun aptRentReader(): ItemReader<AptRent> {
        return AptRentBatchReader(searchAptRentQueryPort)
    }

    @Bean
    fun aptRentItemProccess(): ItemProcessor<AptRent, AptRentEntity> {

        return ItemProcessor<AptRent, AptRentEntity> { item ->
            item.toEntity()
        }
    }

    @Bean
    fun aptRentWriter(): RepositoryItemWriter<AptRentEntity> {
        return RepositoryItemWriterBuilder<AptRentEntity>()
            .repository(aptRentRepository)
            .methodName("save")
            .build()
    }
}