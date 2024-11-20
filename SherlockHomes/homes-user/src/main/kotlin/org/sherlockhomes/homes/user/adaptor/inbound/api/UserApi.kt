package org.sherlockhomes.homes.user.adaptor.inbound.api

import io.swagger.v3.oas.annotations.Operation
import org.sherlockhomes.homes.common.responsemodel.ResponseModel
import org.sherlockhomes.homes.user.adaptor.inbound.api.dto.UserResponseDTO
import org.sherlockhomes.homes.user.adaptor.inbound.api.mapper.toResponse
import org.sherlockhomes.homes.user.application.port.inbound.UserCommand
import org.sherlockhomes.homes.user.application.port.inbound.UserQuery
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserApi(
    private val userQuery: UserQuery,
    private val userCommand: UserCommand,
) {

    @Operation(summary = "단일 유저 조회", description = "토큰으로 유저 조회(확인)")
    @GetMapping
    fun getUser(
        @RequestHeader("X-UserId") userId: Long,
    ): ResponseModel<UserResponseDTO.Response> = ResponseModel.of(
        userQuery.getUser(userId).toResponse()
    )

//    @Operation(summary = "단일 유저 조회", description = "토큰으로 유저 조회(확인)")
//    @GetMapping("/test")
//    fun getUserTest(
//        @RequestParam("AccessToken") userId: Long,
//    ): UserResponseDTO.Response {
//        userQuery.getUser(userId)
//
//    }


}