package com.sample.android.tmdb.paging.search.tvshow

import android.content.Context
import com.sample.android.tmdb.data.asTVShowDomainModel
import com.sample.android.tmdb.domain.TVShow
import com.sample.android.tmdb.network.TVShowApi
import com.sample.android.tmdb.paging.BasePageKeyedDataSource
import io.reactivex.Observable
import java.util.concurrent.Executor

class SearchTVShowPageKeyedDataSource(
        private val api: TVShowApi,
        private val query: String,
        retryExecutor: Executor,
        context: Context
) : BasePageKeyedDataSource<TVShow>(retryExecutor, context) {

    override fun fetchItems(page: Int): Observable<List<TVShow>> =
        api.searchItems(page, query).map { it.items.asTVShowDomainModel() }
}