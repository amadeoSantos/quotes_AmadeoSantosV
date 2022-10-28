package com.example.quotes.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotes.domain.model.QuoteModel
import com.example.quotes.domain.usecase.GetQuoteRandomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SlideshowViewModel
@Inject constructor(private val getQuoteRandomUseCase: GetQuoteRandomUseCase
): ViewModel() {

        private val quoteModelRandomMutableStateFlow = MutableStateFlow(QuoteModel(0,"",""))
        val quoteModel: StateFlow<QuoteModel> = quoteModelRandomMutableStateFlow


        fun randomQuote() {
            viewModelScope.launch {
                quoteModelRandomMutableStateFlow.value = getQuoteRandomUseCase.getQuoteRandom().first()
                //_quoteModel.value = GetQuoteUseCase(quoteDAO).getQuote(1).first()
            }
        }


    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }
    val text: LiveData<String> = _text
}