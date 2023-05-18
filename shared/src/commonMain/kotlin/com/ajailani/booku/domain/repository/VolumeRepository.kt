package com.ajailani.booku.domain.repository

import com.ajailani.booku.domain.model.Volume
import com.ajailani.booku.domain.model.VolumeInfo
import com.ajailani.booku.util.Resource
import kotlinx.coroutines.flow.Flow

interface VolumeRepository {
    fun getVolumes(
        query: String,
        maxResults: Int
    ): Flow<Resource<List<Volume>>>

    fun getVolumeDetail(id: String): Flow<Resource<VolumeInfo>>
}