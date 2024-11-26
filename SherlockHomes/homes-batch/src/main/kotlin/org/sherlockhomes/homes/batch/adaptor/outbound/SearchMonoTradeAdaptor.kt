package org.sherlockhomes.homes.batch.adaptor.outbound

import org.sherlockhomes.homes.batch.application.port.outbound.SearchMonoTradeQueryPort
import org.sherlockhomes.homes.batch.domain.MonoTrade
import org.sherlockhomes.homes.batch.domain.mapper.toDomain
import org.sherlockhomes.homes.infra.webclient.dto.SearchMonoTradeResponseDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import java.net.URI

@Component
class SearchMonoTradeAdaptor(
    private val webClient: WebClient,
) : SearchMonoTradeQueryPort {

    @Value("\${ENCODING_KEY}")
    lateinit var ENCODING_KEY: String

    @Value("\${TYPE_KEY}")
    lateinit var TYPE_KEY: String

    @Value("\${GET_MONO_HOUSE_TRADE_URI}")
    lateinit var GET_MONO_HOUSE_TRADE_URI: String

    override fun searchMonoTrade(lawdCd: Int, dealYmd: Int): List<MonoTrade> {
        val LAWD_CD = "LAWD_CD=${lawdCd}"
        val DEAL_YMD = "DEAL_YMD=${dealYmd}"

        val serviceKey = "serviceKey=${ENCODING_KEY}"
        val pageNo = "pageNo=1"
        val numOfRows = "numOfRow=100"

        val requestURI = GET_MONO_HOUSE_TRADE_URI + "?" +
                LAWD_CD + "&" +
                DEAL_YMD + "&" +
                serviceKey + "&" +
                pageNo + "&" +
                numOfRows + "&" +
                TYPE_KEY

        val bodyToMono = webClient.get()
            .uri(URI(requestURI))
            .retrieve()
            .bodyToMono(SearchMonoTradeResponseDTO.ResponseResults::class.java)
            .onErrorComplete()
            .block()

        return bodyToMono!!.toDomain()
    }
}