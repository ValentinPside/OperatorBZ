package com.example.operatorbz.di

import com.example.operatorbz.presentation.GeneralViewModel
import dagger.Subcomponent

@Subcomponent
interface GeneralComponent {

    fun viewModel(): GeneralViewModel

}