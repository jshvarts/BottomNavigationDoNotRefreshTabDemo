package io.valueof.donotrefreshtab.presentation

import androidx.lifecycle.ViewModel
import io.valueof.donotrefreshtab.model.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private const val ITEM_COUNT = 100

class Tab0ViewModel : ViewModel() {
    private val _itemList = MutableStateFlow<List<Item>>(emptyList())
    val itemList: StateFlow<List<Item>> = _itemList

    init {
        generateItemList()
    }

    private fun generateItemList() {
        val items = mutableListOf<Item>()

        (1..ITEM_COUNT).forEachIndexed { index, _ ->
            items.add(
                Item(
                    id = index,
                    title = "tab 0 item $index",
                    description = "description for item $index"
                )
            )
        }
        _itemList.value = items
    }
}