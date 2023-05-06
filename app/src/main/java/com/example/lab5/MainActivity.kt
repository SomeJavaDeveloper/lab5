package com.example.lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val rentalAdapter = RentalAdapter()
    private val rentalList = mutableListOf<RentalOfProperty>()

    private val areas = listOf(RentalOfProperty("Терновка", 1000),
        RentalOfProperty("Арбеково", 1500),
        RentalOfProperty("Московская", 2000),
        RentalOfProperty("Железнодорожный", 200),
        RentalOfProperty("Ленинский", 1200),
        RentalOfProperty("Первомайский", 1400),
        RentalOfProperty("ГПЗ", 800))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<RecyclerView>(R.id.list_id).apply {
            adapter = rentalAdapter
        }
        rentalAdapter.apply {
            onItemClick = ::intGetter
            items = rentalList
        }
        findViewById<Button>(R.id.button).setOnClickListener {
            rentalList.add(areas[abs( Random.nextInt() % areas.size)])
            rentalAdapter.items = rentalList
        }
    }

    fun intGetter(index: Int) {
        Toast.makeText(this, rentalList[index].address, Toast.LENGTH_SHORT).show()
    }
}