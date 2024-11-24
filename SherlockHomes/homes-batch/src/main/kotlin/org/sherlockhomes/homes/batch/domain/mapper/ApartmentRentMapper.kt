package org.sherlockhomes.homes.batch.domain.mapper

import org.sherloc.GuCode
import org.sherlockhomes.homes.batch.domain.AptRent
import org.sherlockhomes.homes.infra.rdb.entity.apt.AptRentEntity
import org.sherlockhomes.homes.infra.webclient.dto.SearchAptRentResponseDTO

private val gucode: GuCode = GuCode()

fun AptRent.toEntity() =
    AptRentEntity(
        aptNm = aptNm,
        buildYear = buildYear,
        contractTerm = contractTerm,
        contractType = contractType,
        dealDay = dealDay,
        dealMonth = dealMonth,
        dealYear = dealYear,
        deposit = deposit,
        excluUseAr = excluUseAr,
        floor = floor,
        jibun = jibun,
        monthlyRent = monthlyRent,
        preDeposit = preDeposit,
        preMonthlyRent = preMonthlyRent,
        sggCd = sggCd,
        umdNm = umdNm,
        useRRRight = useRRRight,
        sgg = sgg,
        si = si,
        gu = gu,
        dong = dong,
    )

fun SearchAptRentResponseDTO.ResponseResults.toDomain(
): List<AptRent> =
    response.body.items.item.map {
        it.toDomain()
    }

fun SearchAptRentResponseDTO.Item.toDomain(
): AptRent {
    val sigu = gucode.getSiGu(sggCd)
    val si = sigu?.split(" ")?.get(0)
    val gu = sigu?.split(" ")?.get(1)

    return AptRent(
        aptNm = aptNm,
        buildYear = buildYear,
        contractTerm = contractTerm,
        contractType = contractType,
        dealDay = dealDay,
        dealMonth = dealMonth,
        dealYear = dealYear,
        deposit = deposit.toString(),
        excluUseAr = excluUseAr,
        floor = floor,
        jibun = jibun,
        monthlyRent = monthlyRent,
        preDeposit = preDeposit,
        preMonthlyRent = preMonthlyRent,
        sggCd = sggCd,
        umdNm = umdNm,
        useRRRight = useRRRight,
        si = si.toString(),
        gu = gu.toString(),
        sgg = si + " " + gu + " " + umdNm,
        dong = umdNm,
    )
}