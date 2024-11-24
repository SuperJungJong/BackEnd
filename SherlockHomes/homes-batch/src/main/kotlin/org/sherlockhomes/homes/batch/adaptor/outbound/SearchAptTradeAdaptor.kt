package org.sherlockhomes.homes.batch.adaptor.outbound

import org.sherlockhomes.homes.batch.application.port.outbound.SearchAptTradeQueryPort
import org.sherlockhomes.homes.batch.domain.AptTrade
import org.sherlockhomes.homes.batch.domain.mapper.toDomain
import org.sherlockhomes.homes.infra.webclient.dto.SearchAptTradeResponseDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import java.net.URI

@Component
class SearchAptTradeAdaptor(
    private val webClient: WebClient,
) : SearchAptTradeQueryPort {

    @Value("\${ENCODING_KEY}")
    lateinit var ENCODING_KEY: String

    @Value("\${TYPE_KEY}")
    lateinit var TYPE_KEY: String

    @Value("\${GET_APARTMENT_TRADE_URI}")
    lateinit var GET_APARTMENT_TRADE_URI: String

    override fun searchAptTrade(lawdCd: Int, dealYmd: Int): List<AptTrade> {

        val LAWD_CD = "LAWD_CD=${lawdCd}"
        val DEAL_YMD = "DEAL_YMD=${dealYmd}"

        val serviceKey = "serviceKey=${ENCODING_KEY}"
        val pageNo = "pageNo=1"
        val numOfRows = "numOfRow=10"

        val requestURI = GET_APARTMENT_TRADE_URI + "?" +
                LAWD_CD + "&" +
                DEAL_YMD + "&" +
                serviceKey + "&" +
                pageNo + "&" +
                numOfRows + "&" +
                TYPE_KEY

        val bodyToMono = webClient.get()
            .uri(URI(requestURI))
            .retrieve()
            .bodyToMono(SearchAptTradeResponseDTO.ResponseResults::class.java)
            .onErrorComplete()
            .block()

        return bodyToMono!!.toDomain()
    }
}