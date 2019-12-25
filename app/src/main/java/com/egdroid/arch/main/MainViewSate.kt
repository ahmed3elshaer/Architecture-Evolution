package com.egdroid.arch.main

data class MainViewSate(
    val isLoading: Boolean = false,
    val onAnswer: String = "",
    val onError: String = ""
)