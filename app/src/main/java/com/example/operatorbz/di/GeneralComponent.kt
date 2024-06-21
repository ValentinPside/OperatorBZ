package com.example.operatorbz.di

import com.example.operatorbz.presentation.view_model.GeneralViewModel
import dagger.Subcomponent

@Subcomponent
interface GeneralComponent {

    fun viewModel(): GeneralViewModel

}