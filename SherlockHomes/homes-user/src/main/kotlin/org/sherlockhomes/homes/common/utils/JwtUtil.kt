package org.sherlockhomes.homes.common.utils

import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpStatusCodeException
import java.lang.Exception
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtUtil {
    @Value("\${jwt.SECRET}")
    lateinit var SECRET: String

    @Value("\${jwt.ACCESS_EXP_MS}")
    lateinit var ACCESS_EXP_MS: String

    @Value("\${jwt.REFRESH_EXP_MS}")
    lateinit var REFRESH_EXP_MS: String

    fun generateAccessToken(userId: Long): String =
        Jwts.builder()
            .claim("userId", userId)
            .subject("accessToken")
            .issuedAt(Date())
            .expiration(Date(Date().time + ACCESS_EXP_MS.toLong()))
            .signWith(getSigningKey())
            .compact()

    fun generateRefreshToken(userId: Long): String =
        Jwts.builder()
            .claim("userId", userId)
            .subject("refreshToken")
            .issuedAt(Date())
            .expiration(Date(Date().time + ACCESS_EXP_MS.toLong()))
            .signWith(getSigningKey())
            .compact()

    fun getUserId(accessToken: String?): Long {
        val payload: Claims

        try {
            payload = Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(accessToken)
                .payload
        } catch (e: ExpiredJwtException) {
            throw HttpClientErrorException(HttpStatusCode.valueOf(403)) //TODO: Custom Exeption Handler 추가
        }

        return (payload["userId"] as Int).toLong()
    }

    fun checkToken(accessToken: String?) {
        try {
            Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(accessToken)
                .payload
        } catch (e: ExpiredJwtException) {
            throw HttpClientErrorException(HttpStatusCode.valueOf(403)) //TODO: Custom Exeption Handler 추가
        }
    }

    private fun getSigningKey(): SecretKey {
        return Keys.hmacShaKeyFor(SECRET.toByteArray())
    }
}