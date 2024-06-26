package com.example.operatorbz.presentation.ui

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.operatorbz.R
import com.example.operatorbz.app.App
import com.example.operatorbz.databinding.FragmentGeneralBinding
import com.example.operatorbz.presentation.ItemAdapter
import com.example.operatorbz.presentation.view_model.GeneralViewModel
import com.example.operatorbz.utils.Factory
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.launch

class GeneralFragment : Fragment() {

    private var _binding: FragmentGeneralBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<GeneralViewModel> {
        Factory {
            App.appComponent.generalComponent().viewModel()
        }
    }

    private lateinit var adapter: ItemAdapter

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
        setupRecycler()
        viewModel.setFirstList()
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.observeUi().collect { state ->
                    adapter.submitList(state.items)
                }
            }
        }

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    when(tab.position){
                        0 -> viewModel.setFirstList()
                        1 -> viewModel.setSecondList()
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecycler() {
        adapter = ItemAdapter {
            findNavController().navigate(
                R.id.action_generalFragment_to_textFragment,
                bundleOf("item_id" to it)
            )
        }
        binding.itemsRecycler.adapter = adapter
        binding.itemsRecycler.layoutManager = LinearLayoutManager(requireContext())
    }

}