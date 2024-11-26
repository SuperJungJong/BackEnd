package org.sherlockhomes.homes.apartment.adaptor.outbound

import org.sherlockhomes.homes.apartment.application.port.outbound.GuCountQueryPort
import org.sherlockhomes.homes.apartment.domain.GuCount
import org.sherlockhomes.homes.apartment.domain.mapper.toDomain
import org.sherlockhomes.homes.infra.rdb.repository.GuCountRepository
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class GuCountQueryAdaptor(
    private val guCountRepository: GuCountRepository,
    private val kafkaTemplate: KafkaTemplate<String, String>
) : GuCountQueryPort {
    override fun findAllBySi(si: String): List<GuCount> {

        val result = guCountRepository.findAllBySiName(si).map { it.toDomain() }

        kafkaTemplate.send(
            "apt-log",
            "[apt][adaptor][end] AptTradeQueryAdaptor.findAllBySi (si=${si})"
        )
        kafkaTemplate.send(
            "all-log",
            "[apt][adaptor][end] AptTradeQueryAdaptor.findAllBySi (si=${si})"
        )

        return result
    }
}