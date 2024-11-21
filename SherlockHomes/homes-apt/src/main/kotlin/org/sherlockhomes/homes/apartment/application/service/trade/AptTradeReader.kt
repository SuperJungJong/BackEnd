package org.sherlockhomes.homes.apartment.application.service.trade

import org.sherlockhomes.homes.apartment.application.port.inbound.AptTradeQuery
import org.sherlockhomes.homes.apartment.application.port.outbound.AptTradeQueryPort
import org.sherlockhomes.homes.apartment.application.service.vo.trade.AptTradeVO
import org.sherlockhomes.homes.apartment.application.service.vo.trade.ListPageVO
import org.sherlockhomes.homes.apartment.domain.mapper.toVO
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component

@Component
class AptTradeReader(
    private val aptTradeQueryPort: AptTradeQueryPort,
) : AptTradeQuery {
    override fun getAptTrade(
        aptName: String, offset: Int, limit: Int
    ): ListPageVO<AptTradeVO.AptTrade> =

        aptTradeQueryPort.findByAptNmWithPage(
            aptName = aptName,
            pageRequest = PageRequest.of(
                offset, limit
            )
        ).toVO()

    override fun getAptInDong(dong: String): List<AptTradeVO.AptTrade> =
        aptTradeQueryPort.findAllByDong(dong).map { it.toVO() }
}