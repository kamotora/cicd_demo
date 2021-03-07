package com.example.demo.domain

import org.hibernate.annotations.DynamicUpdate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@DynamicUpdate
@Table(name = "usr")
data class User(
        @Id
        val id: String = UUID.randomUUID().toString(),
        val googleId: String,
        val firstName: String?,
        val lastName: String?,
        val userName: String,
        val emailVerified: Boolean,
        val gender: String?,
        val email: String,
        var lastVisit: LocalDateTime
)
