package me.lbnkosi.touchsides.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.lbnkosi.touchsides.data.service.TouchsidesApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val BASE_URL_NAME = "baseUrl"
    private const val BASE_URL = "http://touchsidesapi-env.eba-gpmyk94m.eu-north-1.elasticbeanstalk.com/"

    @Provides
    @Named(BASE_URL_NAME)
    fun provideBaseUrl(): String {
        return BASE_URL
    }

    @Singleton
    @Provides
    fun providesTouchsidesApi(@Named("TOUCHSIDES_RETROFIT") retrofit: Retrofit): TouchsidesApiService {
        return retrofit.create(TouchsidesApiService::class.java)
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }

    @Singleton
    @Provides
    @Named("TOUCHSIDES_RETROFIT")
    fun providesRetrofit(okHttpClient: OkHttpClient, @Named(BASE_URL_NAME) baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}