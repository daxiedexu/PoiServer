package com.example.server.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.server.entity.PoiEntity
import com.example.server.mapper.PoiMapper
import com.example.server.service.IPoiService
import org.springframework.stereotype.Service

@Service
class PoiServiceImpl : ServiceImpl<PoiMapper,PoiEntity>(), IPoiService {

}