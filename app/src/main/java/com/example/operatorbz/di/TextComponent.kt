package com.example.operatorbz.di

import com.example.operatorbz.presentation.view_model.TextViewModel
import dagger.Subcomponent

@Subcomponent
interface TextComponent {

    fun viewModel(): TextViewModel

}