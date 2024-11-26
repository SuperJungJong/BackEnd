package org.sherlockhomes.homes.ai.adaptor.outbound

import org.sherlockhomes.homes.ai.application.port.outbound.KakaoSearchPort
import org.sherlockhomes.homes.ai.domain.BuildingImg
import org.sherlockhomes.homes.ai.domain.mapper.toDomain
import org.sherlockhomes.homes.infra.webclient.dto.BuildingImgResponseDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import java.net.URI

@Component
class KakaoSearchAdaptor(
    private val webClient: WebClient,
    private val kafkaTemplate: KafkaTemplate<String, String>
) : KakaoSearchPort {

    @Value("\${KAKAO_API}")
    lateinit var KAKAO_API: String

    @Value("\${KAKAO_URL}")
    lateinit var KAKAO_URL: String

    override fun kakaoImgSearch(si: String, gu: String, dong: String, name: String): BuildingImg {
        val replace = name.replace(" ", "%20")

        val query = gu + "%20" + dong + "%20" + replace
        val requestURI = KAKAO_URL + "?" +
                "query=" + query + "&" +
                "sort=accuracy&" +
                "page=1&" +
                "size=1"

        val bodyToMono = webClient.get()
            .uri(requestURI)
            .header("Authorization", KAKAO_API)
            .retrieve()
            .bodyToMono(BuildingImgResponseDTO.Response::class.java)
            .block()

        return bodyToMono!!.toDomain()

    }
}