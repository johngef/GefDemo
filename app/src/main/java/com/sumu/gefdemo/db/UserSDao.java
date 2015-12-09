package com.sumu.gefdemo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sumu.gefdemo.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gefufeng on 15/12/9.
 */
public class UserSDao {
    public static final String TABLE_NAME = "users";
    public static final String NAME_ID = "username";
    public static final String AVATAR = "avatar";
    public static final String NICK = "nick";

    private DbOpenHelper dbOpenHelper;

    public UserSDao(Context context){
        dbOpenHelper = DbOpenHelper.getInstance(context);
    }
    public void saveList(List<User> userList){
        SQLiteDatabase sqLiteDatabase = dbOpenHelper.getWritableDatabase();
        if (sqLiteDatabase.isOpen()){
            sqLiteDatabase.delete(TABLE_NAME,null,null);
            for (User user : userList){
                ContentValues values = new ContentValues();
                if (user.getNameId() != null){
                    values.put(NAME_ID,user.getNameId());
                }
                if (user.getAvatar() != null){
                    values.put(AVATAR,user.getAvatar());
                }
                if (user.getNick() != null){
                    values.put(NICK,user.getNick());
                }
                sqLiteDatabase.replace(TABLE_NAME,null,values);

            }
        }

    }
    public void save(User user){
        SQLiteDatabase sqLiteDatabase = dbOpenHelper.getWritableDatabase();
        if (sqLiteDatabase.isOpen()){
            ContentValues values = new ContentValues();
            if (user.getNameId() != null){
                values.put(NAME_ID,user.getNameId());
            }
            if (user.getAvatar() != null){
                values.put(AVATAR,user.getAvatar());
            }
            if (user.getNick() != null){
                values.put(NICK,user.getNick());
            }
            sqLiteDatabase.replace(TABLE_NAME,null,values);
        }
    }

    public void delete(String nameId){
        SQLiteDatabase sqLiteDatabase = dbOpenHelper.getWritableDatabase();
        if (sqLiteDatabase.isOpen()){
            sqLiteDatabase.delete(TABLE_NAME,NAME_ID + " = ?",new String[]{nameId});
        }

    }
    public Map<String,User> getList(){
        SQLiteDatabase sqLiteDatabase = dbOpenHelper.getWritableDatabase();
        Map<String,User> map = new HashMap<>();

        if (sqLiteDatabase.isOpen()){
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME /* + " desc" */, null);
            while (cursor.moveToNext()){
                String nameId = cursor.getString(cursor.getColumnIndex(NAME_ID));
                String nick = cursor.getString(cursor.getColumnIndex(NICK));
                String avatar = cursor.getString(cursor.getColumnIndex(AVATAR));
                User user = new User();
                user.setAvatar(avatar);
                user.setNameId(nameId);
                user.setNick(nick);
                map.put(nameId,user);
            }
            cursor.close();
        }
        return map;
    }



}
