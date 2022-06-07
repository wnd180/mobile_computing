package com.example.pdiary

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log

class MyDbHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    object MyEntry: BaseColumns {
        const val TABLE_NAME = "myTable"
        const val c1 = "Dtitle"
        const val c2 = "Dpicture"
        const val c3 = "Dtext"
    }
    val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${MyEntry.TABLE_NAME} (" +
                "${MyEntry.c1} TEXT PRIMARY KEY," +
                "${MyEntry.c2} BLOB," +
                "${MyEntry.c3} TEXT)"

    val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${MyEntry.TABLE_NAME}"

    fun selectAll(): MutableList<MyElement> {
        val readList = mutableListOf<MyElement>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM " + MyEntry.TABLE_NAME + "; ", null)
        Log.d("TAG", "Select All Query: " + "SELECT * FROM " + MyEntry.TABLE_NAME + ";")
        Log.d("TAG", cursor.toString())
        with(cursor) {
            while (moveToNext()) {
                readList.add(MyElement(
                    cursor.getString(0),
                    cursor.getBlob(1),
                    cursor.getString(2))
                )
            }
        }
        cursor.close()
        db.close()
        return readList
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES)
        var db = readableDatabase
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "myDBv2.db"
    }
}