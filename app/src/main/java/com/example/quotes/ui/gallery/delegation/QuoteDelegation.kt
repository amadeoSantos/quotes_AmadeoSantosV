package com.example.quote.presentation.ui.fragments.add.delegation

import com.example.quotes.ui.gallery.AddQuoteData


data class QuoteDelegation(var quote: String? = null) {
    operator fun setValue(thisRef: AddQuoteData, property: Any?, value: String?) {
        if (value != null && value.isNotEmpty()) {
            quote = value
        }
    }

    operator fun getValue(thisRef: AddQuoteData, property: Any?): String? = quote
}