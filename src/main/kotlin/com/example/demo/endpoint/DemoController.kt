package com.example.demo.endpoint

import com.example.demo.domain.User
import com.example.demo.repository.UserRepo
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/demo")
class DemoController(private val userRepo: UserRepo) {

    @GetMapping
    fun getUserInfo(@AuthenticationPrincipal principal: OAuth2User): User =
            userRepo.findByGoogleId(principal.name)

//    private fun toResponse(user: User): UserInfoResponse =
//            UserInfoResponse(
//                    user.id,
//                    user.username,
//                    user.email
//            )
}