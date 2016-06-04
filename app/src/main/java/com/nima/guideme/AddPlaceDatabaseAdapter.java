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

public class AddPlaceDatabaseAdapter {

    AddPlaceDatabse placedatabase;
    public AddPlaceDatabaseAdapter(Context context){

        placedatabase=new AddPlaceDatabse(context);
    }

    public long insertData(String type, String district,String name,String address,String number,String path){
        SQLiteDatabase db=placedatabase.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(AddPlaceDatabse.NAME,type);
        contentValues.put(AddPlaceDatabse.NAME2,district);
        contentValues.put(AddPlaceDatabse.NAME3,name);
        contentValues.put(AddPlaceDatabse.NAME4,address);
        contentValues.put(AddPlaceDatabse.NAME5,number);
        contentValues.put(AddPlaceDatabse.PHOTO,path);
        long id= db.insert(AddPlaceDatabse.TABLE_NAME1,null,contentValues);
        return id;
    }

    public String getData(){
        SQLiteDatabase db=placedatabase.getWritableDatabase();
        String[] columns={AddPlaceDatabse.UID,AddPlaceDatabse.NAME,AddPlaceDatabse.NAME2,AddPlaceDatabse.NAME3,AddPlaceDatabse.NAME4,AddPlaceDatabse.NAME5,AddPlaceDatabse.PHOTO};
        Cursor cursor=db.query(AddPlaceDatabse.TABLE_NAME1,columns,null,null,null,null,null);
        StringBuffer buffer=new StringBuffer();
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String type=cursor.getString(1);
            String district=cursor.getString(2);
            String place=cursor.getString(3);
            String add=cursor.getString(4);
            String num=cursor.getString(5);
            String path=cursor.getString(6);
            buffer.append(id+" "+type+" "+district+" "+place +" "+add+" "+num+" "+path +"\n");
        }
        return buffer.toString();
    }


    public ArrayList<String> getDataToList1(String name){

        ArrayList<String> arList = new ArrayList();
        SQLiteDatabase db=placedatabase.getWritableDatabase();
        String[] columns={AddPlaceDatabse.UID,AddPlaceDatabse.NAME3,AddPlaceDatabse.NAME4};
        Cursor cursor=db.query(AddPlaceDatabse.TABLE_NAME1,columns,AddPlaceDatabse.NAME2+" ='"+name+"' ",null,null,null,null);



        if (cursor != null ) {
            if  (cursor.moveToFirst()) {
                do {
                    int index1=cursor.getColumnIndex(AddPlaceDatabse.NAME3);
                    int index2=cursor.getColumnIndex(AddPlaceDatabse.NAME4);
                    String prov = cursor.getString(index1);
                    String dist=cursor.getString(index2);
                    arList.add("" + prov + " " + dist);
                }while (cursor.moveToNext());
            }

        }
        return arList;
    }




    public String getsomedata(String name){

        SQLiteDatabase db=placedatabase.getWritableDatabase();
        String[] columns={AddPlaceDatabse.NAME,AddPlaceDatabse.NAME2,AddPlaceDatabse.NAME3};
        Cursor cursor=db.query(AddPlaceDatabse.TABLE_NAME1,columns,AddPlaceDatabse.NAME2+" ='"+name+"' " ,null,null,null,null);
        StringBuffer buffer=new StringBuffer();
        while (cursor.moveToNext()){
            int index1=cursor.getColumnIndex(AddPlaceDatabse.NAME);
            int index2=cursor.getColumnIndex(AddPlaceDatabse.NAME2);
            int index3=cursor.getColumnIndex(AddPlaceDatabse.NAME3);
            String province=cursor.getString(index1);
            String district=cursor.getString(index2);
            String place=cursor.getString(index3);
            buffer.append(province+" "+district+" "+place +"\n");

        }

        return buffer.toString();
    }



    static  class AddPlaceDatabse    extends SQLiteOpenHelper{
        private static final int DATABASE_VERSION= 1;
        private static final String DATABASE_NAME="Tourists.db";
        private static final String TABLE_NAME1="PLACES";
        private static final String UID="_id";
        private static final String NAME="Type";
        private static final String NAME2="District";
        private static final String NAME3="Name";
        private static final String NAME4="Address";
        private static final String NAME5="Phone";
        public static final String PHOTO = "photo";
        private Context context;


        public AddPlaceDatabse(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context=context;
            Message.message(context,"Constructor called");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {


            try {
                String qurey = "CREATE TABLE "+TABLE_NAME1+"("+ UID +" INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255)," + NAME2 + " VARCHAR(255 ), "+NAME3+" VARCHAR(255), "+NAME4+" VARCHAR(255), "+NAME5+" VARCHAR(255)," + PHOTO+"  VARCHAR(255) );";
                Message.message(context,"oncreate called");
                db.execSQL(qurey);
            }catch (SQLException e){
                Message.message(context,""+e);
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS "  + TABLE_NAME1 );
            Message.message(context, "onupgrade called" );
            onCreate(db);

        }
    }


}
