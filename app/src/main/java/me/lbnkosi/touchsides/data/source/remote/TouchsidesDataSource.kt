package me.lbnkosi.touchsides.data.source.remote

import kotlinx.coroutines.flow.Flow
import me.lbnkosi.touchsides.data.network.BaseRemoteRepository
import me.lbnkosi.touchsides.data.network.RemoteErrorEmitter
import me.lbnkosi.touchsides.data.service.TouchsidesApiService
import me.lbnkosi.touchsides.domain.model.RequestBody
import me.lbnkosi.touchsides.domain.model.Resource
import me.lbnkosi.touchsides.domain.model.TouchsidesApiResponse
import retrofit2.await
import javax.inject.Inject

class TouchsidesDataSource @Inject constructor(private val apiService: TouchsidesApiService) : BaseRemoteRepository() {

    suspend fun analyseText(remoteErrorEmitter: RemoteErrorEmitter, txtLink: String): Flow<Resource<TouchsidesApiResponse?>?>? {
        return safeApiCallNoCache(remoteErrorEmitter) { apiService.analyseText(RequestBody(link = txtLink)).await() }
    }

}