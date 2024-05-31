package com.example.learningandroiddevkotlin.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learningandroiddevkotlin.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    fun listViewLearn(view : View){
        val intent = Intent(this, ListViewLearn::class.java)
        startActivity(intent)
    }

    fun recyclerViewLearn(view : View){
        val intent = Intent(this, RecyclerViewLearn::class.java)
        startActivity(intent)
    }

    fun cardViewLearn(view : View){
        val intent = Intent(this, CardViewLearn::class.java)
        startActivity(intent)
    }

    fun fragmentsLearn(view: View){
        val intent = Intent(this, FragmentsLearn::class.java)
        startActivity(intent)
    }
}