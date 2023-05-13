package com.ajailani.booku.di

import org.koin.dsl.module

val appModule = module {
    includes(
        networkModule,
        dataModule,
        domainModule
    )
}