package com.example.demo.endpoint

import com.example.demo.UserInfoResponse
import com.example.demo.domain.User
import com.example.demo.repository.UserRepo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/demo")
class DemoController(private val userRepo: UserRepo) {

    @GetMapping
    fun getUserInfo(@AuthenticationPrincipal principal: OAuth2User): User =
            userRepo.findByGoogleId(principal.name)

    @GetMapping("/all")
    fun getAllUsers(): List<UserInfoResponse> =
            userRepo.findAll().map { toResponse(it) }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removeUserById(@PathVariable id: String) {
        userRepo.deleteById(id)
    }


    private fun toResponse(user: User): UserInfoResponse =
            UserInfoResponse(
                    user.id,
                    user.userName,
                    user.email
            )
}