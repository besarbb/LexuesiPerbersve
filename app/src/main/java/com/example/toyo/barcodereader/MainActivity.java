package com.example.toyo.barcodereader;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.example.toyo.barcodereader.Pop;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.toyo.barcodereader.R.layout.activity_shto;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    DatabaseHelper myDB;
    private Button scanBtn;
    private TextView BarcodeIDTxt, EmriTxt, ShtetiImpTxt, ShtetiProTxt, KategoriaTxt, PeshaTxt, VETxt, ProteinaTxt, VitmaninaTxt, KarboTxt, YndyreTxt, KolesterolTxt, SheqerTxt, GlukozaTxt, LaktozaTxt, NatriumTxt, KalciumTxt, HekurTxt, FibraTxt, formatTxt, contentTxt;
    private Button btLaunchActivity;
    private Button testoDB;
    private Cursor cursor;
    private ImageView ShtetiProImg, DiabetiketImg, YndyrashatImg, LaktozeIntolerantImg, KripeIntolerantImg;

    private double test1, test2, test3, test4, test5;




    @Override
    protected void onCreate(Bundle savedInstanceState) /*nisja e aplikacionit*/
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLaunchActivity = (Button) findViewById(R.id.btnMainShto);
        Button btncani = (Button)findViewById(R.id.btncani);
        btLaunchActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchActivity();
            }
        });

        myDB = new DatabaseHelper(this);

        scanBtn = (Button)findViewById(R.id.scan_button);
        formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);
        testoDB = (Button)findViewById(R.id.btnTestoDb);
        BarcodeIDTxt = (TextView)findViewById(R.id.scan_format);
        EmriTxt = (TextView)findViewById(R.id.scan_content);
        ShtetiImpTxt = (TextView)findViewById(R.id.txtshtetiimp);
        ShtetiProTxt = (TextView)findViewById(R.id.txtshtetipro);
        KategoriaTxt = (TextView)findViewById(R.id.txtkat);
        PeshaTxt = (TextView)findViewById(R.id.txtpesha);
        VETxt = (TextView)findViewById(R.id.txtve);
        ProteinaTxt = (TextView)findViewById(R.id.txtproteina);
        VitmaninaTxt = (TextView)findViewById(R.id.txtvitamina);
        KarboTxt = (TextView)findViewById(R.id.txtkarbo);
        YndyreTxt = (TextView)findViewById(R.id.txtyndyre);
        KolesterolTxt = (TextView)findViewById(R.id.txtkolesterol);
        SheqerTxt = (TextView)findViewById(R.id.txtsheqer);
        GlukozaTxt = (TextView)findViewById(R.id.txtglukoza);
        LaktozaTxt = (TextView)findViewById(R.id.txtlaktoza);
        NatriumTxt = (TextView)findViewById(R.id.txtnatrium);
        KalciumTxt = (TextView)findViewById(R.id.txtkalcium);
        HekurTxt = (TextView)findViewById(R.id.txthekur);
        FibraTxt = (TextView)findViewById(R.id.txtfibra);
        ShtetiProImg = (ImageView)findViewById(R.id.imgViewShtetiProdhues);
        /*DiabetiketImg = (ImageView)findViewById(R.id.imgdiabetiket);
        YndyrashatImg = (ImageView)findViewById(R.id.imgyndyrashat);
        LaktozeIntolerantImg = (ImageView)findViewById(R.id.imglaktozeintolerant);
        KripeIntolerantImg = (ImageView)findViewById(R.id.imgkripintolerant);*/

        btncani.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent popup = new Intent(MainActivity.this, Pop.class);
                popup.putExtra("rezultatiSheqerit", test1);
                popup.putExtra("rezultatiYndyres", test2);
                popup.putExtra("rezultatiLaktozes", test3);
                popup.putExtra("rezultatiKripes", test4);
                popup.putExtra("rezultatiGlukozes", test5);
                startActivity(popup);
            }
        });

        scanBtn.setOnClickListener(this);

        testoDB.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {

                Intent dbmanager = new Intent(getApplicationContext(), AndroidDatabaseManager.class);
                startActivity(dbmanager);
            }
        });
    }

    private void launchActivity(){
        Intent intent = new Intent(this, activity_shto.class);
        startActivity(intent);
    }

    public void onClick(View v) /*thirja e aplikacionit te skenimit, nese klikohet scan butoni*/
    {
        if(v.getId()==R.id.scan_button){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }



    public void onActivityResult(int requestCode, int resultCode, Intent intent) /*marrja e rezultatit nga aplikacioni i skenimit*/
    {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents(); /*identifikimi i barcode-id te marre*/
            String scanFormat = scanningResult.getFormatName(); /*identifikimi i formatit te barcode-it*/
            //formatTxt.setText("Formati i barkodit: " + scanFormat);
            //contentTxt.setText("Barkodi i produktit: " + scanContent);

            //ketu vjen kerkimi i produktit ne baze te kodit te skanuar

            SQLiteDatabase objdb = new DatabaseHelper(getApplicationContext()).getReadableDatabase();

            String query = "SELECT * FROM Produktet WHERE BarcodeID='" + scanContent + "'";

            cursor = objdb.rawQuery(query,null);

            if (cursor != null) {
                cursor.moveToFirst();
            }
            //return cursor;
            String rezBarcodeID = cursor.getString(0);
            String rezEmriProduktit = cursor.getString(1);
            String rezShtetiImp = cursor.getString(2);
            String rezShtetiPro = cursor.getString(3);
            String rezKategoria = cursor.getString(4);
            Double rezPesha = Double.parseDouble(cursor.getString(5));
            Double rezVE = Double.parseDouble(cursor.getString(6));
            Double rezProteina = Double.parseDouble(cursor.getString(7));
            String rezVitamina = cursor.getString(8);
            Double rezKarbo = Double.parseDouble(cursor.getString(9));
            Double rezYndyre = Double.parseDouble(cursor.getString(10));
            test2 = rezYndyre;
            Double rezKolesterol = Double.parseDouble(cursor.getString(11));
            Double rezSheqer = Double.parseDouble(cursor.getString(12));
            test1 = rezSheqer;
            Double rezGlukoza = Double.parseDouble(cursor.getString(13));
            test5 = rezGlukoza;
            Double rezLaktoza = Double.parseDouble(cursor.getString(14));
            test3 = rezLaktoza;
            Double rezNatrium = Double.parseDouble(cursor.getString(15));
            test4=rezNatrium;
            Double rezKalcium = Double.parseDouble(cursor.getString(16));
            Double rezHekur = Double.parseDouble(cursor.getString(17));
            Double rezFibra = Double.parseDouble(cursor.getString(18));



            formatTxt.setText("Barkodi i produktit: " + rezBarcodeID);
            contentTxt.setText("Emri i produktit: " + rezEmriProduktit);
            ShtetiImpTxt.setText("Shteti importues: " + rezShtetiImp);
            ShtetiProTxt.setText("Shteti prodhues: " + rezShtetiPro);
            KategoriaTxt.setText("Kategoria: " + rezKategoria);
            PeshaTxt.setText("Pesha neto: " + String.valueOf(rezPesha) + " gram");
            VETxt.setText("Vlerat energjetike: " + String.valueOf(rezVE)+ " per 100gr");
            ProteinaTxt.setText("Proteina: " + String.valueOf(rezProteina)+ " per 100gr");
            VitmaninaTxt.setText("Vitamina: " + rezVitamina);
            KarboTxt.setText("Karbohidrate: " + String.valueOf(rezKarbo)+ " per 100gr");
            YndyreTxt.setText("Yndyre: " + String.valueOf(rezYndyre)+ " per 100gr");
            KolesterolTxt.setText("Kolesterol: " + String.valueOf(rezKolesterol)+ " per 100gr");
            SheqerTxt.setText("Sheqer: " + String.valueOf(rezSheqer)+ " per 100gr");
            GlukozaTxt.setText("Glukoza: " + String.valueOf(rezGlukoza)+ " per 100gr");
            LaktozaTxt.setText("Laktoza: " + String.valueOf(rezLaktoza)+ " per 100gr");
            NatriumTxt.setText("Natrium: " + String.valueOf(rezNatrium)+ " per 100gr");
            KalciumTxt.setText("Kalcium: " + String.valueOf(rezKalcium)+ " per 100gr");
            HekurTxt.setText("Hekur: " + String.valueOf(rezHekur)+ " per 100gr");
            FibraTxt.setText("Fibra: " + String.valueOf(rezFibra)+ " per 100gr");



            if(rezShtetiPro.equalsIgnoreCase("Kosova"))
            {
                ShtetiProImg.setImageResource(R.drawable.shtetiprodhuesimg);
            }
            else if(rezShtetiPro.equalsIgnoreCase("Serbia"))
            {
                ShtetiProImg.setImageResource(R.drawable.imgshtetiserbia);
            }
            else if(rezShtetiPro.equalsIgnoreCase("Albania"))
            {
                ShtetiProImg.setImageResource(R.drawable.imgshtetiproalb);
            }
            else if(rezShtetiPro.equalsIgnoreCase("Gjermani"))
            {
                ShtetiProImg.setImageResource(R.drawable.shtetiprogjer);
            }

            /*if(rezSheqer > 10 | rezGlukoza > 10 | rezLaktoza > 10)
            {
                DiabetiketImg.setImageResource(R.drawable.imgnotok);
            }
            else
            {
                DiabetiketImg.setImageResource(R.drawable.imgok);
            }

            if(rezYndyre > 10)
            {
                YndyrashatImg.setImageResource(R.drawable.imgnotok);
            }
            else
            {
                YndyrashatImg.setImageResource(R.drawable.imgok);
            }

            if(rezLaktoza > 10)
            {
                LaktozeIntolerantImg.setImageResource(R.drawable.imgnotok);
            }
            else
            {
                LaktozeIntolerantImg.setImageResource(R.drawable.imgok);
            }*/

        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Aplikacioni nuk ka kthyer ndonje barkod!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public double sheqeripertest(){

            return test1;
    }

    public double yndyrapertest(){
        return Double.parseDouble(YndyreTxt.getText().toString());
    }

    public double laktozapertest(){
        return Double.parseDouble(LaktozaTxt.getText().toString());
    }

    public double kripapertest(){
        return Double.parseDouble(NatriumTxt.getText().toString());
    }

    public double glukozapertest(){
        return Double.parseDouble(GlukozaTxt.getText().toString());
    }

}
