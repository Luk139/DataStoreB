package com.example.persistencedatastore
import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import android.util.Log

// Extension property to create DataStore instance
val Context.dataStore by preferencesDataStore(name = "settings")

val COUNTER_KEY = intPreferencesKey("counter")

suspend fun incrementCounter(context: Context) {
    context.dataStore.edit { preferences ->
        val currentCounterValue = preferences[COUNTER_KEY] ?: 0
        preferences[COUNTER_KEY] = currentCounterValue + 1
    }
}

fun getCounter(context: Context): Flow<Int> {
    return context.dataStore.data
        .map { preferences ->
            preferences[COUNTER_KEY] ?: 0
        }
}

fun getCounterValue(context: Context): Int = runBlocking {
    getCounter(context).first()
}
class DataStore {
}