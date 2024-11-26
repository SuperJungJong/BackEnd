package org.sherlockhomes.homes.apartment.adaptor.outbound

import org.sherlockhomes.homes.apartment.application.port.outbound.ApartmentSearchPort
import org.sherlockhomes.homes.apartment.domain.AptRent
import org.sherlockhomes.homes.infra.webclient.VO.ApartmentRentSearchVO
import org.sherlockhomes.homes.infra.webclient.mapper.toDomain
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import java.net.URI

@Component
class ApartmentRentSearchAdaptor(
    private val webClient: WebClient,
    private val kafkaTemplate: KafkaTemplate<String, String>
) : ApartmentSearchPort<AptRent> {

    @Value("\${ENCODING_KEY}")
    lateinit var ENCODING_KEY: String

    @Value("\${TYPE_KEY}")
    lateinit var TYPE_KEY: String

    @Value("\${GET_APARTMENT_RENT_URI}")
    lateinit var END_POINT: String

    override fun search(lawdCd: Int, dealYmd: Int): List<AptRent> {

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
            .uri(URI(requestURI))
            .retrieve()
            .bodyToMono(ApartmentRentSearchVO.ResponseResults::class.java)
            .block()

        kafkaTemplate.send(
            "apt-log",
            "[apt][adaptor][end] ApartmentRentSearchAdaptor.search (lawdCd=${lawdCd}, dealYmd=${dealYmd}) (result=${bodyToMono})"
        )
        kafkaTemplate.send(
            "all-log",
            "[apt][adaptor][end] ApartmentRentSearchAdaptor.search (lawdCd=${lawdCd}, dealYmd=${dealYmd}) (result=${bodyToMono})"
        )
        return bodyToMono!!.toDomain()
    }
}