package com.moviepedia.serverDrivenUi.data.mappers

import com.moviepedia.serverDrivenUi.fixture.AppBarComponentFixture
import com.moviepedia.serverDrivenUi.fixture.AppBarComponentResponseFixture
import org.junit.Test
import kotlin.test.assertEquals

internal class AppBarComponentMapperTest : AppBarComponentResponseFixture, AppBarComponentFixture {

    private val mapper = AppBarComponentMapper()

    @Test
    fun `should transform AppBarComponentResponse to AppBarComponent`() {
        assertEquals(
            actual = mapper.transform(
                response = appBarComponentResponse(),
            ),
            expected = appBarComponent(),
        )
    }
}