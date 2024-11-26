package org.sherlockhomes.homes.batch.adaptor.outbound

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.reactive.function.BodyInserters.fromFormData
import org.springframework.web.reactive.function.client.WebClient
import java.net.URI
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@Component
class BuildingDataQueryAdaptor(
    private val webClient: WebClient,
) {

    @Value("\${BUILDING_API_URL}")
    lateinit var BUILDING_API_URL: String

    fun getBuildingData() {
        val format = LocalDateTime.now().minus(1, ChronoUnit.DAYS).format(
            DateTimeFormatter.ofPattern("YYYYMM")
        )
        val map: MultiValueMap<String, String> = LinkedMultiValueMap()
        map.add("srhThingNo", "A")
        map.add("srhDelngSecd", "1")
        map.add("srhAddrGbn", "1")
        map.add("srhLfstsSecd", "1")
        map.add("sidoNm", "전체")
        map.add("sggNm", "전체")
        map.add("emdNm", "전체")
        map.add("loadNm", "전체")
        map.add("areaNm", "전체")
        map.add("hsmpNm", "전체")
        map.add("srhFromDt", "2024-11-13")
        map.add("srhToDt", "2024-11-13")

        val bodyToMono = webClient.post()
            .uri(URI("https://rt.molit.go.kr/pt/xls/ptXlsCSVDown.do"))
            .body(fromFormData(map))
            .retrieve()
            .bodyToMono(String::class.java)
            .block()


//        val restTemplate = RestTemplate()
//        val headers = HttpHeaders()
//        headers.contentType = MediaType.APPLICATION_FORM_URLENCODED // 요청의 Content-Type 설정

        // Body 생성
//        val body: MultiValueMap<String, String> = LinkedMultiValueMap()
//        body.add("param1", "value1") // 여기에 요청에 필요한 매개변수 추가
//        body.add("param2", "value2")
//
//        val requestEntity = HttpEntity(body, headers)


        // POST 요청 보내기
//        val response = restTemplate.getForObject(
//            "http://rt.molit.go.kr/pt/xls/ptXlsCSVDown.do?srhThingNo=A&srhDelngSecd=1&srhAddrGbn=1&srhLfstsSecd=1&srhFromDt=2024-11-13&srhToDt=2024-11-14",
//            ByteArray::class.java
//        )
//

    }
}