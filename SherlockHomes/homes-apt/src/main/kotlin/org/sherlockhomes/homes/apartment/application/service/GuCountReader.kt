package org.sherlockhomes.homes.apartment.application.service

import org.sherlockhomes.homes.apartment.application.port.inbound.GuCountQuery
import org.sherlockhomes.homes.apartment.application.port.outbound.GuCountQueryPort
import org.sherlockhomes.homes.apartment.application.service.vo.GuCountVO
import org.sherlockhomes.homes.apartment.domain.mapper.toVO
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class GuCountReader(
    private val guCountQueryPort: GuCountQueryPort,
    private val kafkaTemplate: KafkaTemplate<String, String>,
) : GuCountQuery {
    override fun getGuCount(si: String): List<GuCountVO.GuCount> {

        kafkaTemplate.send(
            "apt-log",
            "[apt][service] getGuCount (si=${si})"
        )
        kafkaTemplate.send(
            "apt-log",
            "[apt][service] getGuCount (si=${si})"
        )

        return guCountQueryPort.findAllBySi(si).map { it.toVO() }
    }

}