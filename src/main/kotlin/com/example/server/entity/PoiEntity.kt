package com.example.server.entity

import com.baomidou.mybatisplus.annotation.TableName

/**
 * 运行报错请参阅：This primary key of "id" is primitive !不建议如此请使用包装类 in Class: "com.example.server.entity.PoiEntity"
 * https://github.com/baomidou/mybatis-plus/issues/4137
 */
@TableName("poi_table")
data class PoiEntity(
    val id: Int,
    val name: String,
    val description: String,
    val lng: Float,
    val lat: Float,
    val cover: String
)