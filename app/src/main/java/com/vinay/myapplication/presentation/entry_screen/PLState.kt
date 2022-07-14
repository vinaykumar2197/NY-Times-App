package com.vinay.myapplication.presentation.entry_screen

import com.vinay.myapplication.domain.model.Results


data class PLState(
    val companies: List<Results> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
)
