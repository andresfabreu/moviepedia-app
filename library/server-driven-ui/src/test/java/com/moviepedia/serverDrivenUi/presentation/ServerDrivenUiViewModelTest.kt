package com.moviepedia.serverDrivenUi.presentation

import app.cash.turbine.test
import com.moviepedia.serverDrivenUi.domain.GetServerDrivenUi
import com.moviepedia.serverDrivenUi.fixture.ServerDrivenUiFixture
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

private const val PATH = "PATH"

internal class ServerDrivenUiViewModelTest : ServerDrivenUiFixture {

    private val getServerDrivenUi: GetServerDrivenUi = mockk()

    private val viewModel: ServerDrivenUiViewModel by lazy {
        ServerDrivenUiViewModel(
            path = PATH,
            getServerDrivenUi = getServerDrivenUi,
        )
    }

    @Test
    fun `should load initial content`() = runTest {
        coEvery {
            getServerDrivenUi.invoke(path = PATH)
        } coAnswers {
            delay(200)
            Result.success(value = serverDrivenUi())
        }

        viewModel.state.test {
            assertEquals(
                actual = awaitItem(),
                expected = ServerDrivenUiViewModel.ViewState(
                    isLoading = true
                )
            )

            assertEquals(
                actual = awaitItem(),
                expected = ServerDrivenUiViewModel.ViewState(
                    isLoading = false,
                    serverDrivenUi = serverDrivenUi(),
                )
            )
        }
    }

    @Test
    fun `should fail load initial content`() = runTest {
        val failure = RuntimeException("Oops!")

        coEvery {
            getServerDrivenUi.invoke(path = PATH)
        } coAnswers {
            delay(200)
            Result.failure(exception = failure)
        }

        viewModel.state.test {
            assertEquals(
                actual = awaitItem(),
                expected = ServerDrivenUiViewModel.ViewState(
                    isLoading = true
                )
            )

            assertEquals(
                actual = awaitItem(),
                expected = ServerDrivenUiViewModel.ViewState(
                    isLoading = false,
                    serverDrivenUi = null,
                    error = failure,
                )
            )
        }
    }
}