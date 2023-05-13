package com.ajailani.booku.util

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.Android

actual val ktorEngine: HttpClientEngine = Android.create()