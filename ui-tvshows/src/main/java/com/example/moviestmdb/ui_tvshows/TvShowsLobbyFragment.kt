package com.example.moviestmdb.ui_tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moviestmdb.core.TmdbImageManager
import com.example.moviestmdb.core.extensions.launchAndRepeatWithViewLifecycle
import com.example.moviestmdb.ui_tvshows.compose.TvShowsScreen
import com.example.moviestmdb.ui_tvshows.databinding.FragmentTvShowsLobbyBinding
import com.example.moviestmdb.ui_tvshows.theme.TmdbTheme
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TvShowsLobbyFragment : Fragment() {

    @Inject
    lateinit var tmdbImageManager: TmdbImageManager
    lateinit var binding: FragmentTvShowsLobbyBinding
    private val viewModel: TvShowsLobbyViewModel by viewModels()

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

        launchAndRepeatWithViewLifecycle {
            viewModel.state.collect { uiState ->

                binding.composeView.setContent {
                    TmdbTheme {
                        TvShowsScreen(
                            tmdbImageUrlProvider = tmdbImageManager.getLatestImageProvider(),
                            state = uiState,
                            onTileClicked = { id ->
                                val bundle = bundleOf("id" to id)
                                //findNavController().navigate(R.id.navigation_tv_show_details, bundle)
                            }
                        )
                    }
                }

                uiState.message?.let { message ->
                    Snackbar.make(requireView(), message.message, Snackbar.LENGTH_LONG)
                        .setAction("Dismiss") {
                            viewModel.clearMessage(message.id)
                        }.show()
                }
            }
        }
    }
}