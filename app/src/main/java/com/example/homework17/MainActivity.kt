package com.example.homework17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val jsonFile = assets.open("all.json")
        val bufferedReader = BufferedReader(InputStreamReader(jsonFile))
        val stringBuilder = StringBuilder()
        bufferedReader.useLines {
                lines -> lines.forEach { stringBuilder.append(it) }
        }
        val jsonString = stringBuilder.toString()
        val data = Gson().fromJson(jsonString, Heroes::class.java)
        val items = data.heroes
        val myAdapter = RecyclerViewAdapter(items as MutableList<Hero>) {
            Toast.makeText(this, "${it} clicked", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
