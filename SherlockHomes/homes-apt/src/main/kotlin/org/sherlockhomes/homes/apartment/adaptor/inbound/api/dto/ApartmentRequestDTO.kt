package org.sherlockhomes.homes.apartment.adaptor.inbound.api.dto

class ApartmentRequestDTO {
    data class SearchTrade(
        val sido: String,
        val gugun: String,
        val year: Int?,
        val month: Int?,
        val day: Int?,
    )

    data class SearchRent(
        val sido: String,
        val gugun: String,
        val year: Int?,
        val month: Int?,
        val day: Int?,
    )
}