package com.example.toyo.barcodereader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toyo.barcodereader.R;

public class activity_shto extends AppCompatActivity {

    DatabaseHelper myDb;
    private Button btShtoje;
    EditText BarcodeIDTxt, EmriTxt, ShtetiImpTxt, ShtetiProTxt, KategoriaTxt, PeshaTxt, VETxt, ProteinaTxt, VitmaninaTxt, KarboTxt, YndyreTxt, KolesterolTxt, SheqerTxt, GlukozaTxt, LaktozaTxt, NatriumTxt, KalciumTxt, HekurTxt, FibraTxt, formatTxt, contentTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shto);


        btShtoje = (Button) findViewById(R.id.btnShtoje);
        BarcodeIDTxt = (EditText) findViewById(R.id.editTextBarcodeID);
        EmriTxt = (EditText)findViewById(R.id.editTextEmriProduktit);
        ShtetiImpTxt = (EditText)findViewById(R.id.editTextShtetiImp);
        ShtetiProTxt = (EditText)findViewById(R.id.editTextShtetiPro);
        KategoriaTxt = (EditText)findViewById(R.id.editTextKategoria);
        PeshaTxt = (EditText)findViewById(R.id.editTextPesha);
        VETxt = (EditText)findViewById(R.id.editTextVE);
        ProteinaTxt = (EditText)findViewById(R.id.editTextProteina);
        VitmaninaTxt = (EditText)findViewById(R.id.editTextVitamina);
        KarboTxt = (EditText)findViewById(R.id.editTextKarbohidrate);
        YndyreTxt = (EditText)findViewById(R.id.editTextYndyre);
        KolesterolTxt = (EditText)findViewById(R.id.editTextKolesterol);
        SheqerTxt = (EditText)findViewById(R.id.editTextSheqer);
        GlukozaTxt = (EditText)findViewById(R.id.editTextGlukoza);
        LaktozaTxt = (EditText)findViewById(R.id.editTextLaktoza);
        NatriumTxt = (EditText)findViewById(R.id.editTextNatrium);
        KalciumTxt = (EditText)findViewById(R.id.editTextKalcium);
        HekurTxt = (EditText)findViewById(R.id.editTextHekur);
        FibraTxt = (EditText)findViewById(R.id.editTextFibra);
        AddData();


     //   btShtoje.setOnClickListener(new View.OnClickListener()
      //  @Override
      // public void onClick(View view){
      // finish();
     // }
     // });

    }

    public void AddData(){
        btShtoje.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = myDb.insertData(Integer.parseInt(BarcodeIDTxt.getText().toString()),
                                EmriTxt.getText().toString(),
                                ShtetiImpTxt.getText().toString(),
                                ShtetiProTxt.getText().toString(),
                                KategoriaTxt.getText().toString(),
                                Double.parseDouble(PeshaTxt.getText().toString()),
                                Double.parseDouble(VETxt.getText().toString()),
                                Double.parseDouble(ProteinaTxt.getText().toString()),
                                VitmaninaTxt.getText().toString(),
                                Double.parseDouble(KarboTxt.getText().toString()),
                                Double.parseDouble(YndyreTxt.getText().toString()),
                                Double.parseDouble(KolesterolTxt.getText().toString()),
                                Double.parseDouble(SheqerTxt.getText().toString()),
                                Double.parseDouble(GlukozaTxt.getText().toString()),
                                Double.parseDouble(LaktozaTxt.getText().toString()),
                                Double.parseDouble(NatriumTxt.getText().toString()),
                                Double.parseDouble(KalciumTxt.getText().toString()),
                                Double.parseDouble(HekurTxt.getText().toString()),
                                Double.parseDouble(FibraTxt.getText().toString())
                                );

                        try {
                            if(isInserted)
                                Toast.makeText(activity_shto.this, "Produkti u shtua me sukses", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(activity_shto.this, "Produkti nuk eshte ruajtur ne databaze", Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                }
        );
    }
}
