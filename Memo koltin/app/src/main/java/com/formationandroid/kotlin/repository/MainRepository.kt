package com.formationandroid.kotlin.repository

import com.formationandroid.kotlin.DIApplication
import com.formationandroid.kotlin.notes.dao.NoteDAO
import com.formationandroid.kotlin.notes.dto.NoteDTO
import javax.inject.Inject

class MainRepository {
    //Injections:
    @Inject lateinit var noteDAO: NoteDAO

    fun getLiveDataMemo(): List<NoteDTO> {
        return noteDAO.getListeNotes()
    }

    fun insertNote(memo: NoteDTO) {
        noteDAO.insert(memo)
    }

    fun deleteNote(memo: NoteDTO) {
        noteDAO.delete(memo)
    }

    init {
        DIApplication.getAppComponent()?.inject(this)
    }
}