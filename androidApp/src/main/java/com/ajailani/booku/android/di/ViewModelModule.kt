package com.ajailani.booku.android.di

import com.ajailani.booku.android.ui.viewmodel.HomeViewModel
import com.ajailani.booku.android.ui.viewmodel.VolumeListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { VolumeListViewModel(get(), get()) }
}