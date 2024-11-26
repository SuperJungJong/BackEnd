package org.sherlockhomes.homes.map.application.service.legaldong

import org.sherlockhomes.homes.map.application.port.inbound.GugunDongQuery
import org.sherlockhomes.homes.map.application.port.outbound.GugunDongQueryPort
import org.sherlockhomes.homes.map.application.service.legaldong.vo.GugunDongVO
import org.sherlockhomes.homes.map.domain.mapper.toVO
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class GugunDongReader(
    private val gugunDongQueryPort: GugunDongQueryPort,
    private val kafkaTemplate: KafkaTemplate<String, String>
) : GugunDongQuery {
    override fun getGugunDong(gugun: String): List<GugunDongVO.Gugun> {
        kafkaTemplate.send("map-log", "[map][service] getGugunDong, request (gugun=${gugun})")
        kafkaTemplate.send("all-log", "[map][service] getGugunDong, request (gugun=${gugun})")

        return gugunDongQueryPort.findDongListByGugun(gugun).map { it.toVO() }
    }
}