package com.example.learningandroiddevkotlin.activity

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learningandroiddevkotlin.R
import com.google.android.material.snackbar.Snackbar

class ListViewLearn : AppCompatActivity() {

    private lateinit var localsList: ListView
    private val items = arrayOf(
        "Fortaleza",
        "São Luis",
        "Salvador",
        "Recife",
        "Paraíba",
        "Tocantins"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view_learn)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainCardActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        localsList = findViewById(R.id.localsListView)

        // Cria o adaptador da lista
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            items
        )

        // Atribui o adaptador para a lista
        localsList.adapter = adapter;

        // Adiciona clique na lista
        localsList.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                Snackbar.make(
                    findViewById(R.id.localsListView),
                    items[position],
                    Snackbar.LENGTH_LONG
                ).show()
            }


    }


}


