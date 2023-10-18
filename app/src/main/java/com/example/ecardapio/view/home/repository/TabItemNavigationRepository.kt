package com.example.ecardapio.view.home.repository

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatListNumberedRtl
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.TableRestaurant
import androidx.compose.material.icons.outlined.FormatListNumberedRtl
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.TableRestaurant
import com.example.ecardapio.view.home.tab_nav.TabItem

class TabItemNavigationRepository {

    fun getTabItem(): List<TabItem> {
        return listOf(
            TabItem(
                title = "Pedidos",
                unselectedIcon = Icons.Outlined.FormatListNumberedRtl,
                selectedIcon = Icons.Filled.FormatListNumberedRtl
            ),
            TabItem(
                title = "Mesas",
                unselectedIcon = Icons.Outlined.TableRestaurant,
                selectedIcon = Icons.Filled.TableRestaurant
            ),
            TabItem(
                title = "Cardápio",
                unselectedIcon = Icons.Outlined.MenuBook,
                selectedIcon = Icons.Filled.MenuBook
            ),
            TabItem(
                title = "Equipe",
                unselectedIcon = Icons.Outlined.Groups,
                selectedIcon = Icons.Filled.Groups
            )
        )
    }

}