package org.sherlockhomes.homes.user.adaptor.inbound.api

import io.swagger.v3.oas.annotations.Operation
import org.sherlockhomes.homes.common.responsemodel.ResponseModel
import org.sherlockhomes.homes.user.adaptor.inbound.api.dto.NaverSocialLoginRequestDTO
import org.sherlockhomes.homes.user.adaptor.inbound.api.dto.SocialLoginResponseDTO
import org.sherlockhomes.homes.user.adaptor.inbound.api.mapper.toResponse
import org.sherlockhomes.homes.user.adaptor.inbound.api.mapper.toVO
import org.sherlockhomes.homes.user.application.port.inbound.SocialLoginUseCase
import org.sherlockhomes.homes.user.application.service.user.VO.NaverLoginVO
import org.sherlockhomes.homes.user.application.service.user.VO.UserVO
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/social/naver")
class NaverSocialLoginApi(
    private val socialLoginUseCase: SocialLoginUseCase<NaverLoginVO.NaverOauthCredential, UserVO.Save>,
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    @Operation(summary = "네이버로 가입")
    @PostMapping("/signup")
    fun signup(
        @RequestBody naverOauthCredential: NaverSocialLoginRequestDTO.Signup
    ): ResponseModel<SocialLoginResponseDTO.Response> {
        kafkaTemplate.send(
            "user-log",
            "[user][controller] /signup, request (naverOauthCredential=${naverOauthCredential})"
        )
        kafkaTemplate.send(
            "user-log",
            "[user][controller] /signup, request (naverOauthCredential=${naverOauthCredential})"
        )

        return ResponseModel.of(
            socialLoginUseCase.signup(
                credential = naverOauthCredential.naverCredential.toVO(),
                userInfo = naverOauthCredential.user.toVO(),
            ).toResponse()
        )
    }

    @Operation(summary = "네이버로 로그인")
    @PostMapping("login")
    fun login(
        @RequestBody credential: NaverSocialLoginRequestDTO.NaverOauthCredential
    ): ResponseModel<SocialLoginResponseDTO.Response> {
        kafkaTemplate.send(
            "user-log",
            "[user][controller] /login, request (credential=${credential})"
        )
        kafkaTemplate.send(
            "user-log",
            "[user][controller] /login, request (credential=${credential})"
        )

        return ResponseModel.of(
            socialLoginUseCase.login(
                credential = credential.toVO(),
            ).toResponse()
        )
    }
}