package com.example.cs394demoproject.database

import androidx.room.TypeConverter
import com.example.cs394demoproject.model.Source

class Convertors {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}