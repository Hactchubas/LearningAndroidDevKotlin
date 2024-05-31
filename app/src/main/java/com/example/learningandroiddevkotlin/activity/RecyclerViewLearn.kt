package com.example.learningandroiddevkotlin.activity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learningandroiddevkotlin.R
import com.example.learningandroiddevkotlin.adapter.MoviesAdapter
import com.example.learningandroiddevkotlin.listener.MoviesRecyclerItemClickListener
import com.example.learningandroiddevkotlin.model.MovieModel

class RecyclerViewLearn : AppCompatActivity() {

    private lateinit var moviesRecyclerView: RecyclerView

    private val moviesList = arrayOf(
        MovieModel("Mulher Maravilha", 2023, "Hérois"),
        MovieModel("Homem Aranha", 2023, "Hérois"),
        MovieModel("Quarteto Fantástico", 2023, "Hérois"),
        MovieModel("Hulk", 2023, "Hérois"),
        MovieModel("Homem-formiga", 2023, "Hérois"),
        MovieModel("Homem de Aço", 2023, "Hérois"),
        MovieModel("Vingadores: Ultimato", 2023, "Hérois"),
        MovieModel("Vingadores: Guerra Infinita", 2023, "Hérois"),
        MovieModel("Homem de Ferro", 2023, "Hérois"),
        MovieModel("Homem de Ferro 2", 2023, "Hérois"),
        MovieModel("Homem de Ferro 3", 2023, "Hérois"),
        MovieModel("Capitão América", 2023, "Hérois"),
        MovieModel("Capitão América: Soldado Invernal", 2023, "Hérois"),
        MovieModel("Kauã", 2023, "Hérois")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view_learn)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainRecyclerActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        moviesRecyclerView = findViewById(R.id.moviesRecyclerView)
        // Configurar adapter
        val movieAdapter = MoviesAdapter(moviesList, this)

        // Configurar RecyclerView
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        moviesRecyclerView.setHasFixedSize(true)
        moviesRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        moviesRecyclerView.layoutManager = layoutManager
        moviesRecyclerView.adapter = movieAdapter

        // Evento de click
        moviesRecyclerView.addOnItemTouchListener(
            MoviesRecyclerItemClickListener(
                applicationContext,
                moviesRecyclerView,
                object : MoviesRecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        Toast.makeText(
                            applicationContext,
                            moviesList[position].title,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) { }
                    override fun onLongItemClick(view: View, position: Int) {
                        Toast.makeText(
                            applicationContext,
                            "${moviesList[position].title} -  ${moviesList[position].category}",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }
            )
        )
    }

}


