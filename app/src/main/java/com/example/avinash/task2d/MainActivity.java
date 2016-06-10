package com.example.avinash.task2d;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! three drawable used circle ,(DEFAULT)image(delta logo),square
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! for transition speak circle ,square,image
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! for movement speak up,down,left,right
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! for resizing speak biggest,smallest
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! task2d project uses dynamic views
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  view.java is the custom view when screen is initializd and
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  viewtop.java is custom view based on command spoken

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public view drawView;
    public static  viewtop vt;
    public static TextView tv;
    public static int rad[]={30,30,30},index=0;
    public static int temp=0;
    public static String shape="image";
    public static String cmd;
    public static LinearLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp);
        parent=(LinearLayout)findViewById(R.id.lyout);
        parent.setOrientation(LinearLayout.VERTICAL);

        //button
        Button top=new Button(this);
        top.setText("TAP TO SPEAK COMMAND");
        top.setGravity(Gravity.CENTER);
        parent.addView(top, 0);
        //textview
         tv=new TextView(this);
        tv.setText("Command");
        tv.setGravity(Gravity.CENTER);
        parent.addView(tv, 1);
        //custom view
        drawView=new view(this);
        parent.addView(drawView,2);
        //custom view 2
        vt=new viewtop(this);



        try {
            top.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    i.putExtra(RecognizerIntent.EXTRA_PROMPT, "COMMAND");

                    try {
                        startActivityForResult(i, 1);
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }catch (Exception e){Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();}

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            ArrayList<String> result = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
               tv.setText(result.get(0));
            cmd=result.get(0);
            Toast.makeText(getApplicationContext(),cmd,Toast.LENGTH_SHORT).show();

        }

        parent.removeViewAt(2);
        vt.setBackgroundColor(Color.WHITE);
        parent.addView(vt,2);

    }

}
