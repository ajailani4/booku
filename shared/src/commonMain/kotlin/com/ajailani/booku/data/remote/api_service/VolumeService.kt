package com.ajailani.booku.data.remote.api_service

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class VolumeService(private val httpClient: HttpClient) {
    suspend fun getVolumes(
        query: String,
        maxResults: Int
    ) = httpClient.get("volumes") {
        url {
            parameters.append("q", query)
            parameters.append("maxResults", maxResults.toString())
        }
    }

    suspend fun getVolumeDetail(id: String) = httpClient.get("volumes/$id")
}