package me.lbnkosi.touchsides.domain.usecase

import kotlinx.coroutines.flow.Flow
import me.lbnkosi.touchsides.data.network.RemoteErrorEmitter
import me.lbnkosi.touchsides.domain.model.Resource
import me.lbnkosi.touchsides.domain.model.TouchsidesApiResponse
import me.lbnkosi.touchsides.domain.repository.ITouchsidesRepository
import javax.inject.Inject

class TouchsideApiUseCase @Inject constructor(private val repository: ITouchsidesRepository) {

    suspend fun analyseText(remoteErrorEmitter: RemoteErrorEmitter, txtLink: String): Flow<Resource<TouchsidesApiResponse?>?>? = repository.analyseText(remoteErrorEmitter, txtLink)

}