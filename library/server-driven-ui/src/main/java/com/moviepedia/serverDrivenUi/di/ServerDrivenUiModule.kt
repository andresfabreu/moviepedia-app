package com.moviepedia.serverDrivenUi.di

import com.moviepedia.serverDrivenUi.data.ServerDrivenUiRepositoryImpl
import com.moviepedia.serverDrivenUi.data.mappers.AppBarComponentMapper
import com.moviepedia.serverDrivenUi.data.mappers.CardComponentMapper
import com.moviepedia.serverDrivenUi.data.mappers.ComponentMapper
import com.moviepedia.serverDrivenUi.data.mappers.ComponentMapperAggregator
import com.moviepedia.serverDrivenUi.data.mappers.GridComponentMapper
import com.moviepedia.serverDrivenUi.data.mappers.ParagraphComponentMapper
import com.moviepedia.serverDrivenUi.data.mappers.ServerDrivenUiMapper
import com.moviepedia.serverDrivenUi.data.remote.ServerDrivenUiApi
import com.moviepedia.serverDrivenUi.data.remote.response.component.APP_BAR_COMPONENT_TYPE
import com.moviepedia.serverDrivenUi.data.remote.response.component.CARD_COMPONENT_TYPE
import com.moviepedia.serverDrivenUi.data.remote.response.component.GRID_COMPONENT_TYPE
import com.moviepedia.serverDrivenUi.data.remote.response.component.PARAGRAPH_COMPONENT_TYPE
import com.moviepedia.serverDrivenUi.domain.GetServerDrivenUi
import com.moviepedia.serverDrivenUi.domain.ServerDrivenUiRepository
import com.moviepedia.serverDrivenUi.presentation.ActionViewModel
import com.moviepedia.serverDrivenUi.presentation.ServerDrivenUiViewModel
import com.moviepedia.serverDrivenUi.presentation.renderer.AppBarComponentRenderer
import com.moviepedia.serverDrivenUi.presentation.renderer.CardComponentRenderer
import com.moviepedia.serverDrivenUi.presentation.renderer.ComponentRenderer
import com.moviepedia.serverDrivenUi.presentation.renderer.ComponentRendererAggregator
import com.moviepedia.serverDrivenUi.presentation.renderer.GridComponentRenderer
import com.moviepedia.serverDrivenUi.presentation.renderer.ParagraphComponentRenderer
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

private const val COMPONENT_MAPPERS = "ComponentMappers"
private const val COMPONENT_RENDERERS = "ComponentRenderers"

val serverDrivenUiModule = module {
    // region data
    factoryOf(::ServerDrivenUiApi)
    factoryOf(::ServerDrivenUiRepositoryImpl).bind<ServerDrivenUiRepository>()
    single<Map<String, ComponentMapper<*, *>>>(named(COMPONENT_MAPPERS)) {
        mapOf(
            PARAGRAPH_COMPONENT_TYPE to ParagraphComponentMapper(),
            APP_BAR_COMPONENT_TYPE to AppBarComponentMapper(),
            CARD_COMPONENT_TYPE to CardComponentMapper(),
            GRID_COMPONENT_TYPE to GridComponentMapper(componentMapperAggregator = inject()),
        )
    }
    factory { ComponentMapperAggregator(componentMappers = get(named(COMPONENT_MAPPERS))) }
    // endregion

    factoryOf(::ServerDrivenUiMapper)

    // region domain
    factoryOf(::GetServerDrivenUi)
    // endregion

    // region presentation
    single<Map<String, ComponentRenderer<*>>>(named(COMPONENT_RENDERERS)) {
        mapOf(
            PARAGRAPH_COMPONENT_TYPE to ParagraphComponentRenderer(),
            APP_BAR_COMPONENT_TYPE to AppBarComponentRenderer(),
            CARD_COMPONENT_TYPE to CardComponentRenderer(),
            GRID_COMPONENT_TYPE to GridComponentRenderer(),
        )
    }
    factory { ComponentRendererAggregator(componentRenderers = get(named(COMPONENT_RENDERERS))) }
    viewModelOf(::ServerDrivenUiViewModel)
    viewModelOf(::ActionViewModel)
    // endregion
}