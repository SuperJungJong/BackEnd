package org.sherlockhomes.homes.common.exception

import org.sherlockhomes.homes.common.responsemodel.ResponseModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CommonExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = [Common401Exception::class])
    fun handler401(ex: AbstractException): ResponseModel<Any> {
        return response(ex)
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = [Common403Exception::class])
    fun handler403(ex: AbstractException): ResponseModel<Any> {
        return response(ex)
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = [Common404Exception::class])
    fun handler404(ex: AbstractException): ResponseModel<Any> {
        return response(ex)
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [RuntimeException::class])
    fun handler400(ex: RuntimeException): ResponseModel<Any> {
        return ResponseModel(
            payload = "잘못된 요청 입니다.",
            code = 400
        )
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = [Exception::class, Common500Exception::class])
    fun handler500(ex: Exception): ResponseModel<Any> {
        return ResponseModel(
            payload = "예상치 못한 에러가 발생했습니다.",
            code = 500,
        )
    }

    fun response(ex: AbstractException) = ResponseModel.of(
        errorMessage = ex.message,
        code = ex.code!!
    )
}