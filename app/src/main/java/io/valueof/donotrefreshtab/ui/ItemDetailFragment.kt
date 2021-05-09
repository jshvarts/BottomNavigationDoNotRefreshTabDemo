package io.valueof.donotrefreshtab.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import io.valueof.donotrefreshtab.R
import io.valueof.donotrefreshtab.databinding.FragmentItemDetailBinding
import timber.log.Timber

class ItemDetailFragment : Fragment(R.layout.fragment_item_detail) {
    private val binding by viewBinding(FragmentItemDetailBinding::bind)
    private val args by navArgs<ItemDetailFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("fragment onCreate")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("fragment onAttach")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.d("fragment onDetach")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("fragment onDestroyView")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.itemTitle.text = "tab 0 item ${args.itemId}"
    }
}