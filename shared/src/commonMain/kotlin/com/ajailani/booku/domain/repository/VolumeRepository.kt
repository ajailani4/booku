package com.ajailani.booku.domain.repository

import com.ajailani.booku.domain.model.Volume
import com.ajailani.booku.util.Resource
import kotlinx.coroutines.flow.Flow

interface VolumeRepository {
    fun getVolumes(query: String): Flow<Resource<List<Volume>>>
}