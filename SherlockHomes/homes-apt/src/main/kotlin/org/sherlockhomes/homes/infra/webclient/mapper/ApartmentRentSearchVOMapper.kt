package org.sherlockhomes.homes.infra.webclient.mapper

import org.sherlockhomes.homes.apartment.domain.AptRent
import org.sherlockhomes.homes.infra.webclient.VO.ApartmentRentSearchVO

fun ApartmentRentSearchVO.ResponseResults.toDomain(
): List<AptRent> =
    response.body.items.item.map {
        it.toDomain()
    }


fun ApartmentRentSearchVO.Item.toDomain(
): AptRent = AptRent(
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
)
