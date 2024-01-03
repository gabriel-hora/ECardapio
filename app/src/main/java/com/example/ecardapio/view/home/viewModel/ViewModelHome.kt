package com.example.ecardapio.view.home.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ecardapio.view.home.repository.TabItemNavigationRepository
import com.example.ecardapio.view.home.tab_nav.TabItem

class ViewModelHome(
    private val tabItemNavigationRepository: TabItemNavigationRepository
) : ViewModel() {
    fun getListItemsNavigation(): List<TabItem> {
        return tabItemNavigationRepository.getTabItem()
    }
}

@Suppress("UNCHECKED_CAST")
class ViewModelProvider(private var repository: TabItemNavigationRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelHome::class.java)) {
            return ViewModelHome(repository) as T
        }
        throw java.lang.IllegalArgumentException("ViewModel class not found.")
    }
}