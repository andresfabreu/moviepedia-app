package com.moviepedia.serverDrivenUi.domain

import com.moviepedia.serverDrivenUi.fixture.ServerDrivenUiFixture
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

private const val PATH = "PATH"

internal class GetServerDrivenUiTest : ServerDrivenUiFixture {

    private val serverDrivenUiRepository: ServerDrivenUiRepository = mockk()

    private val getServerDrivenUi: GetServerDrivenUi = GetServerDrivenUi(
        serverDrivenUiRepository = serverDrivenUiRepository,
    )

    @Test
    fun `should return Failure`() = runTest {
        val failure = RuntimeException("Oops!")

        coEvery {
            serverDrivenUiRepository.getUi(path = PATH)
        } throws failure

        assertEquals(
            actual = getServerDrivenUi(path = PATH),
            expected = Result.failure(exception = failure)
        )
    }

    @Test
    fun `should return ServerDrivenUi`() = runTest {
        coEvery {
            serverDrivenUiRepository.getUi(path = PATH)
        } returns serverDrivenUi()

        assertEquals(
            actual = getServerDrivenUi(path = PATH),
            expected = Result.success(value = serverDrivenUi())
        )
    }
}