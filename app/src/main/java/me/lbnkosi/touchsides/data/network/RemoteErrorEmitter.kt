package me.lbnkosi.touchsides.data.network

import me.lbnkosi.touchsides.domain.model.ErrorType

interface RemoteErrorEmitter {
    fun onError(msg: String)
    fun onError(msg: String?, errorType: ErrorType)
}