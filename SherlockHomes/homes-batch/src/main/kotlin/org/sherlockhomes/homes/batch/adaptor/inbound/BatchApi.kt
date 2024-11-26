package org.sherlockhomes.homes.batch.adaptor.inbound

import io.swagger.v3.oas.annotations.Operation
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.configuration.JobRegistry
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/batch")
class BatchApi(
    private val jobLauncher: JobLauncher,
    private val jobRegistry: JobRegistry,
    private val kafkaTemplate: KafkaTemplate<String, String>
) {


    @Operation(summary = "단다가구 매매 배치 작업 ")
    @GetMapping("/mono/trade")
    fun batchMonoTrade(
        @RequestParam dealYm: String,
    ) {
        kafkaTemplate.send("batch-log", "[batch][controller][start] /mono/trade, request (dealYm=${dealYm})")
        kafkaTemplate.send("all-log", "[batch][controller][start] /mono/trade, request (dealYm=${dealYm})")

        val toJobParameters = JobParametersBuilder()
            .addString("dealYm", dealYm)
            .toJobParameters()

        jobLauncher.run(
            jobRegistry.getJob("monoTrade"),
            toJobParameters
        )

        kafkaTemplate.send("batch-log", "[batch][controller][end] /mono/trade, request (dealYm=${dealYm})")
        kafkaTemplate.send("all-log", "[batch][controller][end] /mono/trade, request (dealYm=${dealYm})")
    }

    @Operation(summary = "단다가구 전월세 배치 작업 ")
    @GetMapping("/mono/rent")
    fun batchMonoRent(
        @RequestParam dealYm: String,
    ) {
        kafkaTemplate.send("batch-log", "[batch][controller][start] /mono/rent, request (dealYm=${dealYm})")
        kafkaTemplate.send("all-log", "[batch][controller][start] /mono/rent, request (dealYm=${dealYm})")

        val toJobParameters = JobParametersBuilder()
            .addString("dealYm", dealYm)
            .toJobParameters()

        jobLauncher.run(
            jobRegistry.getJob("monoRent"),
            toJobParameters
        )

        kafkaTemplate.send("batch-log", "[batch][controller][end] /mono/rent, request (dealYm=${dealYm})")
        kafkaTemplate.send("all-log", "[batch][controller][end] /mono/rent, request (dealYm=${dealYm})")
    }

    @Operation(summary = "아파트 매매 배치 작업 ")
    @GetMapping("/apt/trade")
    fun batchAptTrade(
        @RequestParam dealYm: String,
    ) {
        kafkaTemplate.send("batch-log", "[batch][controller][start] /apt/trade, request (dealYm=${dealYm})")
        kafkaTemplate.send("all-log", "[batch][controller][start] /apt/trade, request (dealYm=${dealYm})")

        val toJobParameters = JobParametersBuilder()
            .addString("dealYm", dealYm)
            .toJobParameters()

        jobLauncher.run(
            jobRegistry.getJob("aptTrade"),
            toJobParameters
        )

        kafkaTemplate.send("batch-log", "[batch][controller][end] /apt/trade, request (dealYm=${dealYm})")
        kafkaTemplate.send("all-log", "[batch][controller][end] /apt/trade, request (dealYm=${dealYm})")
    }

    @Operation(summary = "아파트 월세 배치 작업 ")
    @GetMapping("/apt/rent")
    fun batchAptRent(
        @RequestParam dealYm: String,
    ) {
        kafkaTemplate.send("batch-log", "[batch][controller][start] /apt/rent, request (dealYm=${dealYm})")
        kafkaTemplate.send("all-log", "[batch][controller][start] /apt/rent, request (dealYm=${dealYm})")

        val toJobParameters = JobParametersBuilder()
            .addString("dealYm", dealYm)
            .toJobParameters()

        jobLauncher.run(
            jobRegistry.getJob("aptRent"),
            toJobParameters
        )

        kafkaTemplate.send("batch-log", "[batch][controller][end] /apt/rent, request (dealYm=${dealYm})")
        kafkaTemplate.send("all-log", "[batch][controller][end] /apt/rent, request (dealYm=${dealYm})")
    }

    @Operation(summary = "전체 월세 배치 작업 ")
    @GetMapping("/all/rent")
    fun batchAllRent(
        @RequestParam dealYm: String,
    ) {
        kafkaTemplate.send("batch-log", "[batch][controller][start] /all/rent, request (dealYm=${dealYm})")
        kafkaTemplate.send("all-log", "[batch][controller][start] /all/rent, request (dealYm=${dealYm})")

        val toJobParameters = JobParametersBuilder()
            .addString("dealYm", dealYm)
            .toJobParameters()

        jobLauncher.run(
            jobRegistry.getJob("allRent"),
            toJobParameters
        )

        kafkaTemplate.send("batch-log", "[batch][controller][end] /all/rent, request (dealYm=${dealYm})")
        kafkaTemplate.send("all-log", "[batch][controller][end] /all/rent, request (dealYm=${dealYm})")
    }

    @Operation(summary = "전체 매매 배치 작업 ")
    @GetMapping("/all/trade")
    fun batchAllTrade(
        @RequestParam dealYm: String,
    ) {
        kafkaTemplate.send("batch-log", "[batch][controller][start] /all/trade, request (dealYm=${dealYm})")
        kafkaTemplate.send("all-log", "[batch][controller][start] /all/trade, request (dealYm=${dealYm})")

        val toJobParameters = JobParametersBuilder()
            .addString("dealYm", dealYm)
            .toJobParameters()

        jobLauncher.run(
            jobRegistry.getJob("allTrade"),
            toJobParameters
        )

        kafkaTemplate.send("batch-log", "[batch][controller][end] /all/trade, request (dealYm=${dealYm})")
        kafkaTemplate.send("all-log", "[batch][controller][end] /all/trade, request (dealYm=${dealYm})")
    }


    @Operation(summary = "전체 매매 배치 작업 ")
    @GetMapping("/all")
    fun batchAll(
        @RequestParam dealYm: String,
    ) {
        kafkaTemplate.send("batch-log", "[batch][controller][start] /all, request (dealYm=${dealYm})")
        kafkaTemplate.send("all-log", "[batch][controller][start] /all, request (dealYm=${dealYm})")

        val toJobParameters = JobParametersBuilder()
            .addString("dealYm", dealYm)
            .toJobParameters()

        jobLauncher.run(
            jobRegistry.getJob("all"),
            toJobParameters
        )

        kafkaTemplate.send("batch-log", "[batch][controller][end] /all, request (dealYm=${dealYm})")
        kafkaTemplate.send("all-log", "[batch][controller][end] /all, request (dealYm=${dealYm})")
    }
}