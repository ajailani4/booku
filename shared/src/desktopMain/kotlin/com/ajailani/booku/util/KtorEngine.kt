package com.ajailani.booku.util

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.cio.CIO

actual val ktorEngine: HttpClientEngine = CIO.create()