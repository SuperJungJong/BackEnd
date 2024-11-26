package org.sherlockhomes.homes.apartment.application.service.trade

import org.sherlockhomes.homes.apartment.application.port.inbound.AptTradeQuery
import org.sherlockhomes.homes.apartment.application.port.outbound.AptTradeQueryPort
import org.sherlockhomes.homes.apartment.application.service.vo.trade.AptTradeVO
import org.sherlockhomes.homes.apartment.application.service.vo.trade.ListPageVO
import org.sherlockhomes.homes.apartment.domain.mapper.toVO
import org.springframework.data.domain.PageRequest
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class AptTradeReader(
    private val aptTradeQueryPort: AptTradeQueryPort,
    private val kafkaTemplate: KafkaTemplate<String, String>
) : AptTradeQuery {

    override fun getAptTrade(
        sgg: String,
        aptName: String,
        offset: Int,
        limit: Int
    ): ListPageVO<AptTradeVO.AptTrade> {

        kafkaTemplate.send(
            "apt-log",
            "[apt][service] getAptTrade (sgg=${sgg}, aptName=${aptName}, offset=${offset}, limit=${limit})"
        )
        kafkaTemplate.send(
            "all-log",
            "[apt][service] getAptTrade (sgg=${sgg}, aptName=${aptName}, offset=${offset}, limit=${limit})"
        )

        return aptTradeQueryPort.findByAptNmWithPage(
            sgg = sgg,
            aptName = aptName,
            pageRequest = PageRequest.of(
                offset, limit
            )
        ).toVO()
    }

    override fun getAptInDong(
        si: String,
        gu: String,
        dong: String,
    ): List<AptTradeVO.AptTrade> {
        kafkaTemplate.send(
            "apt-log",
            "[apt][service] getAptInDong (si=${si}, gu=${gu}, dong=${dong})"
        )
        kafkaTemplate.send(
            "all-log",
            "[apt][service] getAptInDong (si=${si}, gu=${gu}, dong=${dong})"
        )

        return aptTradeQueryPort.findAllByDong(
            si = si,
            gu = gu,
            dong = dong,
        ).map { it.toVO() }
    }
}