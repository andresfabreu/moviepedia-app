package com.moviepedia.serverDrivenUi.data.mappers

import com.moviepedia.serverDrivenUi.data.remote.response.component.ComponentResponse
import com.moviepedia.serverDrivenUi.domain.model.component.Component

internal interface ComponentMapper<in T : ComponentResponse, out R : Component> {
    fun transform(response: T): R
}