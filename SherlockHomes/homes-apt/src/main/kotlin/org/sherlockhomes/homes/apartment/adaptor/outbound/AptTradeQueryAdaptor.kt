package org.sherlockhomes.homes.apartment.adaptor.outbound

import org.sherlockhomes.homes.apartment.application.port.outbound.AptTradeQueryPort
import org.sherlockhomes.homes.apartment.domain.AptTrade
import org.sherlockhomes.homes.apartment.domain.ListPage
import org.sherlockhomes.homes.apartment.domain.mapper.toDomain
import org.sherlockhomes.homes.infra.rdb.repository.AptTradeRepository
import org.springframework.data.domain.PageRequest
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class AptTradeQueryAdaptor(
    private val aptTradeRepository: AptTradeRepository,
    private val kafkaTemplate: KafkaTemplate<String, String>
) : AptTradeQueryPort {
    override fun findByAptNmWithPage(sgg: String, aptName: String, pageRequest: PageRequest): ListPage<AptTrade> {
        val findAptTrade = aptTradeRepository.findAllByAptNmAndSggOrderByDealYDescDealMDescDealDDesc(
            sgg = sgg,
            aptNm = aptName,
            pageRequest = pageRequest,
        )

        kafkaTemplate.send(
            "apt-log",
            "[apt][adaptor][end] AptTradeQueryAdaptor.findByAptNmWithPage (sgg=${sgg}, aptName=${aptName})"
        )
        kafkaTemplate.send(
            "all-log",
            "[apt][adaptor][end] AptTradeQueryAdaptor.findByAptNmWithPage (sgg=${sgg}, aptName=${aptName})"
        )

        return ListPage(
            items = findAptTrade
                .content.map { it.toDomain() },
            total = findAptTrade.totalElements,
            totalPage = findAptTrade.totalPages,
        )
    }

    override fun findAllByDong(
        si: String,
        gu: String,
        dong: String,
    ): List<AptTrade> {
        val resultList = ArrayList<AptTrade>()
        val nmList = HashSet<String>()
        val aptTradeList = aptTradeRepository.findAllBySiAndGuAndDong(
            si = si,
            gu = gu,
            dong = dong,
        ).map { it.toDomain() }

        kafkaTemplate.send(
            "apt-log",
            "[apt][adaptor][end] AptTradeQueryAdaptor.findAllByDong (si=${si}, gu=${gu}, dong=${dong})"
        )
        kafkaTemplate.send(
            "all-log",
            "[apt][adaptor][end] AptTradeQueryAdaptor.findAllByDong (si=${si}, gu=${gu}, dong=${dong})"
        )

        aptTradeList.forEach { aptTrade ->
            if (!nmList.contains(aptTrade.aptNm)) {
                resultList.add(aptTrade)
                nmList.add(aptTrade.aptNm!!)
            }
        }

        return resultList
    }
}