package com.example.ahmed.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txt_showMyDrink, txt;
    String names[];
    boolean check[];
    ArrayList<String> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arr = new ArrayList<>();
        txt_showMyDrink = (TextView) findViewById(R.id.txt_showMyDrink);
        txt = (TextView) findViewById(R.id.txt);
        names = getResources().getStringArray(R.array.drink_names);
        check = new boolean[names.length];
    }

    public void showDialog(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMultiChoiceItems(names, check, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                if (check[i] == true)
                    arr.add(names[i]);
                else
                    arr.remove(names[i]);
            }
        });

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                txt.setVisibility(View.VISIBLE);
                txt_showMyDrink.setText("");
                for (int j = 0; j < arr.size(); j++)
                    txt_showMyDrink.append(arr.get(j) + "\n");
            }
        });
        alert.show();
    }
}
