package me.lbnkosi.touchsides.domain.repository

import kotlinx.coroutines.flow.Flow
import me.lbnkosi.touchsides.data.network.RemoteErrorEmitter
import me.lbnkosi.touchsides.domain.model.Resource
import me.lbnkosi.touchsides.domain.model.TouchsidesApiResponse

interface ITouchsidesRepository {

    suspend fun analyseText(remoteErrorEmitter: RemoteErrorEmitter, txtLink: String): Flow<Resource<TouchsidesApiResponse?>?>?

}