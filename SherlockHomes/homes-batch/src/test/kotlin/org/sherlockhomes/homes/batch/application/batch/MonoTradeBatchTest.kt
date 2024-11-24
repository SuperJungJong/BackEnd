package org.sherlockhomes.homes.batch.application.batch

import org.junit.jupiter.api.Test
import org.sherlockhomes.homes.batch.application.port.outbound.SearchMonoTradeQueryPort
import org.sherlockhomes.homes.infra.rdb.repository.mono.MonoTradeRepository
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.configuration.JobRegistry
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.batch.core.repository.JobRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.PlatformTransactionManager

@SpringBootTest
class MonoTradeBatchTest @Autowired constructor(
    private val jobRepository: JobRepository,
    private val platformTransactionManager: PlatformTransactionManager,
    private val searchMonoTradeQueryPort: SearchMonoTradeQueryPort,
    private val monoTradeRepository: MonoTradeRepository,
    private val batch: MonoTradeBatch,
    private val jobLauncher: JobLauncher,
    private val jobRegistry: JobRegistry,
) {

    @Test
    fun job() {
        batch.monoTradejob()
    }

    @Test
    fun job2() {
        batch.monoTradejob()
        val toJobParameters = JobParametersBuilder()
            .toJobParameters()
        jobLauncher.run(
            jobRegistry.getJob("monoTrade"),
            toJobParameters
        )
    }
}

