package com.formationandroid.kotlin.notes.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.formationandroid.kotlin.notes.dto.NoteDTO

@Database(entities = [NoteDTO::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun noteDAO(): NoteDAO
}