package org.sherlockhomes.homes.batch.adaptor.inbound

import io.swagger.v3.oas.annotations.Operation
import org.sherlockhomes.homes.batch.adaptor.outbound.BuildingDataQueryAdaptor
import org.sherlockhomes.homes.batch.adaptor.outbound.SearchAptTradeAdaptor
import org.sherlockhomes.homes.batch.application.port.outbound.SearchMonoTradeQueryPort
import org.sherlockhomes.homes.batch.application.port.outbound.persistence.AptTradeCommandPort
import org.sherlockhomes.homes.batch.application.port.outbound.persistence.MonoTradeCommandPort
import org.sherlockhomes.homes.batch.application.service.MonoWriter
import org.sherlockhomes.homes.batch.domain.mapper.toEntity
import org.springframework.batch.core.JobParameter
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.configuration.JobRegistry
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/batch")
class BatchApi(
    private val adp: BuildingDataQueryAdaptor,
    private val monoTradeSearchMonoTradeQueryPort: SearchMonoTradeQueryPort,
    private val jobLauncher: JobLauncher,
    private val jobRegistry: JobRegistry,
    private val monoTradeCommandPort: MonoTradeCommandPort,
    private val aptTradeCommandPort: AptTradeCommandPort,
    private val searchAptTradeAdaptor: SearchAptTradeAdaptor,
    private val monoWriter: MonoWriter
) {


    @Operation(summary = "단다가구 매매 배치 작업 ")
    @GetMapping("/mono/trade")
    fun batchMonoTrade(
        @RequestParam dealYm: String,
    ) {
        val toJobParameters = JobParametersBuilder()
            .addString("dealYm", dealYm)
            .toJobParameters()

        jobLauncher.run(
            jobRegistry.getJob("monoTrade"),
            toJobParameters
        )
    }

    @Operation(summary = "단다가구 전월세 배치 작업 ")
    @GetMapping("/mono/rent")
    fun batchMonoRent(
        @RequestParam dealYm: String,
    ) {
        val toJobParameters = JobParametersBuilder()
            .addString("dealYm", dealYm)
            .toJobParameters()

        jobLauncher.run(
            jobRegistry.getJob("monoRent"),
            toJobParameters
        )
    }

    @Operation(summary = "아파트 매매 배치 작업 ")
    @GetMapping("/apt/trade")
    fun batchAptTrade(
        @RequestParam dealYm: String,
    ) {
        val toJobParameters = JobParametersBuilder()
            .addString("dealYm", dealYm)
            .toJobParameters()

        jobLauncher.run(
            jobRegistry.getJob("aptTrade"),
            toJobParameters
        )
    }

    @Operation(summary = "아파트 월세 배치 작업 ")
    @GetMapping("/apt/rent")
    fun batchAptRent(
        @RequestParam dealYm: String,
    ) {
        val toJobParameters = JobParametersBuilder()
            .addString("dealYm", dealYm)
            .toJobParameters()

        jobLauncher.run(
            jobRegistry.getJob("aptRent"),
            toJobParameters
        )
    }

    @Operation(summary = "전체 월세 배치 작업 ")
    @GetMapping("/all/rent")
    fun batchAllRent(
        @RequestParam dealYm: String,
    ) {
        val toJobParameters = JobParametersBuilder()
            .addString("dealYm", dealYm)
            .toJobParameters()

        jobLauncher.run(
            jobRegistry.getJob("allRent"),
            toJobParameters
        )
    }

    @Operation(summary = "전체 매매 배치 작업 ")
    @GetMapping("/all/rent")
    fun batchAllTrade(
        @RequestParam dealYm: String,
    ) {
        val toJobParameters = JobParametersBuilder()
            .addString("dealYm", dealYm)
            .toJobParameters()

        jobLauncher.run(
            jobRegistry.getJob("allTrade"),
            toJobParameters
        )
    }


    @Operation(summary = "전체 매매 배치 작업 ")
    @GetMapping("/all")
    fun batchAll(
        @RequestParam dealYm: String,
    ) {
        val toJobParameters = JobParametersBuilder()
            .addString("dealYm", dealYm)
            .toJobParameters()

        jobLauncher.run(
            jobRegistry.getJob("all"),
            toJobParameters
        )
    }
}