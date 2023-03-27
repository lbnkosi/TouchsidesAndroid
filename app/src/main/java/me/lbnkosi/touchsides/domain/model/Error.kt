package me.lbnkosi.touchsides.domain.model

data class Error(
    var error: String? = "",
    var errorCode: Int? = 0,
    var message: String? = ""
)
