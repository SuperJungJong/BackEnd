package org.sherlockhomes.homes.monohouse.application.service.trade

import org.sherlockhomes.homes.monohouse.application.port.inbound.MonoHouseTradeQuery
import org.sherlockhomes.homes.monohouse.application.port.outbound.MonoTradeQueryPort
import org.sherlockhomes.homes.monohouse.application.service.trade.vo.MonoHouseTradeVO
import org.sherlockhomes.homes.monohouse.domain.mapper.toVO
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class MonoTradeReader(
    private val monoTradeQueryPort: MonoTradeQueryPort,
    private val kafkaTemplate: KafkaTemplate<String, String>
) : MonoHouseTradeQuery {

    override fun getMonoTradeListBySgg(si: String, gu: String, dong: String): List<MonoHouseTradeVO.MonoHouseTrade> {
        kafkaTemplate.send(
            "mono-log",
            "[mono][service] MonoTradeReader.getMonoTradeListBySgg (si=${si}, gu=${gu}, dong=${dong})"
        )
        kafkaTemplate.send(
            "all-log",
            "[mono][service] MonoTradeReader.getMonoTradeListBySgg (si=${si}, gu=${gu}, dong=${dong})"
        )

        return monoTradeQueryPort.findBySiGuDong(
            si = si,
            gu = gu,
            dong = dong,
        ).map { it.toVO() }
    }
}