package com.example.di_homework.di

import com.example.di_homework.BuildConfig
import com.example.di_homework.data.api.UsersService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

const val OK_HTTP_TIMEOUT = 40L

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideItemListApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    val moshiBuilder = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val moshiConverterFactory = MoshiConverterFactory.create(moshiBuilder)

    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(moshiConverterFactory)
        .client(okHttpClient)
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().apply {
        connectTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
        readTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
        addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
    }.build()
}

fun provideItemListApi(retrofit: Retrofit): UsersService = retrofit.create(
    UsersService::class.java
)