package org.sherlockhomes.homes.apartment.adaptor.outbound

import org.sherlockhomes.homes.apartment.application.port.outbound.ApartmentSearchPort
import org.sherlockhomes.homes.apartment.domain.ApartmentTrade
import org.sherlockhomes.homes.infra.webclient.VO.ApartmentTradeSearchVO
import org.sherlockhomes.homes.infra.webclient.mapper.toDomain
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import java.net.URI

@Component
class ApartmentTradeSearchAdaptor (
    private val webClient: WebClient
) : ApartmentSearchPort<ApartmentTrade> {

    @Value("\${ENCODING_KEY}")
    lateinit var ENCODING_KEY: String

    @Value("\${TYPE_KEY}")
    lateinit var TYPE_KEY: String

    @Value("\${GET_APARTMENT_TRADE_URI}")
    lateinit var END_POINT: String

    override fun search(lawdCd: Int, dealYmd: Int): List<ApartmentTrade> {

        val LAWD_CD = "LAWD_CD=${lawdCd}"
        val DEAL_YMD = "DEAL_YMD=${dealYmd}"

        val serviceKey = "serviceKey=${ENCODING_KEY}"
        val pageNo = "pageNo=1"
        val numOfRows = "numOfRow=10"

        val requestURI = END_POINT + "?" +
                LAWD_CD + "&" +
                DEAL_YMD + "&" +
                serviceKey + "&" +
                pageNo + "&" +
                numOfRows + "&" +
                TYPE_KEY

        val bodyToMono = webClient.get()
            .uri(URI( requestURI))
            .retrieve()
            .bodyToMono(ApartmentTradeSearchVO.ResponseResults::class.java)
            .block()

        return bodyToMono!!.toDomain()
    }
}