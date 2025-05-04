package com.moviepedia.serverDrivenUi.data.mappers

import com.moviepedia.serverDrivenUi.fixture.CardComponentFixture
import com.moviepedia.serverDrivenUi.fixture.CardComponentResponseFixture
import org.junit.Test
import kotlin.test.assertEquals

internal class CardComponentMapperTest : CardComponentResponseFixture, CardComponentFixture {

    private val mapper = CardComponentMapper()

    @Test
    fun `should transform CardComponentResponse to CardComponent`() {
        assertEquals(
            actual = mapper.transform(
                response = cardComponentResponse(),
            ),
            expected = cardComponent(),
        )
    }
}