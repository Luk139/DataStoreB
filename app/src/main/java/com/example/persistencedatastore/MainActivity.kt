package com.example.persistencedatastore

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        lifecycleScope.launch {
            // Aktuellen Zählerwert abrufen und loggen
            val initialCounter = getCounterValue(applicationContext)
            Log.d("DataStoreDemo", "Initialer Zählerwert: $initialCounter")

            // Zähler erhöhen
            incrementCounter(applicationContext)
            Log.d("DataStoreDemo", "Zähler wurde erhöht.")

            // Neuen Zählerwert abrufen und loggen
            val newCounter = getCounterValue(applicationContext)
            Log.d("DataStoreDemo", "Neuer Zählerwert: $newCounter")
        }
    }
}