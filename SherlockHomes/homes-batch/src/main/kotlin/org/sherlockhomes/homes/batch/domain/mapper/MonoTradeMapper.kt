package org.sherlockhomes.homes.batch.domain.mapper

import org.sherloc.GuCode
import org.sherlockhomes.homes.batch.domain.MonoTrade
import org.sherlockhomes.homes.infra.rdb.entity.mono.MonoTradeEntity
import org.sherlockhomes.homes.infra.webclient.dto.SearchMonoTradeResponseDTO

private val gucode: GuCode = GuCode()

fun MonoTrade.toEntity() =
    MonoTradeEntity(
        buildYear = buildYear,
        dealDay = dealDay,
        dealMonth = dealMonth,
        dealYear = dealYear,
        sggCd = sggCd,
        umdNm = umdNm,
        si = si,
        gu = gu,
        dong = dong,
        houseType = houseType,
        totalFloorAr = totalFloorAr,
        buyerGbn = buyerGbn,
        dealAmount = dealAmount,
        plottageAr = plottageAr,
        sgg = sgg,
    )

fun SearchMonoTradeResponseDTO.ResponseResults.toDomain(
): List<MonoTrade> =
    response.body.items.item.map {
        it.toDomain()
    }

fun SearchMonoTradeResponseDTO.Item.toDomain(
): MonoTrade {
    val sigu = gucode.getSiGu(sggCd)
    val si = sigu?.split(" ")?.get(0)
    val gu = sigu?.split(" ")?.get(1)
    println("si = ${si}")
    println("gi = ${gu}")
    return MonoTrade(
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
        houseType = houseType,
        jibun = jibun,
        plottageAr = plottageAr,
        sggCd = sggCd,
        slerGbn = slerGbn,
        totalFloorAr = totalFloorAr,
        umdNm = umdNm,
        si = si.toString(),
        gu = gu.toString(),
        sgg = si + " " + gu + " " + umdNm,
        dong = umdNm,
    )
}