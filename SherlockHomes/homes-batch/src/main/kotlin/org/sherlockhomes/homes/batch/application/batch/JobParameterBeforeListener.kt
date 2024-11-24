package org.sherlockhomes.homes.batch.application.batch

import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.batch.core.annotation.BeforeStep
import org.springframework.batch.item.ExecutionContext
import org.springframework.stereotype.Component

@Component
class JobParameterBeforeListener : StepExecutionListener {
    @BeforeStep
    override fun beforeStep(stepExecution: StepExecution) {
        val executionContext: ExecutionContext = stepExecution.executionContext
        val jobParameters = stepExecution.jobParameters

        jobParameters.parameters.forEach { (key, value) ->
            executionContext.put(key, value.value)
        }
    }
}
