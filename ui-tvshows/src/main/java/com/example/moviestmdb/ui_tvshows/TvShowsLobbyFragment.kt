package com.example.moviestmdb.ui_tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestmdb.core.TmdbImageManager
import com.example.moviestmdb.core.extensions.launchAndRepeatWithViewLifecycle
import com.example.moviestmdb.core_ui.util.SpaceItemDecoration
import com.example.moviestmdb.ui_tvshows.databinding.FragmentTvshowsLobbyBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TvShowsLobbyFragment : Fragment() {

    private val viewModel: TvShowsLobbyViewModel by viewModels()

//    lateinit var popularMoviesAdapter: PopularMoviesCarrouselAdapter
//    lateinit var topRatedMoviesAdapter: PopularMoviesCarrouselAdapter
//    lateinit var upcomingMoviesAdapter: PopularMoviesCarrouselAdapter
//    lateinit var nowPlayingMoviesAdapter: PopularMoviesCarrouselAdapter

    @Inject
    lateinit var tmdbImageManager: TmdbImageManager


    lateinit var binding: FragmentTvshowsLobbyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(inflater.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            setContent {
//                val popularShowsState by viewModel.popularShowsState.collectAsState()
//                val topRatedShowsState by viewModel.topRatedShowsState.collectAsState()
//                val latestShowsState by viewModel.onTheAirShowsState.collectAsState()
//
//                TvShowsScreen(
//                    popularShowsState = popularShowsState,
//                    latestShowsState = latestShowsState,
//                    topRatedShowsState = topRatedShowsState,
//                    onTileClicked = { id ->
//                        val bundle = bundleOf("id" to id)
//                        findNavController().navigate(R.id.navigation_tv_show_details, bundle)
//                    }
//                )
            }
        }
    }
}