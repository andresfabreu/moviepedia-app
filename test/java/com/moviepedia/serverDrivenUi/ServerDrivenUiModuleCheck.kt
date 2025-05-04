package com.moviepedia.serverDrivenUi

import com.moviepedia.network.ApiClient
import com.moviepedia.serverDrivenUi.data.remote.ServerDrivenUiApi
import com.moviepedia.serverDrivenUi.di.serverDrivenUiModule
import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.KoinTest
import org.koin.test.verify.definition
import org.koin.test.verify.injectedParameters
import org.koin.test.verify.verify

internal class ServerDrivenUiModuleCheck : KoinTest {

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkKoinModule() {
        serverDrivenUiModule.verify(
            injections = injectedParameters(
                definition<ServerDrivenUiApi>(ApiClient::class)
            )
        )
    }
}