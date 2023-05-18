package com.ajailani.booku.data.remote.data_source

import com.ajailani.booku.data.remote.api_service.VolumeService

class VolumeRemoteDataSource(private val volumeService: VolumeService) {
    suspend fun getVolumes(
        query: String,
        maxResults: Int
    ) = volumeService.getVolumes(
        query = query,
        maxResults = maxResults
    )

    suspend fun getVolumeDetail(id: String) = volumeService.getVolumeDetail(id)
}