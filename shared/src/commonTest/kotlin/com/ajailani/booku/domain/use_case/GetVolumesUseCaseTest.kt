package com.ajailani.booku.domain.use_case

import com.ajailani.booku.domain.model.Volume
import com.ajailani.booku.domain.repository.VolumeRepositoryFake
import com.ajailani.booku.util.DummyData
import com.ajailani.booku.util.Resource
import com.ajailani.booku.util.ResourceType
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.BeforeTest
import kotlin.test.DefaultAsserter.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class GetVolumesUseCaseTest {
    private lateinit var volumeRepositoryFake: VolumeRepositoryFake
    private lateinit var getVolumesUseCase: GetVolumesUseCase

    @BeforeTest
    fun setUp() {
        volumeRepositoryFake = VolumeRepositoryFake()
        getVolumesUseCase = GetVolumesUseCase(volumeRepositoryFake)
    }

    @Test
    fun `Get volumes should return success resource`() =
        runTest(UnconfinedTestDispatcher()) {
            volumeRepositoryFake.setResourceType(ResourceType.Success)

            val actualResource = getVolumesUseCase(
                query = "subject:fiction",
                maxResults = 15
            ).first()

            assertEquals(
                "Resource should be success",
                Resource.Success(DummyData.volumes),
                actualResource
            )
        }

    @Test
    fun `Get volumes should return error resource`() =
        runTest(UnconfinedTestDispatcher()) {
            volumeRepositoryFake.setResourceType(ResourceType.Error)

            val actualResource = getVolumesUseCase(
                query = "subject:fiction",
                maxResults = 15
            ).first()

            assertEquals(
                "Resource should be error",
                Resource.Error<List<Volume>>(),
                actualResource
            )
        }
}
