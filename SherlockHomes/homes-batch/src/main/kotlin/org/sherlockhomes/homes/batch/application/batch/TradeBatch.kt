package org.sherlockhomes.homes.batch.application.batch

import org.springframework.batch.core.Job
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.context.annotation.Bean

class TradeBatch(
    private val jobRepository: JobRepository,

    private val aptTradeBatch: AptTradeBatch,
    private val monoTradeBatch: MonoTradeBatch
) {

    @Bean
    fun allTradeJob(): Job {
        return JobBuilder("allTrade", jobRepository)
            .start(aptTradeBatch.aptTradeStep())
            .next(monoTradeBatch.monoTradeStep())
            .build()
    }
}