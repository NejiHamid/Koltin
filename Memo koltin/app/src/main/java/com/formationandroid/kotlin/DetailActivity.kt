package com.formationandroid.kotlin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.formationandroid.kotlin.R
import com.formationandroid.kotlin.fragment.DetailFragment
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val intituleMemo = intent.getStringExtra("detail")
        val fragment = DetailFragment()
        val bundle = Bundle()
        bundle.putString(DetailFragment.EXTRA_PARAM, intituleMemo)
        fragment.arguments = bundle
        val fragmentManager = supportFragmentManager
        val fragmentTransaction =
            fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.large_detail, fragment, "exemple2")
        fragmentTransaction.commit()
    }

    fun afficheNote(v: View) {
        Toast.makeText(this, v.txt.text, Toast.LENGTH_SHORT).show()
    }
}