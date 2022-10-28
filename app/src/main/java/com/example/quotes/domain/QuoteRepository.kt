package com.example.quotes.domain

import com.example.quotes.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    // suspend fun getQuotes(): Flow<QuoteResponse?>
    suspend fun getLatestId(): Int
    suspend fun getQuoteRandom(): Flow<QuoteModel>
    suspend fun getQuote(quoteId:Int): Flow<QuoteModel>
    suspend fun addQuote(quoteModel: QuoteModel):Long
    suspend fun deleteQuote(int: Int):Int
    suspend fun getAllQuote():Flow<List<QuoteModel>>
}