package io.valueof.donotrefreshtab.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import io.valueof.donotrefreshtab.R
import io.valueof.donotrefreshtab.databinding.Fragment0Binding
import io.valueof.donotrefreshtab.presentation.Tab1ViewModel
import kotlinx.coroutines.flow.collect
import timber.log.Timber

class Fragment1 : Fragment(R.layout.fragment_1) {
    private val binding by viewBinding(Fragment0Binding::bind)

    private val viewModel: Tab1ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("1: fragment create")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemAdapter = ItemAdapter()

        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = itemAdapter
        }

        lifecycleScope.launchWhenResumed {
            viewModel.itemList.collect { itemList ->
                Timber.d("1: fragment load data ${itemList.size}")
                itemAdapter.submitList(itemList)
            }
        }
    }
}