package com.example.quotes.domain.usecase

import com.example.quotes.domain.QuoteRepository
import com.example.quotes.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(private val QuoteRepository: QuoteRepository) {
    suspend fun  getQuote(quoteId: Int): Flow<QuoteModel> = QuoteRepository.getQuote(quoteId)
}