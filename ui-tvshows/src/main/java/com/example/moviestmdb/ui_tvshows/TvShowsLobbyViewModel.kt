package com.example.moviestmdb.ui_tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviestmdb.core.util.AppCoroutineDispatchers
import com.example.moviestmdb.core.util.ObservableLoadingCounter
import com.example.moviestmdb.core.util.UiMessageManager
import com.example.moviestmdb.core.util.collectStatus
import com.example.moviestmdb.domain.interactors.*
import com.example.moviestmdb.domain.observers.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TvShowsLobbyViewModel @Inject constructor(

    private val updateTopRatedTvShows: UpdateTopRatedTvShows,
    observeTopRatedTvShows: ObserveTopRatedTvShows,
    private val dispatchers: AppCoroutineDispatchers,
) : ViewModel() {

    private val topRatedLoadingState = ObservableLoadingCounter()
    private val uiMessageManager = UiMessageManager()

    init {
        observeTopRatedTvShows(ObserveTopRatedTvShows.Params(1))
        refresh()
    }

    val state: StateFlow<LobbyViewState> = combine(
        topRatedLoadingState.observable,
        observeTopRatedTvShows.flow,
        uiMessageManager.message,
    ) { topRatedRefreshing, topRatedTvShows, message ->
        LobbyViewState(
            topRatedRefreshing = topRatedRefreshing,
            topRatedTvShows = topRatedTvShows,
            message = message
        )
    }.stateIn(
        scope = viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        LobbyViewState.Empty
    )


   private fun refresh() {
        viewModelScope.launch(dispatchers.io) {
            updateTopRatedTvShows(UpdateTopRatedTvShows.Params(UpdateTopRatedTvShows.Page.REFRESH))
                .collectStatus(
                    topRatedLoadingState,
                    uiMessageManager
                )
        }

    }

    fun clearMessage(id: Long) {
        viewModelScope.launch {
            uiMessageManager.clearMessage(id)
        }
    }
}