package org.sherlockhomes.homes.batch.application.batch

import org.springframework.batch.core.Job
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RentBatch(
    private val jobRepository: JobRepository,

    private val aptRentBatch: AptRentBatch,
    private val monoRentBatch: MonoRentBatch,
) {
    @Bean
    fun allRentJob(): Job {
        return JobBuilder("allRent", jobRepository)
            .start(aptRentBatch.aptRentStep())
            .next(monoRentBatch.monoRentStep())
            .build()
    }
}