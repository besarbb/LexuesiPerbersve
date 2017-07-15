package com.example.toyo.barcodereader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.example.toyo.barcodereader.MainActivity;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Doruntina on 7/13/2017.
 */



public class Pop extends MainActivity {


    public TextView DiabetiketTest, YndyrashatTest, LaktozeIntTest, KripeIntTest;
    public ImageView DiabetiketImg, YndyrashatImg, LaktozeIntolerantImg, KripeIntolerantImg;



    public double X;
    public double Y;
    public double Z;
    public double V;
    public double rezSheqer, rezYndyre, rezLaktoza, rezGlukoza, rezKripa;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        setContentView(R.layout.popupwindow);

        Intent intent = getIntent();
        Double rezSheqeri = getIntent().getExtras().getDouble("rezultatiSheqerit");
        Double rezGlukoze = getIntent().getExtras().getDouble("rezultatiGlukozes");
        Double rezLaktoze = getIntent().getExtras().getDouble("rezultatiLaktozes");
        Double rezKripe = getIntent().getExtras().getDouble("rezultatiKripes");
        Double rezYndyre = getIntent().getExtras().getDouble("rezultatiYndyres");
        try {
            X = sheqeripertest();
            Y = yndyrapertest();
            Z = laktozapertest();
            V = kripapertest();
        } catch (Exception e) {
            e.printStackTrace();
        }



        DiabetiketTest = (TextView)findViewById(R.id.txtDiabetiketTest);
        YndyrashatTest = (TextView)findViewById(R.id.txtYndyreTest);
        LaktozeIntTest = (TextView)findViewById(R.id.txtLaktozeTest);
        KripeIntTest = (TextView)findViewById(R.id.txtKripeTest);
        DiabetiketImg = (ImageView)findViewById(R.id.imgdiabetikettest);
        YndyrashatImg = (ImageView)findViewById(R.id.imgyndyrashattest);
        LaktozeIntolerantImg = (ImageView)findViewById(R.id.imglaktozeintoleranttest);
        KripeIntolerantImg = (ImageView)findViewById(R.id.imgkripintoleranttest);
        DiabetiketTest = (TextView)findViewById(R.id.txtDiabetiketTest);
        YndyrashatTest = (TextView)findViewById(R.id.txtYndyreTest);
        LaktozeIntTest = (TextView)findViewById(R.id.txtLaktozeTest);



        if(rezSheqeri > 10 | rezGlukoze > 10 | rezLaktoze > 10)
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

        if(rezLaktoze > 10)
        {
            LaktozeIntolerantImg.setImageResource(R.drawable.imgnotok);
        }
        else
        {
            LaktozeIntolerantImg.setImageResource(R.drawable.imgok);
        }

        if(rezKripe > 10)
        {
            KripeIntolerantImg.setImageResource(R.drawable.imgnotok);
        }
        else
        {
            KripeIntolerantImg.setImageResource(R.drawable.imgok);
        }


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int gjeresia = dm.widthPixels;
        int lartesia = dm.heightPixels;

        getWindow().setLayout((int)(gjeresia*.8), (int)(lartesia*.8));

        /*rezSheqer = ma.sheqeripertest();
        rezYndyre = ma.yndyrapertest();
        rezLaktoza = ma.laktozapertest();
        rezKripa = ma.kripapertest();
        rezGlukoza = ma.glukozapertest();*/

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
        }

        if(rezKripa > 10)
        {
            LaktozeIntolerantImg.setImageResource(R.drawable.imgnotok);
        }
        else
        {
            LaktozeIntolerantImg.setImageResource(R.drawable.imgok);
        }*/

    }
}
