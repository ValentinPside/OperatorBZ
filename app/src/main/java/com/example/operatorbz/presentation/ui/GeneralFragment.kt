package com.example.operatorbz.presentation.ui

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.operatorbz.R
import com.example.operatorbz.app.App
import com.example.operatorbz.databinding.FragmentGeneralBinding
import com.example.operatorbz.presentation.view_model.GeneralViewModel
import com.example.operatorbz.utils.Factory

class GeneralFragment : Fragment() {

    private var _binding: FragmentGeneralBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<GeneralViewModel> {
        Factory {
            App.appComponent.generalComponent().viewModel()
        }
    }

    private val DOZ_TEXT = resources.getString(R.string.bisText)
    private val FSD_TEXT = resources.getString(R.string.fsdText)
    private val PH_TEXT = resources.getString(R.string.phText)
    private val WASH_TEXT = resources.getString(R.string.washText)
    private val CONSERVATION_TEXT = resources.getString(R.string.conservationText)
    private val OSV_FILTERS_TEXT = resources.getString(R.string.osvFiltersText)
    private val CONTACTORS_TEXT = resources.getString(R.string.contactorsText)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGeneralBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}