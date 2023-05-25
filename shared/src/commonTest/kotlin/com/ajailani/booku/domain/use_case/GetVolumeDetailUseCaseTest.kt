package com.ajailani.booku.domain.use_case

import com.ajailani.booku.domain.model.VolumeInfo
import com.ajailani.booku.domain.repository.VolumeRepositoryFake
import com.ajailani.booku.util.DummyData
import com.ajailani.booku.util.Resource
import com.ajailani.booku.util.ResourceType
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.DefaultAsserter
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetVolumeDetailUseCaseTest {
    private lateinit var volumeRepositoryFake: VolumeRepositoryFake
    private lateinit var getVolumeDetailUseCase: GetVolumeDetailUseCase

    @BeforeTest
    fun setUp() {
        volumeRepositoryFake = VolumeRepositoryFake()
        getVolumeDetailUseCase = GetVolumeDetailUseCase(volumeRepositoryFake)
    }

    @Test
    fun `Get volume detail should return success resource`() =
        runTest(UnconfinedTestDispatcher()) {
            volumeRepositoryFake.setResourceType(ResourceType.Success)

            val actualResource = getVolumeDetailUseCase("1").first()

            DefaultAsserter.assertEquals(
                "Resource should be success",
                Resource.Success(DummyData.volumeInfo),
                actualResource
            )
        }

    @Test
    fun `Get volume detail should return error resource`() =
        runTest(UnconfinedTestDispatcher()) {
            volumeRepositoryFake.setResourceType(ResourceType.Error)

            val actualResource = getVolumeDetailUseCase("1").first()

            DefaultAsserter.assertEquals(
                "Resource should be error",
                Resource.Error<VolumeInfo>(),
                actualResource
            )
        }
}