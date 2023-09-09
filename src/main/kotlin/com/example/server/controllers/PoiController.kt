package com.example.server.controllers

import com.example.server.entity.PoiEntity
import com.example.server.entity.Result
import com.example.server.mapper.PoiMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/poi")
class PoiController {

    @Autowired
    val poiMapper: PoiMapper? = null

    @GetMapping("/queryPoiData")
    fun queryPoiData(): Result {
        poiMapper?.selectById(1)?.let {
            return Result.success(it)
        }
        return Result.fail()
    }
}