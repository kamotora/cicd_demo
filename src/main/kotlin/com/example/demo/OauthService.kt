package com.example.demo

import com.example.demo.domain.User
import com.example.demo.repository.UserRepo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService
import org.springframework.security.oauth2.core.oidc.user.OidcUser
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class OauthService(private val userRepo: UserRepo) : OidcUserService() {

    override fun loadUser(request: OidcUserRequest?): OidcUser {
        val user = super.loadUser(request)
        user.attributes.let { params ->
            val email = params["email"] as String;
            val dbUser = userRepo.findByEmail(email)?.apply {
                this.lastVisit = LocalDateTime.now()
            } ?: User(
                    googleId = params["sub"] as String,
                    gender = params["gender"] as? String,
                    email = email,
                    emailVerified = (params["email_verified"] as? String)?.toBoolean() ?: false,
                    userName = params["name"] as String,
                    firstName = params["given_name"] as? String,
                    lastName = params["family_name"] as? String,
                    lastVisit = LocalDateTime.now()
            )
            userRepo.save(dbUser)
        }
        return user
    }
}