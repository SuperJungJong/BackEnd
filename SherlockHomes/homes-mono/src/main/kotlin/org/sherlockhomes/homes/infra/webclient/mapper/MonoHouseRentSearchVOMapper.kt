package org.sherlockhomes.homes.infra.webclient.mapper

import org.sherlockhomes.homes.infra.webclient.VO.MonoHouseRentSearchVO
import org.sherlockhomes.homes.monohouse.domain.MonoHouseRent

fun MonoHouseRentSearchVO.ResponseResults.toDomain(
): List<MonoHouseRent> =
    response.body.items.item.map {
        it.toDomain()
    }


fun MonoHouseRentSearchVO.Item.toDomain(
): MonoHouseRent = MonoHouseRent(
    buildYear= buildYear,
    contractTerm= contractTerm,
    contractType= contractType,
    dealDay= dealDay,
    dealMonth= dealMonth,
    dealYear= dealYear,
    deposit= deposit,
    houseType= houseType,
    monthlyRent= monthlyRent,
    preDeposit= preDeposit,
    preMonthlyRent= preMonthlyRent,
    sggCd= sggCd,
    totalFloorAr= totalFloorAr,
    umdNm= umdNm,
    useRRRight= useRRRight,
)
