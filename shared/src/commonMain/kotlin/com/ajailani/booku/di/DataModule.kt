package com.ajailani.booku.di

import com.ajailani.booku.data.remote.api_service.VolumeService
import com.ajailani.booku.data.remote.data_source.VolumeRemoteDataSource
import com.ajailani.booku.data.repository.VolumeRepositoryImpl
import com.ajailani.booku.domain.repository.VolumeRepository
import org.koin.dsl.module

val dataModule = module {
    single { VolumeService(get()) }
    single { VolumeRemoteDataSource(get()) }
    single<VolumeRepository> { VolumeRepositoryImpl(get()) }
}