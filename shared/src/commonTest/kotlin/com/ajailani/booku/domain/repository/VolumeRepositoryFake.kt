package com.ajailani.booku.domain.repository

import com.ajailani.booku.domain.model.Volume
import com.ajailani.booku.domain.model.VolumeInfo
import com.ajailani.booku.util.DummyData
import com.ajailani.booku.util.Resource
import com.ajailani.booku.util.ResourceType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class VolumeRepositoryFake : VolumeRepository {
    private lateinit var resourceType: ResourceType

    fun setResourceType(type: ResourceType) {
        resourceType = type
    }

    override fun getVolumes(query: String, maxResults: Int): Flow<Resource<List<Volume>>> =
        when (resourceType) {
            ResourceType.Success -> flowOf(Resource.Success(DummyData.volumes))

            ResourceType.Error -> flowOf(Resource.Error())
        }

    override fun getVolumeDetail(id: String): Flow<Resource<VolumeInfo>> =
        when (resourceType) {
            ResourceType.Success -> flowOf(Resource.Success(DummyData.volumeInfo))

            ResourceType.Error -> flowOf(Resource.Error())
        }
}