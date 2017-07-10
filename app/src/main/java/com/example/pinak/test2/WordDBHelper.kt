package com.example.pinak.test2

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.R.attr.name



/**
 * Created by SR4PXM on 7/10/2017.
 * how to access
 * WordDBHelper mDbHelper = new WordDBHelper(getContext());
 */
class WordDBHelper(context: Context) : SQLiteOpenHelper(context, "word.db", null, 1)  {

    //val TAG = javaClass <WordDBHelper>()
     val TABLE = "meaning"

    companion object {
        const val WORD = "word"
        const val  POS = "pos"
        const val IPA = "ipa"
        const val DEFINITION = "definition"
        const val EXAMPLE = "example"
        const val G_EXAMPLE = "g_example"
        const val PATTERN = "pattern"
        const val UK_AUDIO = "ukaudio"
        const val US_AUDIO = "usaudio"
    }

    val DATABASE_CREATE =
            "CREATE TABLE if not exists " + TABLE + " (" +
                    "${WORD} text PRIMARY KEY ," +
                    "${POS} text," +
                    "${IPA} text," +
                    "${DEFINITION} text," +
                    "${EXAMPLE} text," +
                    "${G_EXAMPLE} text," +
                    "${PATTERN} text," +
                    "${UK_AUDIO} text," +
                    "${US_AUDIO} text"+
                    ")"

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
    }


    override fun onCreate(db: SQLiteDatabase) {
        Log.d("WordDBHelper", "Creating" + TABLE)
        db.execSQL(DATABASE_CREATE)
    }

    fun setMeaning(text: String) {
        val values = ContentValues()
        values.put(MeaningContract.Meanings.WORD, text)
        //values.put(TIMESTAMP, System.currentTimeMillis())
        getWritableDatabase().insert(TABLE, null, values);
    }

    fun getMeaning(word : String) : Cursor {

        return getReadableDatabase()
                .query(TABLE,
                arrayOf(WORD, POS,
                        IPA,DEFINITION,EXAMPLE,G_EXAMPLE,
                        PATTERN ),
                " word = ?", arrayOf<String>(word.toUpperCase()), null, null, null, null)

     /*   if (cursor != null)
            cursor.moveToFirst()
        else
            return null

        val gamer = Gamer()
        gamer.id = Integer.parseInt(cursor.getString(0))
        gamer.name = cursor.getString(1)
        gamer.ratings = Integer.parseInt(cursor.getString(2))

        return gamer*/
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        Log.d("WordDBHelper", "Nothing to do")
    }



}