package com.example.moviestmdb.ui_tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moviestmdb.core.TmdbImageManager
import com.example.moviestmdb.ui_tvshows.databinding.FragmentTvShowsLobbyBinding
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

    lateinit var binding: FragmentTvShowsLobbyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvShowsLobbyBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.composeView.setContent {
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