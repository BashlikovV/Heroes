package by.bashlikovvv.heroes.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.bashlikovvv.heroes.R
import by.bashlikovvv.heroes.databinding.FragmentHeroesBinding
import by.bashlikovvv.heroes.presentation.adapter.HeroesListAdapter
import by.bashlikovvv.heroes.presentation.viewmodel.HeroesFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HeroesFragment : Fragment() {

    private val viewModel: HeroesFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHeroesBinding.inflate(inflater, container, false)

        val adapter = HeroesListAdapter(
            onClickListener = {
                findNavController().navigate(
                    R.id.action_heroesFragment_to_heroDetailsFragment,
                    args = bundleOf(KEY_DETAIL to it)
                )
            },
            onListEndedCallback = { viewModel.incrementPage() },
            onListStartedCallback = { viewModel.decrementPage() }
        )
        binding.heroesRecyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.heroes.collectLatest {
                adapter.submitList(it)
            }
        }

        return binding.root
    }
}