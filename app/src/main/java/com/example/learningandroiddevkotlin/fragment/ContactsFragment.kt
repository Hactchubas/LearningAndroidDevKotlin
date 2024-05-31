package com.example.learningandroiddevkotlin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.learningandroiddevkotlin.R

class ContactsFragment : Fragment(R.layout.fragment_contacts) {

    private lateinit var text : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_contacts, container, false)

        text  = view.findViewById<TextView>(R.id.contactsTextView)
        text.text = "Contacts List"

        return view
    }
}