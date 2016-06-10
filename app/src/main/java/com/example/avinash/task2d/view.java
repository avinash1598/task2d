package com.example.avinash.task2d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class view extends View {
    Paint paint=new Paint();
    public view(Context context){
        super(context);
    }
    @Override
    public void onDraw(Canvas canvas){

// ********************************************** default image drawable *****************************************************
        int x=canvas.getWidth()/2;
        int y=canvas.getHeight()/2;

        Resources res=getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.mipmap.ic_launcher5);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 60,60, true);
        canvas.drawBitmap(scaledBitmap,x-30,y-30,paint);

    }
}
