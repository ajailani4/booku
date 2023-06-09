package com.ajailani.booku.data.repository

import com.ajailani.booku.data.mapper.toVolume
import com.ajailani.booku.data.mapper.toVolumeInfo
import com.ajailani.booku.data.remote.data_source.VolumeRemoteDataSource
import com.ajailani.booku.data.remote.dto.response.VolumeDetailResponse
import com.ajailani.booku.data.remote.dto.response.VolumesResponse
import com.ajailani.booku.domain.model.Volume
import com.ajailani.booku.domain.repository.VolumeRepository
import com.ajailani.booku.util.Resource
import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VolumeRepositoryImpl(
    private val volumeRemoteDataSource: VolumeRemoteDataSource
) : VolumeRepository {
    override fun getVolumes(
        query: String,
        maxResults: Int
    ) =
        flow {
            val response = volumeRemoteDataSource.getVolumes(
                query = query,
                maxResults = maxResults
            )

            when (response.status) {
                HttpStatusCode.OK -> {
                    val responseBody = response.body<VolumesResponse>()
                    emit(Resource.Success(responseBody.items.map { volumeDto -> volumeDto.toVolume()}))
                }

                HttpStatusCode.InternalServerError -> {
                    emit(Resource.Error("Server error"))
                }

                else -> emit(Resource.Error("Sorry, something wrong happened"))
            }
        }

    override fun getVolumeDetail(id: String) =
        flow {
            val response = volumeRemoteDataSource.getVolumeDetail(id)

            when (response.status) {
                HttpStatusCode.OK -> {
                    val responseBody = response.body<VolumeDetailResponse>()
                    emit(Resource.Success(responseBody.volumeInfoDto.toVolumeInfo()))
                }

                HttpStatusCode.InternalServerError -> {
                    emit(Resource.Error("Server error"))
                }

                else -> emit(Resource.Error("Sorry, something wrong happened"))
            }
        }
}