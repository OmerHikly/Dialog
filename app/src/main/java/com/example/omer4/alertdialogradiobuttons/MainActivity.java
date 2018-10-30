package com.example.omer4.alertdialogradiobuttons;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder adb,adb2;
    LinearLayout screen2;

    CharSequence[] values = {"Red", "Green", "Blue"};
    int [] color=new int []{0,0,0} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen2 =findViewById(R.id.screen2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Credits");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent t=new Intent(this,Credits.class);
        startActivity(t);
        return super.onOptionsItemSelected(item);
    }

    public void opendialog(View view) {

        adb=new AlertDialog.Builder(this);
        adb.setTitle("Combine colors");
        adb.setIcon(R.drawable.colorwheel);

        color[0]=0;color[1]=0;color[2]=0;

        final TextView tv=new TextView(this);
        adb.setView(tv);
        tv.setText("Would you like to change the color?");
        tv.setTextSize(20);
        tv.setTextColor(Color.BLACK);
        adb.setMultiChoiceItems(values, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which, boolean ischecked) {
                if(ischecked) color[which]=255;
                else color[which]=0;
                screen2.setBackgroundColor(Color.argb(255,color[0],color[1],color[2]));
                if(color[0]==0&&color[1]==0&&color[2]==0)screen2.setBackgroundColor(Color.WHITE);
            }
        });
        AlertDialog ad=adb.create();
        ad.show();
    }

    public void Reset(View view) {
        screen2.setBackgroundColor(Color.WHITE);
        color[0]=0;color[1]=0;color[2]=0;
    }

    public void Setcolors(View view) {
        adb2=new AlertDialog.Builder(this);
        adb2.setTitle("Set colors");
        adb2.setIcon(R.drawable.colorwheel);


        adb2.setItems(values, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                color[0]=0;color[1]=0;color[2]=0;
                color[which]=255;
                screen2.setBackgroundColor(Color.argb(255,color[0],color[1],color[2]));
            }
        });
        AlertDialog ad=adb2.create();
        ad.show();
    }
}