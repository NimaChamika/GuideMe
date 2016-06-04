package com.nima.guideme;

/**
 * Created by user on 5/24/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseAdapter {

    DistrictDatabse ddatabase;


    public DatabaseAdapter(Context context){
        ddatabase=new DistrictDatabse(context);
    }
    public long insertData(String name, String password){
        SQLiteDatabase db=ddatabase.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DistrictDatabse.PROVINCE_NAME,name);
        contentValues.put(DistrictDatabse.DISTRICT_NAME,password);
        long id= db.insert(DistrictDatabse.TABLE_NAME,null,contentValues);
        return id;
    }

    public String getData(){
        SQLiteDatabase db=ddatabase.getWritableDatabase();
        String[] columns={DistrictDatabse.UID,DistrictDatabse.PROVINCE_NAME,DistrictDatabse.DISTRICT_NAME};
        Cursor cursor=db.query(DistrictDatabse.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer=new StringBuffer();
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String pname=cursor.getString(1);
            String dname=cursor.getString(2);
            buffer.append(id+" "+pname+" "+dname+"\n");
        }
        return buffer.toString();
    }


    public ArrayList<String> getDataToList(){

        ArrayList<String> arList = new ArrayList();
        SQLiteDatabase db=ddatabase.getWritableDatabase();
        String[] columns={DistrictDatabse.UID,DistrictDatabse.PROVINCE_NAME,DistrictDatabse.DISTRICT_NAME};
        Cursor cursor=db.query(DistrictDatabse.TABLE_NAME,columns,null,null,null,null,null);



        if (cursor != null ) {
            if  (cursor.moveToFirst()) {
                do {
                    int index1=cursor.getColumnIndex(DistrictDatabse.PROVINCE_NAME);
                    int index2=cursor.getColumnIndex(DistrictDatabse.DISTRICT_NAME);
                    String prov = cursor.getString(index1);
                    String dist=cursor.getString(index2);
                    arList.add("" + prov + " " + dist);
                }while (cursor.moveToNext());
            }

        }
        return arList;
    }






    static  class DistrictDatabse    extends SQLiteOpenHelper{
        private static final int DATABASE_VERSION= 2;
        private static final String DATABASE_NAME="Tourists.db";
        private static final String TABLE_NAME="DISTRICT";
        private static final String UID="_id";
        private static final String PROVINCE_NAME="ProvincName";
        private static final String DISTRICT_NAME="DistrictName";
        private Context context;


        public DistrictDatabse(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context=context;
            Message.message(context,"Constructor called");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {


            try {
                String qurey = "CREATE TABLE " + TABLE_NAME + "("+ UID +" INTEGER PRIMARY KEY AUTOINCREMENT, " + PROVINCE_NAME + " VARCHAR(255)," + DISTRICT_NAME + " VARCHAR(255 ) );";
                Message.message(context,"oncreate called");
                db.execSQL(qurey);
            }catch (SQLException e){
                Message.message(context,""+e);
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME );
            Message.message(context, "onupgrade called" );
            onCreate(db);

        }
    }


}

