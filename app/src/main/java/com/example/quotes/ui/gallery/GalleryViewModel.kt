package com.example.quotes.ui.gallery


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotes.domain.model.QuoteModel
import com.example.quotes.domain.usecase.AddQuoteUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val addQuoteUseCase: AddQuoteUseCase,
) : ViewModel() {
    private val _quoteModelAdd = MutableStateFlow(0L)
    val quoteModelAddRowId: StateFlow<Long> = _quoteModelAdd

    fun addQuote(quoteModel: QuoteModel) {
        viewModelScope.launch {
            _quoteModelAdd.value = addQuoteUseCase.addQuote(quoteModel)
        }
    }
}