package com.example.pdiary

import android.content.ContentValues
import android.content.Context
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: MemoActivity, name: String, version:Int) :
    SQLiteOpenHelper(context, name, null, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        val create = "create table memo (" +
                "no integer przimary key," +
                "image blob" +
                ")"
        db?.execSQL(create)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun insertMemo(memo : Memo){
        val values = ContentValues()
        values.put("image", memo.image)

        val wd = writableDatabase
        wd.insert("memo", null, values)
        wd.close()
    }

    fun selectMemo() : MutableList<Memo>{
        val list = mutableListOf<Memo>()
        val select = "select * from memo order by datetime desc"
        val rd = readableDatabase
        val cursor = rd.rawQuery(select, null)
        DatabaseUtils.dumpCursor(cursor)

        while (cursor.moveToNext()){
            val no = cursor.getLong(cursor.getColumnIndex("no"))
            val image: ByteArray? = cursor.getBlob(cursor.getColumnIndex("image")) ?: null

            list.add(Memo(no,image))
        }

        cursor.close()
        rd.close()

        return list
    }

    fun updateMemo(memo: Memo){
        val values = ContentValues()
        values.put("image", memo.image)

        val wd = writableDatabase
        wd.update("memo", values,"no = ${memo.no}", null)
        wd.close()
    }

    fun deleteMemo(memo:Memo){
        val delete = "delte from memo where no = ${memo.no}"

        val db = writableDatabase
        db.execSQL(delete)
        db.close()
    }
}