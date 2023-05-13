package com.ajailani.booku.di

import com.ajailani.booku.domain.use_case.GetVolumesUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetVolumesUseCase(get()) }
}