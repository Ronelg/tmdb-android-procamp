package com.example.moviestmdb.ui_movies.popular2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.filter
import com.example.moviestmdb.Genere
import com.example.moviestmdb.MovieWithGenere
import com.example.moviestmdb.core.util.AppCoroutineDispatchers
import com.example.moviestmdb.domain.observers.ObserveGeneres
import com.example.moviestmdb.domain.observers.ObservePopularMovies
import com.example.moviestmdb.ui_movies.popular.vo.FilterChip
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel2 @Inject constructor(
    private val observeGeneres: ObserveGeneres,
    observePopularMovies: ObservePopularMovies,
    private val dispatchers: AppCoroutineDispatchers,
) : ViewModel() {

    private val _sortBy = MutableStateFlow<Int>(0)
    val sortBy = _sortBy.asStateFlow()

    private val _selectedChips = MutableStateFlow<Set<Int>>(emptySet())
    val selectedChips = _selectedChips.asStateFlow()

    private val generesAndFilters = combine(
        selectedChips,
        observeGeneres.flow
    ) { selectedIds, generes ->
        Pair(selectedIds, generes)
    }

    val movieWithGenereList: Flow<List<MovieWithGenere>> =
        sortBy.flatMapLatest { sortType ->
            generesAndFilters
                .flatMapLatest { pair ->
                    observePopularMovies.flow
                        .map { movies ->
                            if (pair.first.isEmpty()) {
                                movies
                            } else {
                                movies.filter { movie ->
                                    movie.genreList.any { x -> x in pair.first }
                                }
                            }
                        }
                        .map { movies ->
                            movies.map {
                                MovieWithGenere(
                                    movie = it,
                                    generes = pair.second
                                )
                            }
                        }.map { movies ->
                            when (sortType) {
                                0 -> movies
                                1 -> movies.sortedBy { it.movie.voteCount }
                                2 -> movies.sortedByDescending { it.movie.voteCount }
                                else -> movies
                            }
                        }

                }
        }

    val filterChips = observeGeneres.flow
        .map { generes ->
            generes.mapTo(mutableListOf()) { genere ->
                FilterChip(
                    id = genere.id,
                    text = genere.name,
                    isSelected = false
                )
            }
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList<FilterChip>()
        )

    init {
//        pagingInteractor(ObservePagedPopularMovies.Params(PAGING_CONFIG))
        observePopularMovies(ObservePopularMovies.Params(1))
        observeGeneres(Unit)

    }

    fun toggleFilter(id: Int, enabled: Boolean) {
        val set = _selectedChips.value.toMutableSet()
        val changed = if (enabled) {
            set.add(id)
        } else {
            set.remove(id)
        }

        if (changed) {
            _selectedChips.tryEmit(set)
        }
    }

    fun sortBy() {
        val value = (sortBy.value + 1) % 3
        _sortBy.tryEmit(value)
        Timber.i("sortType: $value")
    }
}