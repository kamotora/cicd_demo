package com.example.demo.endpoint

import com.example.demo.repository.UserRepo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/public")
class PublicController(private val userRepo: UserRepo) {

    @GetMapping
    fun getCountUsers(): Long = userRepo.count()
}