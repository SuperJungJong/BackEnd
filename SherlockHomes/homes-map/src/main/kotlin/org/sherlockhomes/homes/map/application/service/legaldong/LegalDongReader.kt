package org.sherlockhomes.homes.map.application.service.legaldong

import org.sherlockhomes.homes.map.application.port.inbound.LegalDongQuery
import org.sherlockhomes.homes.map.application.port.outbound.LegalDongQueryPort
import org.sherlockhomes.homes.map.application.service.legaldong.vo.GuVO
import org.sherlockhomes.homes.map.application.service.legaldong.vo.SiVO
import org.sherlockhomes.homes.map.domain.mapper.toVO
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class LegalDongReader(
    private val legalDongQueryPort: LegalDongQueryPort,
    private val kafkaTemplate: KafkaTemplate<String, String>
) : LegalDongQuery {

    override fun getSiList(): List<SiVO.Si> {
        kafkaTemplate.send("map-log", "[map][service] LegalDongReader.getSiList")
        kafkaTemplate.send("all-log", "[map][service] LegalDongReader.getSiList")

        return legalDongQueryPort.getSiList().map { it.toVO() }
    }

    override fun getGuList(
        code: String
    ): List<GuVO.Gu> {
        kafkaTemplate.send("map-log", "[map][service] LegalDongReader.getGuList (code=${code})")
        kafkaTemplate.send("all-log", "[map][service] LegalDongReader.getGuList (code=${code})")

        return legalDongQueryPort.getGuList(code).map { it.toVO() }
    }
}
