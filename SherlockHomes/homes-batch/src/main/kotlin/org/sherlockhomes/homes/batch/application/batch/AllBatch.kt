package org.sherlockhomes.homes.batch.application.batch

import org.springframework.batch.core.Job
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.context.annotation.Bean
import org.springframework.transaction.PlatformTransactionManager

class AllBatch(
    private val jobRepository: JobRepository,

    private val aptTradeBatch: AptTradeBatch,
    private val aptRentBatch: AptRentBatch,

    private val monoTradeBatch: MonoTradeBatch,
    private val monoRentBatch: MonoRentBatch,
) {

    @Bean
    fun allBatch(): Job {
        return JobBuilder("all", jobRepository)
            .start(aptTradeBatch.aptTradeStep())
            .next(monoTradeBatch.monoTradeStep())
            .next(aptRentBatch.aptRentStep())
            .next(monoRentBatch.monoRentStep())
            .build()
    }
}