package com.example.operatorbz.presentation.ui

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.operatorbz.R
import com.example.operatorbz.app.App
import com.example.operatorbz.databinding.FragmentTextBinding
import com.example.operatorbz.presentation.view_model.TextViewModel
import com.example.operatorbz.utils.Factory

class TextFragment : Fragment() {

    private var _binding: FragmentTextBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<TextViewModel> {
        Factory {
            App.appComponent.generalComponent().viewModel()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTextBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = requireArguments().getString("item_id")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setImage(imgId: String) {
        Glide.with(this)
            .load("https://github.com/iMofas/ios-android-test/raw/master/$imgId")
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .circleCrop()
            .into(binding.imageView)
    }
}