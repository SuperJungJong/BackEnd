package org.sherlockhomes.homes.apartment.adaptor.outbound

import org.sherlockhomes.homes.apartment.application.port.outbound.AptTradeQueryPort
import org.sherlockhomes.homes.apartment.domain.AptTrade
import org.sherlockhomes.homes.apartment.domain.ListPage
import org.sherlockhomes.homes.apartment.domain.mapper.toDomain
import org.sherlockhomes.homes.infra.rdb.repository.AptTradeRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component

@Component
class AptTradeQueryAdaptor(
    private val aptTradeRepository: AptTradeRepository,
) : AptTradeQueryPort {
    override fun findByAptNmWithPage(aptName: String, pageRequest: PageRequest): ListPage<AptTrade> {
        val findAptTrade = aptTradeRepository.findAllByAptNmOrderByDealYDescDealMDescDealDDesc(
            aptNm = aptName,
            pageRequest = pageRequest,
        )

        return ListPage(
            items = findAptTrade
                .content.map { it.toDomain() },
            total = findAptTrade.totalElements,
            totalPage = findAptTrade.totalPages,
        )
    }

    override fun findAllByDong(dong: String): List<AptTrade> {
        val resultList = ArrayList<AptTrade>()
        val nmList = HashSet<String>()
        val aptTradeList = aptTradeRepository.findAllByDong(dong).map { it.toDomain() }

        aptTradeList.forEach { aptTrade ->
            if (!nmList.contains(aptTrade.aptNm)) {
                println(aptTrade.aptNm)
                resultList.add(aptTrade)
                nmList.add(aptTrade.aptNm!!)
            }
        }

        println(resultList.size)
        return resultList
    }
}