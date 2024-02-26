package com.example.phrasebook.data.di

import com.example.phrasebook.data.repository.CategoryRepositoryImpl
import com.example.phrasebook.data.repository.PhraseDetailRepositoryImpl
import com.example.phrasebook.data.repository.PhraseRepositoryImpl
import com.example.phrasebook.domain.repository.CategoryRepository
import com.example.phrasebook.domain.repository.PhraseDetailRepository
import com.example.phrasebook.domain.repository.PhraseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCategoryRepository(repo: CategoryRepositoryImpl): CategoryRepository

    @Binds
    abstract fun bindPhraseRepository(repo: PhraseRepositoryImpl): PhraseRepository

    @Binds
    abstract fun bindPhraseDetailRepository(repo: PhraseDetailRepositoryImpl): PhraseDetailRepository

}