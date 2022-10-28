package com.example.quote.presentation.ui.fragments.add.delegation

import com.example.quotes.ui.gallery.AddQuoteData

data class QuoteidDelegation(var id: Int? = null) {
    operator fun setValue(thisRef: AddQuoteData, property: Any?, value: Int?) {
        if (value!=null && value in 0..Int.MAX_VALUE) {
            id = value
        }
    }

    operator fun getValue(thisRef: AddQuoteData, property: Any?): Int? = id
}