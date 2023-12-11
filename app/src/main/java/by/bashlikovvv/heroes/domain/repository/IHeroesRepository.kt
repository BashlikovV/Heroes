package by.bashlikovvv.heroes.domain.repository

import by.bashlikovvv.heroes.domain.model.Hero

interface IHeroesRepository {

    suspend fun getHeroes(page: Int): List<Hero>

}