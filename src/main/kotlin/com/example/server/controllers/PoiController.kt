package com.example.server.controllers

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.example.server.entity.PoiEntity
import com.example.server.entity.Result
import com.example.server.service.impl.PoiServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/poi")
class PoiController {

    @Autowired
    val poiServiceImpl: PoiServiceImpl? = null

    @GetMapping("/queryPoiData")
    fun queryPoiData(@RequestParam(defaultValue = "1") pageNum: Long, @RequestParam(defaultValue = "20") pageSize: Long): Result {
        val filterPage = Page<PoiEntity>()
        filterPage.let {
            it.current = pageNum
            it.size = pageSize
        }
        poiServiceImpl?.page(filterPage)?.let {
            return Result.success(it)
        }
        return Result.fail()
    }
}