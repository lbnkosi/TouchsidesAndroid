package me.lbnkosi.touchsides.data.service

import me.lbnkosi.touchsides.domain.model.TouchsidesApiResponse
import me.lbnkosi.touchsides.domain.model.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface TouchsidesApiService {

    companion object {

    }

    @POST("api/v1/analyse")
    fun analyseText(
        @Body body: RequestBody
    ): Call<TouchsidesApiResponse>

}