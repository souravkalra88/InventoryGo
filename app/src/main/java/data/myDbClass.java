package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import model.DATA;
import params.params;

public class myDbClass extends SQLiteOpenHelper {

    public myDbClass(Context context) {
        super(context, params.DB_NAME, null, params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + params.TABLE_NAME + "(" + params.KEY_ID + " INTEGER PRIMARY KEY," + params.NAME + " TEXT, " + params.AMOUNT + " TEXT, " + params.PRICE + " TEXT, " + params.SUPPLIER_NAME + " TEXT, " + params.SUPPLIER_CONTACT + " TEXT" + ")";
        Log.d("DBSK" , "QUERY IS " + create);
        db.execSQL(create);


    }
    public void deleteAll() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //deleting rows
        sqLiteDatabase.delete(params.TABLE_NAME, null, null);
        sqLiteDatabase.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public  void addDATA(DATA d){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(params.NAME,d.getName());
        values.put(params.PRICE ,d.getPrice() );
        values.put(params.AMOUNT ,d.getAmount() );
        values.put(params.SUPPLIER_NAME ,d.getSupplier() );
        values.put(params.SUPPLIER_CONTACT ,d.getsContact() );

        db.insert(params.TABLE_NAME,null,values);
        Log.d("TABLE","INSERTED");
        db.close();

    }
    public List<DATA> getAll(){
        List<DATA> ll = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "Select * From " + params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select,null);
        if (cursor.moveToFirst()){
            do{
                DATA dd = new DATA();
                dd.setId(cursor.getString(0));
                dd.setName(cursor.getString(1));
                dd.setAmount(cursor.getString(2));
                dd.setPrice(cursor.getString(3));
                dd.setSupplier(cursor.getString(4));
                dd.setsContact(cursor.getString(5));
                ll.add(dd);
            }while (cursor.moveToNext());

        }
    return ll;
    }
    public int updateData(DATA d){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(params.NAME,d.getName());
        values.put(params.AMOUNT,d.getAmount());
        values.put(params.PRICE,d.getPrice());
        values.put(params.SUPPLIER_NAME,d.getSupplier());
        values.put(params.SUPPLIER_CONTACT,d.getsContact());

        return db.update(params.TABLE_NAME,values,params.KEY_ID + "=?" , new String[]{d.getId()});

    }
    public void deleteDataById(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(params.TABLE_NAME,params.KEY_ID + "=?" ,new String[]{id});
        db.close();
    }
    public void deleteData(DATA d){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(params.TABLE_NAME,params.KEY_ID + "=?" ,new String[]{d.getId()});
        db.close();
    }
    public  int getCount(){
        String query = "SELECT   * FROM " + params.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        return cursor.getCount();
    }


}
