package com.formationandroid.kotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.formationandroid.kotlin.notes.adapter.NoteAdapter
import com.formationandroid.kotlin.notes.helpers.ItemTouchHelperCallback
import com.formationandroid.kotlin.notes.dto.NoteDTO
import com.formationandroid.kotlin.repository.MainRepository
import com.formationandroid.kotlin.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var noteAdapter: NoteAdapter
    private var listNotes: MutableList<NoteDTO>? = ArrayList()
    private lateinit var itemTouchHelper: ItemTouchHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.init(MainRepository())
        listNotes = mainViewModel.getLiveDataMemo()?.toMutableList()

        noteAdapter = NoteAdapter(listNotes!!, this)

        myrecyclerview.setHasFixedSize(true)
        myrecyclerview.layoutManager = LinearLayoutManager(this)
        itemTouchHelper = ItemTouchHelper(ItemTouchHelperCallback(noteAdapter))
        itemTouchHelper.attachToRecyclerView(myrecyclerview)
        myrecyclerview.adapter = noteAdapter
    }

    fun insertMemo(v: View) {
        if (insertnote.text.toString().isNotEmpty()) {
            val n = NoteDTO(insertnote!!.text.toString())
            listNotes?.add(n)
            mainViewModel.insertNote(n)
            myrecyclerview.adapter?.notifyDataSetChanged()
        }
        insertnote.text.clear()
    }
}