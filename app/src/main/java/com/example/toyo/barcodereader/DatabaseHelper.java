package com.example.toyo.barcodereader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by bessi on 5/25/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String EMRI_DATABAZES = "LexuesiBarkodeve.db";
    public static final String EMRI_TABELES = "Produktet";
    public static final String COL_1 = "BarcodeID";
    public static final String COL_2 = "EmriProduktit";
    public static final String COL_3 = "ShtetiImp";
    public static final String COL_4 = "ShtetiPro";
    public static final String COL_5 = "Kategoria";
    public static final String COL_6 = "Pesha";
    public static final String COL_7 = "VleraEnergjetike";
    public static final String COL_8 = "Proteina";
    public static final String COL_9 = "Vitamina";
    public static final String COL_10 = "Karbohidrate";
    public static final String COL_11 = "Yndyre";
    public static final String COL_12 = "Kolesterol";
    public static final String COL_13 = "Sheqer";
    public static final String COL_14 = "Glukoza";
    public static final String COL_15 = "Laktoza";
    public static final String COL_16 = "Natrium";
    public static final String COL_17 = "Kalcium";
    public static final String COL_18 = "Hekur";
    public static final String COL_19 = "Fibra";


    //total 19 kolona


    public DatabaseHelper(Context context) {
        super(context, EMRI_DATABAZES, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    //@Override
   // public void onCreate(SQLiteDatabase sqLiteDatabase) {
     //   sqLiteDatabase.execSQL("CREATE TABLE " + EMRI_TABELES +" (BarcodeID INTEGER PRIMARY KEY, EmriProduktit TEXT, ShtetiPro TEXT, ShtetiImp TEXT, Kategoria TEXT, Pesha INTEGER, VleratEnergjetike INTEGER, Proteina INTEGER, Vitamina INTEGER, Karbohidrate INTEGER, Yndyre INTEGER, Kolesterol INTEGER, Sheqer INTEGER, Glukoza INTEGER, Laktoza INTEGER, Natriumi INTEGER, Kalciumi INTEGER, Hekuri INTEGER, Fibra INTEGER )");
    //}
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + EMRI_TABELES +" (BarcodeID INTEGER PRIMARY KEY, EmriProduktit TEXT, ShtetiImp TEXT, ShtetiPro TEXT, Kategoria TEXT, Pesha REAL, VleraEnergjetike REAL, Proteina REAL, Vitamina TEXT, Karbohidrate REAL, Yndyre REAL, Kolesterol REAL, Sheqer REAL, Glukoza REAL, Laktoza REAL, Natrium REAL, Kalcium REAL, Hekur REAL, Fibra REAL)");
        sqLiteDatabase.execSQL("INSERT INTO Produktet(BarcodeID, EmriProduktit, ShtetiImp, ShtetiPro, Kategoria, Pesha, VleraEnergjetike, Proteina, Vitamina, Karbohidrate, Yndyre, Kolesterol, Sheqer, Glukoza, Laktoza, Natrium, Kalcium, Hekur, Fibra) " +
                "values(3901408430963, 'Sempre, biskota te bluara', 'Kosova', 'Kosova', 'Embelsira', 300, 1851, 10.86, 'B1, B2, E, C, B6', 72.12, 12.2, 0, 17.1, 6.7, 0, 0.5, 47, 2.85, 2.5)");
        sqLiteDatabase.execSQL("INSERT INTO Produktet(BarcodeID, EmriProduktit, ShtetiImp, ShtetiPro, Kategoria, Pesha, VleraEnergjetike, Proteina, Vitamina, Karbohidrate, Yndyre, Kolesterol, Sheqer, Glukoza, Laktoza, Natrium, Kalcium, Hekur, Fibra) " +
                "values(8600109132026, 'Vital, Margarina', 'Kosova', 'Serbia', 'Ushqimore', 250, 7340, 0, 'B1, B2, E, C, B6', 0, 81.5, 75.41, 0, 0,0, 0.5, 47, 2.85, 2.5)");
        sqLiteDatabase.execSQL("INSERT INTO Produktet(BarcodeID, EmriProduktit, ShtetiImp, ShtetiPro, Kategoria, Pesha, VleraEnergjetike, Proteina, Vitamina, Karbohidrate, Yndyre, Kolesterol, Sheqer, Glukoza, Laktoza, Natrium, Kalcium, Hekur, Fibra) " +
                "values(3900864510042, 'Koral, Sallame', 'Kosova', 'Kosova', 'Ushqimore', 150, 1467, 16.4, 'B1, B2, E, C, B6', 1.2, 8.0, 3.1, 1.3, 0, 0, 1.29, 1.7, 2.85, 2.5)");


        sqLiteDatabase.execSQL("INSERT INTO Produktet(BarcodeID, EmriProduktit, ShtetiImp, ShtetiPro, Kategoria, Pesha, VleraEnergjetike, Proteina, Vitamina, Karbohidrate, Yndyre, Kolesterol, Sheqer, Glukoza, Laktoza, Natrium, Kalcium, Hekur, Fibra) " +
                "values(3900270480045, 'Tomato, Ketchup', 'Albania', 'Kosova', 'Ushqimore', 75, 67, 1.6, 'B1, B2, E, C, B6', 14.3, 0.01, 0, 0, 0,0, 0.5, 47, 2.85, 2.5)");


        sqLiteDatabase.execSQL("INSERT INTO Produktet(BarcodeID, EmriProduktit, ShtetiImp, ShtetiPro, Kategoria, Pesha, VleraEnergjetike, Proteina, Vitamina, Karbohidrate, Yndyre, Kolesterol, Sheqer, Glukoza, Laktoza, Natrium, Kalcium, Hekur, Fibra) " +
                "values(5449000000286, 'CocaCola', 'Kosova', 'Gjermani', 'Pije', 2, 463, 0, 'B1, B2, E, C, B6', 10.9, 0, 0, 2.5, 3.4,0, 10.5, 17, 2.85, 2.5)");

        sqLiteDatabase.execSQL("INSERT INTO Produktet(BarcodeID, EmriProduktit, ShtetiImp, ShtetiPro, Kategoria, Pesha, VleraEnergjetike, Proteina, Vitamina, Karbohidrate, Yndyre, Kolesterol, Sheqer, Glukoza, Laktoza, Natrium, Kalcium, Hekur, Fibra) " +
                "values(3902379930018, 'Uje Rugove', 'Kosova', 'Kosova', 'Pije', 500, 0, 0, 'Nuk ka', 0, 0, 0, 0, 0,0, 0, 0, 0, 0)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+EMRI_TABELES);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(Integer BarcodeID, String EmriProduktit, String ShtetiImp, String ShtetiPro, String Kategoria, Double Pesha, Double VE, Double Proteina, String Vitamina, Double Karbohidrate, Double Yndyre, Double Kolesterol, Double Sheqer, Double Glukoza, Double Laktoza, Double Natrium, Double Kalcium, Double Hekur, Double Fibra)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, BarcodeID);
        contentValues.put(COL_2, EmriProduktit);
        contentValues.put(COL_3, ShtetiImp);
        contentValues.put(COL_4, ShtetiPro);
        contentValues.put(COL_5, Kategoria);
        contentValues.put(COL_6, Pesha);
        contentValues.put(COL_7, VE);
        contentValues.put(COL_8, Proteina);
        contentValues.put(COL_9, Vitamina);
        contentValues.put(COL_10, Karbohidrate);
        contentValues.put(COL_11, Yndyre);
        contentValues.put(COL_12, Kolesterol);
        contentValues.put(COL_13, Sheqer);
        contentValues.put(COL_14, Glukoza);
        contentValues.put(COL_15, Laktoza);
        contentValues.put(COL_16, Natrium);
        contentValues.put(COL_17, Kalcium);
        contentValues.put(COL_18, Hekur);
        contentValues.put(COL_19, Fibra);

        long result = db.insert(EMRI_TABELES, null, contentValues);
        {


            if (result == -1)
                return false;
            else
                return true;
        }



    }



    public ArrayList<Cursor> getData(String Query){
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[] { "message" };
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2= new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);



        try{
            String maxQuery = Query ;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[] { "Success" });

            alc.set(1,Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0,c);
                c.moveToFirst();

                return alc ;
            }
            return alc;
        } catch(SQLException sqlEx){
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+sqlEx.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        } catch(Exception ex){
            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+ex.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        }
    }


}
