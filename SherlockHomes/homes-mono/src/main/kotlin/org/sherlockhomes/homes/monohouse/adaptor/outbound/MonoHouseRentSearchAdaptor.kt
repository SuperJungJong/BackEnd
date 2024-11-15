package org.sherlockhomes.homes.monohouse.adaptor.outbound

import org.sherlockhomes.homes.monohouse.application.port.outbound.MonoHouseSearchPort
import org.sherlockhomes.homes.infra.webclient.VO.MonoHouseRentSearchVO
import org.sherlockhomes.homes.infra.webclient.mapper.toDomain
import org.sherlockhomes.homes.monohouse.domain.MonoHouseRent
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import java.net.URI

@Component
class MonoHouseRentSearchAdaptor (
    private val webClient: WebClient
) : MonoHouseSearchPort<MonoHouseRent> {

    @Value("\${ENCODING_KEY}")
    lateinit var ENCODING_KEY: String

    @Value("\${TYPE_KEY}")
    lateinit var TYPE_KEY: String

    @Value("\${GET_MONO_HOUSE_RENT_URI}")
    lateinit var END_POINT: String

    override fun search(lawdCd: Int, dealYmd: Int): List<MonoHouseRent> {

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
            .bodyToMono(MonoHouseRentSearchVO.ResponseResults::class.java)
            .block()

        return bodyToMono!!.toDomain()
    }
}