package org.sherlockhomes.homes.monohouse.application.service.rent

import org.sherlockhomes.homes.monohouse.application.port.inbound.MonoHouseRentQuery
import org.sherlockhomes.homes.monohouse.application.port.outbound.MonoRentQueryPort
import org.sherlockhomes.homes.monohouse.application.service.rent.vo.MonoHouseRentVO
import org.sherlockhomes.homes.monohouse.domain.mapper.toVO
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class MonoRentReader(
    private val monoRentQueryPort: MonoRentQueryPort,
    private val kafkaTemplate: KafkaTemplate<String, String>
) : MonoHouseRentQuery {
    override fun getMonoRentListBySgg(si: String, gu: String, dong: String): List<MonoHouseRentVO.MonoHouseRent> {
        kafkaTemplate.send(
            "mono-log",
            "[mono][service] MonoRentReader.getMonoRentListBySgg (si=${si}, gu=${gu}, dong=${dong})"
        )
        kafkaTemplate.send(
            "all-log",
            "[mono][service] MonoRentReader.getMonoRentListBySgg (si=${si}, gu=${gu}, dong=${dong})"
        )

        return monoRentQueryPort.findBySiGuDong(
            si = si,
            gu = gu,
            dong = dong,
        ).map { it.toVO() }
    }


}