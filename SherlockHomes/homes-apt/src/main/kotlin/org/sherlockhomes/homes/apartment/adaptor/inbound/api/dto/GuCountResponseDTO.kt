package org.sherlockhomes.homes.apartment.adaptor.inbound.api.dto

class GuCountResponseDTO {

    data class Response(
        val siName: String,
        val guName: String,
        val count: Int,
    )
}