package by.bashlikovvv.heroes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.bashlikovvv.heroes.domain.model.Item
import by.bashlikovvv.heroes.domain.model.Progress
import by.bashlikovvv.heroes.domain.repository.IHeroesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesFragmentViewModel @Inject constructor(
    private val heroesRepository: IHeroesRepository
) : ViewModel() {

    private var page: Int = 1

    private var isInProgress = false

    private var _heroes = MutableStateFlow(listOf<Item>())
    val heroes = _heroes.asStateFlow()

    init {
        isInProgress = true
        viewModelScope.launch {
            _heroes.tryEmit(listOf(Progress()))
            _heroes.tryEmit(heroesRepository.getHeroes(page))
        }.invokeOnCompletion { isInProgress = false }
    }

    fun incrementPage() {
        if (page < 149 && !isInProgress) {
            page++
            updateHeroes()
        }
    }

    fun decrementPage() {
//        if (page > 1) {
//            page--
//            updateHeroes()
//        }
    }

    private fun updateHeroes() {
        isInProgress = true
        var idx = 0
        viewModelScope.launch {
            _heroes.update { it + listOf(Progress()) }
            val heroes = heroesRepository.getHeroes(page)
            _heroes.update { it + heroes }
            idx = _heroes.value.size - heroes.size
        }.invokeOnCompletion { _ ->
            _heroes.update { it.subList(0, idx - 1) + it.subList(idx, it.size) }
            isInProgress = false
        }
    }

}