package com.moviepedia.serverDrivenUi.data.mappers

import com.moviepedia.serverDrivenUi.data.remote.response.component.AppBarComponentResponse
import com.moviepedia.serverDrivenUi.data.remote.response.common.toDomain
import com.moviepedia.serverDrivenUi.domain.model.component.AppBarComponent

internal class AppBarComponentMapper : ComponentMapper<AppBarComponentResponse, AppBarComponent> {
    override fun transform(response: AppBarComponentResponse): AppBarComponent = with(response) {
        AppBarComponent(
            type = type,
            title = title.toDomain(),
            action = action?.toDomain(),
        )
    }
}