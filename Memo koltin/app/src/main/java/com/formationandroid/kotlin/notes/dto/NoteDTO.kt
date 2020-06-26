package com.formationandroid.kotlin.notes.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
class NoteDTO (
    @PrimaryKey(autoGenerate = true)
    var noteId: Long = 0L,
    var intitule: String = "") {

    constructor(intitule: String) : this() {
        this.intitule = intitule
    }
}