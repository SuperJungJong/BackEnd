package org.sherlockhomes.homes.user.adaptor.outbound

import io.jsonwebtoken.Header
import org.sherlockhomes.homes.user.application.port.outbound.NaverSocialLoginPort
import org.sherlockhomes.homes.user.domain.NaverLoginResponse
import org.sherlockhomes.homes.user.domain.NaverOauthCredential
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import java.net.http.HttpTimeoutException

@Component
class NaverSocialLoginAdaptor(
    private val webClient: WebClient,
) : NaverSocialLoginPort {

    @Value("\${NAVER_CLIENT_ID}")
    lateinit var NAVER_CLIENT_ID: String

    @Value("\${NAVER_CLIENT_SECRET}")
    lateinit var NAVER_CLIENT_SECRET: String

    @Value("\${NAVER_ACCESS_TOKEN_URL}")
    lateinit var NAVER_ACCESS_TOKEN_URL: String

    @Value("\${NAVER_USER_INFO_URL}")
    lateinit var NAVER_USER_INFO_URL: String


    override fun getCi(credential: NaverOauthCredential): String {
        val naverAccessToken = getNaverAccessToken(credential)

        if (naverAccessToken != null) {
            val response = getCiFromNaver(naverAccessToken)
            return response!!.response.id
        }
        return ""
    }

    //TODO: WebClient timeout 등 설정하기...
    private fun getNaverAccessToken(credential: NaverOauthCredential): NaverLoginResponse.tokens? =
        webClient.post()
            .uri(NAVER_ACCESS_TOKEN_URL)
            .body(
                BodyInserters.fromFormData("grant_type", "authorization_code")
                    .with("client_id", NAVER_CLIENT_ID)
                    .with("client_secret", NAVER_CLIENT_SECRET)
                    .with("code", credential.code)
                    .with("state", credential.state)
            )
            .header("Content-Type", "application/x-www-form-urlencoded")
            .retrieve()
            .bodyToMono(NaverLoginResponse.tokens::class.java)
            .onErrorMap { HttpTimeoutException("[Time Out 예외] 네이버 AccessToken") }
            .block()

    private fun getCiFromNaver(naverAccessToken: NaverLoginResponse.tokens): NaverLoginResponse.UserInfo? =
        webClient.post()
            .uri(NAVER_USER_INFO_URL)
            .header("Authorization", naverAccessToken.token_type + " " + naverAccessToken.access_token)
            .retrieve()
            .bodyToMono(NaverLoginResponse.UserInfo::class.java)
            .onErrorMap { HttpTimeoutException("[Time Out 예외] 네이버 AccessToken") }
            .block()
}