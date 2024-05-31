package com.example.learningandroiddevkotlin.activity

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learningandroiddevkotlin.R
import com.example.learningandroiddevkotlin.adapter.PostAdapter
import com.example.learningandroiddevkotlin.model.PostModel

class CardViewLearn : AppCompatActivity() {

    lateinit var cardsRecycler: RecyclerView

    private val postList = arrayOf(
        PostModel("K", "Agora", R.drawable.imagem1, "The awesomeness"),
        PostModel("K", "5min ago", R.drawable.imagem2, "The lazyness"),
        PostModel("K", "10min ago", R.drawable.imagem3, "The crazyness"),
        PostModel("K", "1hour ago", R.drawable.imagem4, "The moodless"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_card_view_learn)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainCardActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        cardsRecycler = findViewById(R.id.cardRecyclerView)

        // Defining layout
//        // LinearLayout
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = RecyclerView.HORIZONTAL

        // GridLayout
        val layoutManager = GridLayoutManager(this, 2)

        cardsRecycler.layoutManager = layoutManager

        // Defining adapter
        cardsRecycler.adapter = PostAdapter(postList, this)


    }
}