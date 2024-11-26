package org.sherlockhomes.homes.apartment.application.port.inbound

import org.sherlockhomes.homes.apartment.application.service.vo.rent.AptRentVO

interface AptRentQuery {

    fun getListBySiGuDong(si: String, gu: String, dong: String): List<AptRentVO.ApartmentRent>

    fun getAptRentDetail(si: String, gu: String, dong: String, name: String): List<AptRentVO.ApartmentRent>
}