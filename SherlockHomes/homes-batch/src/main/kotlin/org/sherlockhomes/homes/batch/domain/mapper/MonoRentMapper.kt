package org.sherlockhomes.homes.batch.domain.mapper

import org.sherloc.GuCode
import org.sherlockhomes.homes.batch.domain.MonoRent
import org.sherlockhomes.homes.infra.rdb.entity.mono.MonoRentEntity
import org.sherlockhomes.homes.infra.webclient.dto.SearchMonoRentResponseDTO

private val gucode: GuCode = GuCode()

fun MonoRent.toEntity() =
    MonoRentEntity(
        buildYear = buildYear,
        contractTerm = contractTerm,
        contractType = contractType,
        dealDay = dealDay,
        dealMonth = dealMonth,
        dealYear = dealYear,
        deposit = deposit,
        monthlyRent = monthlyRent,
        preDeposit = preDeposit,
        preMonthlyRent = preMonthlyRent,
        sggCd = sggCd,
        umdNm = umdNm,
        useRRRight = useRRRight,
        si = si,
        gu = gu,
        dong = dong,
        houseType = houseType,
        sgg = sgg,
        totalFloorAr = totalFloorAr
    )

fun SearchMonoRentResponseDTO.ResponseResults.toDomain(

): List<MonoRent> =
    response.body.items.item.map {
        it.toDomain()
    }

fun SearchMonoRentResponseDTO.Item.toDomain(

): MonoRent {
    val sigu = gucode.getSiGu(sggCd!!)
    val si = sigu?.split(" ")?.get(0)
    val gu = sigu?.split(" ")?.get(1)

    return MonoRent(
        buildYear = buildYear,
        contractTerm = contractTerm,
        contractType = contractType,
        dealDay = dealDay,
        dealMonth = dealMonth,
        dealYear = dealYear,
        deposit = deposit,
        houseType = houseType,
        monthlyRent = monthlyRent,
        preDeposit = preDeposit,
        preMonthlyRent = preMonthlyRent,
        sggCd = sggCd,
        totalFloorAr = totalFloorAr,
        umdNm = umdNm,
        useRRRight = useRRRight,
        si = si.toString(),
        gu = gu.toString(),
        sgg = si + " " + gu + " " + umdNm,
        dong = umdNm,
    )
}
