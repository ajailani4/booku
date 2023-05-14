package com.ajailani.booku.di

import com.ajailani.booku.util.Constants
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    includes(
        networkModule,
        dataModule,
        domainModule
    )

    single(named(Constants.CoroutineDispatcher.DEFAULT_DISPATCHER)) { Dispatchers.Default }
}