package org.sherlockhomes.homes.batch.adaptor.outbound

import org.sherlockhomes.homes.batch.application.port.outbound.SearchMonoRentQueryPort
import org.sherlockhomes.homes.batch.domain.MonoRent
import org.sherlockhomes.homes.batch.domain.mapper.toDomain
import org.sherlockhomes.homes.infra.webclient.dto.SearchMonoRentResponseDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import java.net.URI

@Component
class SearchMonoRentAdaptor(
    private val webClient: WebClient,
) : SearchMonoRentQueryPort {

    @Value("\${ENCODING_KEY}")
    lateinit var ENCODING_KEY: String

    @Value("\${TYPE_KEY}")
    lateinit var TYPE_KEY: String

    @Value("\${GET_MONO_HOUSE_RENT_URI}")
    lateinit var GET_MONO_HOUSE_RENT_URI: String

    override fun searchMonoRent(lawdCd: Int, dealYmd: Int): List<MonoRent> {

        val LAWD_CD = "LAWD_CD=${lawdCd}"
        val DEAL_YMD = "DEAL_YMD=${dealYmd}"

        val serviceKey = "serviceKey=${ENCODING_KEY}"
        val pageNo = "pageNo=1"
        val numOfRows = "numOfRow=10"

        val requestURI = GET_MONO_HOUSE_RENT_URI + "?" +
                LAWD_CD + "&" +
                DEAL_YMD + "&" +
                serviceKey + "&" +
                pageNo + "&" +
                numOfRows + "&" +
                TYPE_KEY

        val bodyToMono = webClient.get()
            .uri(URI(requestURI))
            .retrieve()
            .bodyToMono(SearchMonoRentResponseDTO.ResponseResults::class.java)
            .onErrorComplete()
            .block()

        return bodyToMono!!.toDomain()
    }
}