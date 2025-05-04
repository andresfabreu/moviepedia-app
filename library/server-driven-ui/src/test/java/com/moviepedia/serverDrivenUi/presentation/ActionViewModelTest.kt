package com.moviepedia.serverDrivenUi.presentation

import app.cash.turbine.test
import com.moviepedia.serverDrivenUi.domain.model.common.ActionType
import com.moviepedia.serverDrivenUi.fixture.ActionFixture
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

internal class ActionViewModelTest : ActionFixture {

    private val viewModel: ActionViewModel = ActionViewModel()

    @Test
    fun `should handle back action`() = runTest {
        viewModel.event.test {
            viewModel.handleAction(
                action = action()
            )

            assertEquals(
                actual = awaitItem(),
                expected = ActionViewModel.Event.NavigateBack,
            )
        }
    }

    @Test
    fun `should handle deeplink action`() = runTest {
        val deeplink = "moviepedia://moviepedia.com/details/1"

        viewModel.event.test {
            viewModel.handleAction(
                action = action().copy(
                    value = deeplink,
                    type = ActionType.DEEPLINK,
                )
            )

            assertEquals(
                actual = awaitItem(),
                expected = ActionViewModel.Event.OpenUrl(
                    url = deeplink
                ),
            )
        }
    }
}