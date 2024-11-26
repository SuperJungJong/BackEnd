package org.sherlockhomes.homes.apartment.application.service.rent

import org.sherlockhomes.homes.apartment.application.port.inbound.AptRentQuery
import org.sherlockhomes.homes.apartment.application.port.outbound.AptRentQueryPort
import org.sherlockhomes.homes.apartment.application.service.vo.rent.AptRentVO
import org.sherlockhomes.homes.apartment.domain.mapper.toVO
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class AptRentReader(
    private val aptRentQueryPort: AptRentQueryPort,
    private val kafkaTemplate: KafkaTemplate<String, String>
) : AptRentQuery {

    override fun getListBySiGuDong(si: String, gu: String, dong: String): List<AptRentVO.ApartmentRent> {
        kafkaTemplate.send(
            "apt-log",
            "[apt][service] getListBySiGuDong (si=${si}, gu=${gu}, dong=${dong})"
        )
        kafkaTemplate.send(
            "all-log",
            "[apt][service] getListBySiGuDong (si=${si}, gu=${gu}, dong=${dong})"
        )

        return aptRentQueryPort.findAllRentInDong(
            si = si,
            gu = gu,
            dong = dong
        ).map { it.toVO() }
    }

    override fun getAptRentDetail(si: String, gu: String, dong: String, name: String): List<AptRentVO.ApartmentRent> {
        kafkaTemplate.send(
            "apt-log",
            "[apt][service] getAptRentDetail (si=${si}, gu=${gu}, dong=${dong}, name=${name})"
        )
        kafkaTemplate.send(
            "all-log",
            "[apt][service] getAptRentDetail (si=${si}, gu=${gu}, dong=${dong}, name${name})"
        )

        return aptRentQueryPort.findAptRentDetail(
            si = si,
            gu = gu,
            dong = dong,
            name = name,
        ).map { it.toVO() }
    }
}