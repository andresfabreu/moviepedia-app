package com.moviepedia.serverDrivenUi.data.mappers

import com.moviepedia.serverDrivenUi.fixture.ParagraphComponentFixture
import com.moviepedia.serverDrivenUi.fixture.ParagraphComponentResponseFixture
import org.junit.Test
import kotlin.test.assertEquals

internal class ParagraphComponentMapperTest
    : ParagraphComponentResponseFixture, ParagraphComponentFixture {

    private val mapper = ParagraphComponentMapper()

    @Test
    fun `should transform ParagraphComponentResponse to ParagraphComponent`() {
        assertEquals(
            actual = mapper.transform(
                response = paragraphComponentResponse(),
            ),
            expected = paragraphComponent(),
        )
    }
}