package com.ajailani.booku.domain.use_case

import com.ajailani.booku.domain.repository.VolumeRepository

class GetVolumesUseCase(private val volumeRepository: VolumeRepository) {
    operator fun invoke(
        query: String,
        maxResults: Int
    ) = volumeRepository.getVolumes(
        query = query,
        maxResults = maxResults
    )
}