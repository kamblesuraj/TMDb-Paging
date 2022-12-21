package com.sample.android.tmdb.paging.tvshow

import android.content.Context
import com.sample.android.tmdb.data.asTVShowDomainModel
import com.sample.android.tmdb.domain.TVShow
import com.sample.android.tmdb.network.TVShowApi
import com.sample.android.tmdb.paging.BasePageKeyedDataSource
import com.sample.android.tmdb.ui.paging.main.SortType
import io.reactivex.Observable
import java.util.concurrent.Executor

class TVShowsPageKeyedDataSource(
    private val api: TVShowApi,
    private val sortType: SortType,
    retryExecutor: Executor,
    context: Context)
    : BasePageKeyedDataSource<TVShow>(retryExecutor, context) {

    override fun fetchItems(page: Int): Observable<List<TVShow>> = when (sortType) {
        SortType.MOST_POPULAR -> api.popularTVSeries(page).map { it.items.asTVShowDomainModel() }
        SortType.HIGHEST_RATED -> api.topRatedTVSeries(page).map { it.items.asTVShowDomainModel() }
        SortType.UPCOMING -> api.onTheAirTVSeries(page).map { it.items.asTVShowDomainModel() }
        SortType.TRENDING -> api.trendingTVSeries(page).map { it.items.asTVShowDomainModel() }
        SortType.NOW_PLAYING -> api.airingTodayTVSeries(page).map { it.items.asTVShowDomainModel() }
    }
}