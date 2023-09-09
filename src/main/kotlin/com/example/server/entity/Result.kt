package com.example.server.entity

data class Result(
    var code: Int,
    var data: Any? = null,
    var message: String
){
    companion object{
        fun success(data: Any): Result {
            return Result(
                code = 200,
                data = data,
                message = "success"
            )
        }

        /**
         * 这里请求失败返回数据code我就使用2020状态码代替了，待优化
         * 时间：2023年09月09日19:57:31
         */
        fun fail(): Result {
            return Result(
                code = 2020,
                data = null,
                message = "fail"
            )
        }
    }
}