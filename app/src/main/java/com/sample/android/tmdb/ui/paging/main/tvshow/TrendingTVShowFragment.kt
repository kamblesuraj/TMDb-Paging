package com.sample.android.tmdb.ui.paging.main.tvshow

import com.sample.android.tmdb.domain.model.SortType
import javax.inject.Inject

class TrendingTVShowFragment @Inject
constructor() : TVShowFragment() {

    override val sortType = SortType.TRENDING
}