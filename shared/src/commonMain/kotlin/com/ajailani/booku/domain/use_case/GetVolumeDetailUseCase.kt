package com.ajailani.booku.domain.use_case

import com.ajailani.booku.domain.repository.VolumeRepository

class GetVolumeDetailUseCase(private val volumeRepository: VolumeRepository) {
    operator fun invoke(id: String) = volumeRepository.getVolumeDetail(id)
}