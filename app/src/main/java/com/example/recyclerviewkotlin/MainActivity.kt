package com.example.recyclerviewkotlin

import ContactsAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var contacts: ArrayList<Contact>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        super.onCreate(savedInstanceState)
        // ...
        // Lookup the recyclerview in activity layout
        val rvContacts = findViewById<View>(R.id.rvContacts) as RecyclerView
        // Initialize contacts
        contacts = Contact.createContactsList(20)
        // Create adapter passing in the sample user data
        val adapter = ContactsAdapter(contacts)
        // Attach the adapter to the recyclerview to populate items
        rvContacts.adapter = adapter
        // Set layout manager to position the items
        rvContacts.layoutManager = LinearLayoutManager(this)
        // That's all!
    }
}


class Contact(val name: String, val isOnline: Boolean){
    companion object{
        private var lastContactId = 0
        fun createContactsList(numContacts: Int) : ArrayList<Contact>{
            val contacts = ArrayList<Contact>()
            for (i in 1..numContacts){
                contacts.add(Contact("PERSON " + ++lastContactId, i <=numContacts/2))
            }
            return contacts
        }
    }
}