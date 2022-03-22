package com.example.rick_and_morty.ui.fragment.character

import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rick_and_morty.common.base.BaseFragment
import com.example.rick_and_morty.R
import com.example.rick_and_morty.databinding.FragmentCharacterBinding
import com.example.rick_and_morty.ui.adapter.CharacterAdapter
import com.example.rick_and_morty.ui.adapter.paging.LoadStateAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment :
    BaseFragment<CharacterViewModel, FragmentCharacterBinding>(R.layout.fragment_character) {

    override val viewModel: CharacterViewModel by viewModel()
    override val binding by viewBinding(FragmentCharacterBinding::bind)

    private val characterAdapter = CharacterAdapter(
        this::setOnItemClickListener,
        this::setOnItemLongClickListener
    )

    override fun initialize() {
        setupCharacterRecycler()
    }

    private fun setupCharacterRecycler() = with(binding) {
        rvCharacters.layoutManager = LinearLayoutManager(requireActivity())
        rvCharacters.adapter = characterAdapter.withLoadStateFooter(
            LoadStateAdapter {
                characterAdapter.retry()
            })

        characterAdapter.addLoadStateListener { loadStates ->
            rvCharacters.isVisible = loadStates.refresh is LoadState.NotLoading
            progressBar.isVisible = loadStates.refresh is LoadState.Loading
            swipeRefresh.isRefreshing = loadStates.refresh is LoadState.Loading

        }
        swipeRefresh.setOnRefreshListener {
            characterAdapter.refresh()
        }
    }

    override fun setupRequests() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchCharacters().collectLatest {
                this@CharacterFragment.lifecycleScope.launch {
                    characterAdapter.submitData(it)
                }
            }
        }
    }

    private fun setOnItemClickListener(id: Int) {
        findNavController().navigate(
            CharacterFragmentDirections
                .actionCharacterFragmentToCharactersDetailFragment(id)
        )
    }

    private fun setOnItemLongClickListener(image: String) {
    }
}