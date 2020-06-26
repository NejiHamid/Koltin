package com.formationandroid.kotlin.viewmodel

import androidx.lifecycle.ViewModel
import com.formationandroid.kotlin.notes.dto.NoteDTO
import com.formationandroid.kotlin.repository.MainRepository

class MainViewModel : ViewModel() {
    // Repository :
    private lateinit var mainRepository: MainRepository

    // Initialisation :
    fun init(mainRepository: MainRepository) {
        // initialisation et premier chargement :
        this.mainRepository = mainRepository
    }

    fun getLiveDataMemo(): List<NoteDTO>? {
        return mainRepository.getLiveDataMemo()
    }

    fun insertNote(note: NoteDTO) {
        mainRepository.insertNote(note)
    }
}