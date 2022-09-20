package com.example.roomdatabase

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity

class PhoneActivity : AppCompatActivity() {
    lateinit var cpListView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)
        cpListView = findViewById(R.id.cpListview)

        val uriCalls:Uri= Uri.parse("content://call_log/calls")
        val cursor: Cursor? = contentResolver.query(uriCalls, null, null, null, null)

        var from = arrayOf("number","duration")
        var to = intArrayOf(android.R.id.text1,android.R.id.text2)

        var adapter = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_2
            ,cursor,from,to)

        cpListView.adapter = adapter

    }


}