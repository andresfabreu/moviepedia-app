package com.moviepedia.serverDrivenUi.data

import com.moviepedia.serverDrivenUi.data.mappers.ServerDrivenUiMapper
import com.moviepedia.serverDrivenUi.data.remote.ServerDrivenUiApi
import com.moviepedia.serverDrivenUi.domain.ServerDrivenUiRepository
import com.moviepedia.serverDrivenUi.fixture.ServerDrivenUiFixture
import com.moviepedia.serverDrivenUi.fixture.ServerDrivenUiResponseFixture
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

private const val PATH = "PATH"

internal class ServerDrivenUiRepositoryTest : ServerDrivenUiResponseFixture, ServerDrivenUiFixture {
    private val serverDrivenUiApi: ServerDrivenUiApi = mockk()
    private val serverDrivenUiMapper: ServerDrivenUiMapper = mockk()

    private val repository: ServerDrivenUiRepository = ServerDrivenUiRepositoryImpl(
        serverDrivenUiApi = serverDrivenUiApi,
        serverDrivenUiMapper = serverDrivenUiMapper,
    )

    @Test
    fun `should succeed`() = runTest {
        every {
            serverDrivenUiMapper.transform(serverDrivenUiResponse())
        } returns serverDrivenUi()

        coEvery {
            serverDrivenUiApi.getUi(path = PATH)
        } returns serverDrivenUiResponse()

        assertEquals(
            actual = repository.getUi(path = PATH),
            expected = serverDrivenUi(),
        )
    }

    @Test
    fun `should failure`() = runTest {
        coEvery {
            serverDrivenUiApi.getUi(path = PATH)
        } throws RuntimeException("Oops!")

        assertFailsWith(RuntimeException::class, "Oops!") {
            repository.getUi(path = PATH)
        }
    }
}