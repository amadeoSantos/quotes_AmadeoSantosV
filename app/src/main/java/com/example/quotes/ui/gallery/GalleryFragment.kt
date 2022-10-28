package com.example.quotes.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import androidx.lifecycle.lifecycleScope
import com.example.quotes.databinding.FragmentGalleryBinding
import com.example.quotes.domain.model.QuoteModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class GalleryFragment : Fragment() {

    private val quoteViewModel: GalleryViewModel by viewModels()
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    private var idQuote = 0
    private var numberRowAffected = 0L
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        binding.etQuote.requestFocus()

        sendData()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun showTV(flagQuote: Boolean, flagAuthor: Boolean) {
        binding.etQuote.isEnabled = flagQuote
        binding.etAuthor.isEnabled = flagAuthor
    }
    private fun sendData() {
        with(binding) {
            btnAddQuote.setOnClickListener {
                val (author, quote) = etAuthor.text.toString() to etQuote.text.toString()
                val data = AddQuoteData(idQuote, quote, author)
                when {
                    data.isValid() -> {
                        val quoteModel = QuoteModel(idQuote, quote, author)
                        addQuote(quoteModel)
                    }
                    else -> showMessage("Por favor ingrese todos datos")
                }
            }
        }
    }
    private fun addQuote(quoteModel: QuoteModel) {
        insertQuote(quoteModel)
        showMessage(getStatusMessage())
        clearFields()
    }
    private fun insertQuote(quoteModel: QuoteModel) {
        lifecycleScope.launch {
            quoteViewModel.addQuote(quoteModel)
            numberRowAffected = quoteViewModel.quoteModelAddRowId.value
        }
    }
    private fun showMessage(message: String) = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    private fun getStatusMessage(): String {
        return if(isCorrectInsertData())"Se agrego correctamente" else "Hubo un error al agregar"
    }
    private fun isCorrectInsertData() = numberRowAffected != -1L

    private fun clearFields() {
        if (isCorrectInsertData()){
            binding.etQuote.setText("")
            binding.etAuthor.setText("")
        }
    }
}