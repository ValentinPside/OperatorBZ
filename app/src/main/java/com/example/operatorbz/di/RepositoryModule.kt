package com.example.operatorbz.di

import com.example.operatorbz.data.RepositoryImpl
import com.example.operatorbz.domain.Repository
import dagger.Module
import dagger.Provides

@Module
object RepositoryModule {

    @Provides
    fun provideRepository(impl: RepositoryImpl): Repository = impl

}