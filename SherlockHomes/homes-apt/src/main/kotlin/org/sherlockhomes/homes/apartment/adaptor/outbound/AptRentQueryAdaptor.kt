package org.sherlockhomes.homes.apartment.adaptor.outbound

import org.sherlockhomes.homes.apartment.application.port.outbound.AptRentQueryPort
import org.sherlockhomes.homes.apartment.domain.AptRent
import org.sherlockhomes.homes.apartment.domain.mapper.toDomain
import org.sherlockhomes.homes.infra.rdb.repository.AptRentRepository
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class AptRentQueryAdaptor(
    private val aptRentRepository: AptRentRepository,
    private val kafkaTemplate: KafkaTemplate<String, String>
) : AptRentQueryPort {
    override fun findAllRentInDong(si: String, gu: String, dong: String): List<AptRent> {

        val result = aptRentRepository.findAllBySiAndGuAndDong(si, gu, dong)
            .map { it.toDomain() }

        kafkaTemplate.send(
            "apt-log",
            "[apt][adaptor][end] AptRentQueryAdaptor.findAllRentInDong (si=${si}, gu=${gu}, dong=${dong})"
        )
        kafkaTemplate.send(
            "all-log",
            "[apt][adaptor][end] AptRentQueryAdaptor.findAllRentInDong (si=${si}, gu=${gu}, dong=${dong})"
        )

        return result
    }

    override fun findAptRentDetail(si: String, gu: String, dong: String, name: String): List<AptRent> {

        val result = aptRentRepository.findAllBySiAndGuAndDongAndAptNm(si, gu, dong, name)
            .map { it.toDomain() }

        kafkaTemplate.send(
            "apt-log",
            "[apt][adaptor][end] AptRentQueryAdaptor.findAllRentInDong (si=${si}, gu=${gu}, dong=${dong}, name=${name})"
        )
        kafkaTemplate.send(
            "all-log",
            "[apt][adaptor][end] AptRentQueryAdaptor.findAllRentInDong (si=${si}, gu=${gu}, dong=${dong}, name=${name})"
        )

        return result
    }
}