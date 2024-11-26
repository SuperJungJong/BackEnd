package org.sherlockhomes.homes.monohouse.domain.mapper

import org.sherlockhomes.homes.infra.rdb.entity.MonoRentEntity
import org.sherlockhomes.homes.monohouse.application.service.rent.vo.MonoHouseRentVO
import org.sherlockhomes.homes.monohouse.domain.MonoHouseRent


fun MonoHouseRent.toVO(): MonoHouseRentVO.MonoHouseRent =
    MonoHouseRentVO.MonoHouseRent(
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
        sgg = sgg,
        si = si,
        gu = gu,
        dong = dong,
    )

fun MonoRentEntity.toDomain() =
    MonoHouseRent(
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
        sgg = sgg,
        si = si,
        gu = gu,
        dong = dong,
    )