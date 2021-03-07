package com.example.demo.domain

import org.springframework.security.core.GrantedAuthority

enum class Authority : GrantedAuthority {
    USER;

    override fun getAuthority(): String = this.name
}