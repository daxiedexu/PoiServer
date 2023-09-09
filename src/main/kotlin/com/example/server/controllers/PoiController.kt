package com.example.server.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/poi")
class PoiController {
    @GetMapping("/list")
    fun list(): String{
        return "this is list"
    }
}