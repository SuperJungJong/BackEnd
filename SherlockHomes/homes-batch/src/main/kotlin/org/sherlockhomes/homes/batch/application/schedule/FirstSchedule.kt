package org.sherlockhomes.homes.batch.application.schedule

import org.jetbrains.annotations.Async.Schedule
import org.springframework.batch.core.configuration.JobRegistry
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled

@Configuration
class FirstSchedule(
    private val jobLauncher: JobLauncher,
    private val jobRegistry: JobRegistry,
) {

    @Scheduled(cron = "10 * * * * *", zone = "Asia/Seoul")
    fun runFirstJob() {
        
    }
}

