package com.example.server.controllers

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.example.server.entity.PoiEntity
import com.example.server.entity.Result
import com.example.server.service.impl.PoiServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/poi")
class PoiController {

    @Autowired
    val poiServiceImpl: PoiServiceImpl = PoiServiceImpl() // Autowired注解会在运行时自动赋值，这里赋值只是为了方便调用，而不是使用?运算符

    @GetMapping("/queryPoiData")
    fun queryPoiData(@RequestParam(defaultValue = "1") pageNum: Long, @RequestParam(defaultValue = "20") pageSize: Long): Result {
        val filterPage = Page<PoiEntity>()
        filterPage.let {
            it.current = pageNum
            it.size = pageSize
        }
        poiServiceImpl.page(filterPage).let {
            return Result.success(it)
        }
    }

    @PostMapping("/addPoiData")
    fun addPoiData(@RequestBody body: PoiEntity): Result {
        poiServiceImpl.save(body).let {
            return if (it){
                Result.success("添加成功")
            } else {
                Result.fail()
            }
        }
    }

    @PutMapping("/updatePoiData")
    fun updatePoiData(@RequestParam id: Int,@RequestBody body: PoiEntity): Result {
        body.id = id
        poiServiceImpl.updateById(body).let {
            return if (it){
                Result.success("修改成功")
            } else {
                Result.fail()
            }
        }
    }

    @DeleteMapping("/deletePoiData")
    fun deletePoiData(@RequestParam id: Int): Result {
        poiServiceImpl.removeById(id).let {
            return if (it){
                Result.success("删除成功")
            } else {
                Result.fail()
            }
        }
    }
}