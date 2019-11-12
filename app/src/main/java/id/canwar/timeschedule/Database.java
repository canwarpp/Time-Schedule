package id.canwar.timeschedule;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class Database extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    // Referensi
    // https://www.sqlite.org/lang_datefunc.html
    // https://developer.android.com/training/data-storage/sqlite
    private static final String DATABASE_NAME = "db_schedule.db";
    private static final int DATABASE_VERSION = 1;

    public Database(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /* Inner class that defines the table contents */
    private static class FeedEntry implements BaseColumns{
        private static final String TABLE_NAME = "time_schedule";
        private static final String TITTLE = "tittle";
        private static final String DAY = "day_of_week";
        private static final String PLACE = "place";
        private static final String START_TIME = "start_time";
        private static final String END_TIME = "end_time";
        private static final String COLOR = "color";
        private static final String INFO = "info";
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " ("
            + FeedEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FeedEntry.TITTLE + " TEXT,"
            + FeedEntry.DAY + " INT,"
            + FeedEntry.PLACE + " TEXT,"
            + FeedEntry.START_TIME + " TEXT,"
            + FeedEntry.END_TIME + " TEXT,"
            + FeedEntry.COLOR + " TEXT,"
            + FeedEntry.INFO + " TEXT"
            + ")";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
