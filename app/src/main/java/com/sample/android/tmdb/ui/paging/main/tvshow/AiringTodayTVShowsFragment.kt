package com.sample.android.tmdb.ui.paging.main.tvshow

import com.sample.android.tmdb.domain.model.SortType
import javax.inject.Inject

class AiringTodayTVShowsFragment @Inject
constructor() : TVShowFragment() {

    override val sortType = SortType.NOW_PLAYING
}