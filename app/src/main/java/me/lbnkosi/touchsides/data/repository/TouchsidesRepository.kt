package me.lbnkosi.touchsides.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.lbnkosi.touchsides.data.network.RemoteErrorEmitter
import me.lbnkosi.touchsides.data.source.remote.TouchsidesDataSource
import me.lbnkosi.touchsides.domain.model.Resource
import me.lbnkosi.touchsides.domain.model.TouchsidesApiResponse
import me.lbnkosi.touchsides.domain.repository.ITouchsidesRepository
import javax.inject.Inject

class TouchsidesRepository @Inject constructor(private val dataSource: TouchsidesDataSource): ITouchsidesRepository {

    override suspend fun analyseText(remoteErrorEmitter: RemoteErrorEmitter, txtLink: String): Flow<Resource<TouchsidesApiResponse?>?>? {
        return dataSource.analyseText(remoteErrorEmitter, txtLink)?.map { resource ->
            resource
        }
    }

}