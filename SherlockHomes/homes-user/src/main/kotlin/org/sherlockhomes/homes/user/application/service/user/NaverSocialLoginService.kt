package org.sherlockhomes.homes.user.application.service.user

import org.sherlockhomes.homes.common.utils.JwtUtil
import org.sherlockhomes.homes.user.application.port.inbound.SocialLoginUseCase
import org.sherlockhomes.homes.user.application.port.outbound.*
import org.sherlockhomes.homes.user.application.service.user.VO.NaverLoginVO
import org.sherlockhomes.homes.user.application.service.user.VO.SocialLoginVO
import org.sherlockhomes.homes.user.application.service.user.VO.UserVO
import org.sherlockhomes.homes.user.domain.RefreshToken
import org.sherlockhomes.homes.user.domain.mapper.toDomain
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.client.HttpClientErrorException
import java.net.http.HttpTimeoutException
import java.util.Objects

@Service
class NaverSocialLoginService(
    private val naverSocialLoginPort: NaverSocialLoginPort,
    private val userQueryPort: UserQueryPort,
    private val userCommandPort: UserCommandPort,
    private val refreshTokenQueryPort: RefreshTokenQueryPort,
    private val refreshTokenCommandPort: RefreshTokenCommandPort,
    private val jwtUtil: JwtUtil,
) : SocialLoginUseCase<NaverLoginVO.NaverOauthCredential, UserVO.Save> {

    @Transactional
    override fun signup(credential: NaverLoginVO.NaverOauthCredential, userInfo: UserVO.Save): SocialLoginVO.Token {

        val ci = naverSocialLoginPort.getCi(
            credential = credential.toDomain(),
        )

        val user = userInfo.toDomain(ci, "naver")

        val userId = userCommandPort.save(user)

        val accessToken = jwtUtil.generateAccessToken(userId)
        val refreshToken = jwtUtil.generateRefreshToken(userId)

        val refreshTokenDomain = RefreshToken(
            userId = userId,
            ci = ci,
            refreshToken = refreshToken,
        )

        refreshTokenCommandPort.saveRefreshToken(refreshTokenDomain)

        return SocialLoginVO.Token(
            accessToken = accessToken,
            refreshToken = refreshToken,
        )
    }

    @Transactional
    override fun login(credential: NaverLoginVO.NaverOauthCredential): SocialLoginVO.Token {

        val ci = naverSocialLoginPort.getCi(credential.toDomain())
        val user = userQueryPort.findByCi(ci)

        if (Objects.isNull(user))
            throw HttpClientErrorException(
                HttpStatusCode.valueOf(403)
            )
        else {
            val accessToken = jwtUtil.generateAccessToken(user.id!!)
            val refreshToken = jwtUtil.generateRefreshToken(user.id)

            refreshTokenCommandPort.updateRefreshToken(
                userId = user.id,
                refreshToken = refreshToken,
            )

            return SocialLoginVO.Token(
                accessToken = accessToken,
                refreshToken = refreshToken,
            )
        }

    }
}