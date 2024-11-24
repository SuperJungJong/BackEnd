package org.sherlockhomes.homes.batch.domain.mapper

import org.sherloc.GuCode
import org.sherlockhomes.homes.batch.domain.AptTrade
import org.sherlockhomes.homes.infra.rdb.entity.apt.AptTradeEntity
import org.sherlockhomes.homes.infra.webclient.dto.SearchAptTradeResponseDTO

private val gucode: GuCode = GuCode()

fun AptTrade.toEntity() =
    AptTradeEntity(
        sgg = sgg,
        si = si,
        gu = gu,
        dong = dong,
        aptNm = aptNm,
        buildYear = buildYear.toString(),
        dealAmount = dealAmount,
        floor = floor,
        jibun = jibun,
        roadNm = roadNm,
        dealD = dealDay,
        dealM = dealMonth,
        dealY = dealYear,
        exduUseAr = excluUseAr!!.toDouble(),
    )

fun SearchAptTradeResponseDTO.ResponseResults.toDomain(
): List<AptTrade> =
    response.body.items.item.map {
        it.toDomain()
    }

fun SearchAptTradeResponseDTO.Item.toDomain(
): AptTrade {
    val sigu = gucode.getSiGu(sggCd)
    val si = sigu?.split(" ")?.get(0)
    val gu = sigu?.split(" ")?.get(1)

    return AptTrade(
        aptDong = aptDong,
        aptNm = aptNm,
        aptSeq = aptSeq,
        bonbun = bonbun,
        bubun = bubun,
        buildYear = buildYear,
        buyerGbn = buyerGbn,
        cdealDay = cdealDay,
        cdealType = cdealType,
        dealAmount = dealAmount,
        dealDay = dealDay,
        dealMonth = dealMonth,
        dealYear = dealYear,
        dealingGbn = dealingGbn,
        estateAgentSggNm = estateAgentSggNm,
        excluUseAr = excluUseAr,
        floor = floor,
        jibun = jibun,
        landCd = landCd,
        landLeaseholdGbn = landLeaseholdGbn,
        rgstDate = rgstDate,
        roadNm = roadNm,
        roadNmBonbun = roadNmBonbun,
        roadNmBubun = roadNmBubun,
        roadNmCd = roadNmCd,
        roadNmSeq = roadNmSeq,
        roadNmSggCd = roadNmSggCd,
        roadNmbCd = roadNmbCd,
        sggCd = sggCd,
        slerGbn = slerGbn,
        umdCd = umdCd,
        umdNm = umdNm,
        si = si.toString(),
        gu = gu.toString(),
        sgg = si + " " + gu + " " + umdNm,
        dong = umdNm,
    )
}