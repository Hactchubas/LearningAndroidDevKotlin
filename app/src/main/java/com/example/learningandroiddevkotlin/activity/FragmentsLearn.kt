package com.example.learningandroiddevkotlin.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.learningandroiddevkotlin.R
import com.example.learningandroiddevkotlin.fragment.ChatsFragment
import com.example.learningandroiddevkotlin.fragment.ContactsFragment

class FragmentsLearn : AppCompatActivity() {

    val contactsFragment = ContactsFragment()
    val chatsFragment = ChatsFragment()
    lateinit var transaction : FragmentTransaction


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fragments_learn)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add<ContactsFragment>(R.id.fragmentsContainer)
                setReorderingAllowed(true)
                addToBackStack(null) // Name can be null
            }
        }

    }


    fun openChatsFragment(view : View){
        supportFragmentManager.commit {
            replace<ChatsFragment>(R.id.fragmentsContainer)
            setReorderingAllowed(true)
        }
    }
    fun openContactsFragment(view : View){
        supportFragmentManager.commit {
            replace<ContactsFragment>(R.id.fragmentsContainer)
            setReorderingAllowed(true)
        }
    }
}