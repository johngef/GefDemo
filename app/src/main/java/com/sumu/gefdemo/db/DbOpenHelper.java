package com.sumu.gefdemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gefufeng on 15/12/9.
 */
public class DbOpenHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATEBASE_NAME = "gefufeng.db";
    private static DbOpenHelper instance;

    private static final String USER_TABLE_CREATE = "create table "+
            UserSDao.TABLE_NAME +" ("+
            UserSDao.NAME_ID+" text primary key," +
            UserSDao.NICK+ " text," +
            UserSDao.AVATAR+ " text)";


    private DbOpenHelper(Context context) {
        super(context, DATEBASE_NAME, null, VERSION);
    }
    public static DbOpenHelper getInstance(Context context){
        if (instance == null){
            instance = new DbOpenHelper(context);
        }
        return  instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        if(oldVersion < 2){
//            db.execSQL("ALTER TABLE "+ UserDao.TABLE_NAME +" ADD COLUMN "+
//                    UserDao.COLUMN_NAME_AVATAR + " TEXT ;");
//        }

    }
    public void closeDB(){
        if (instance != null){
            SQLiteDatabase sqLiteDatabase = instance.getWritableDatabase();
            try {
                sqLiteDatabase.close();
            }catch (Exception e){
                e.printStackTrace();
            }

            instance = null;
        }
    }
}
