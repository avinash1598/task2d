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
import android.widget.TextView;
import android.widget.Toast;


public class viewtop extends View {

    MainActivity obj = new MainActivity();

    public int midx,midy,curx,cury;
    Paint paint = new Paint();
    public viewtop(Context context)
    {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {
         midx=canvas.getWidth()/2;
         midy=canvas.getHeight()/2;

        paint.setColor(0xFF417FA9);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

        Resources res=getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.mipmap.ic_launcher5);
        Bitmap scaledBitmap;
        //canvas.drawBitmap(scaledBitmap,curx-30,cury-30,paint);
//****************************************************   movement   ****************************************************************
        switch (obj.cmd) {
            case "down":  {if (obj.temp == 0) {
                           cury = midy+10;
                           curx = midx;
                           obj.temp = 1;
                          }
                           else{
                           if(cury>=canvas.getHeight()-obj.rad[obj.index]){
                           cury=obj.rad[obj.index];
                           }
                           else{
                           cury+=10;
                           }
                           }
                if((obj.shape).matches("circle"))
                {canvas.drawCircle(curx,cury,obj.rad[obj.index], paint);}
                else if((obj.shape).matches("square")){
                    canvas.drawRect(curx-obj.rad[obj.index],cury-obj.rad[obj.index],curx+obj.rad[obj.index],cury+obj.rad[obj.index],paint);
                }
                else if((obj.shape).matches("image")){
                     scaledBitmap = Bitmap.createScaledBitmap(bitmap, 2*obj.rad[obj.index],2*obj.rad[obj.index], true);
                    canvas.drawBitmap(scaledBitmap,curx-obj.rad[obj.index],cury-obj.rad[obj.index],paint);
                }

                          break;}

            case "up":{if (obj.temp == 0) {
                       cury = midy-10;
                       curx = midx;
                       obj.temp = 1;
                       }
                       else{
                       if(cury<=obj.rad[obj.index]){
                       cury=canvas.getHeight()-obj.rad[obj.index];
                       }
                       else{
                       cury-=10;
                       }
                      }
                if((obj.shape).matches("circle"))
                {canvas.drawCircle(curx,cury,obj.rad[obj.index], paint);}
                else if((obj.shape).matches("square")){
                    canvas.drawRect(curx-obj.rad[obj.index],cury-obj.rad[obj.index],curx+obj.rad[obj.index],cury+obj.rad[obj.index],paint);
                }
                else if((obj.shape).matches("image")){
                    scaledBitmap = Bitmap.createScaledBitmap(bitmap, 2*obj.rad[obj.index],2*obj.rad[obj.index], true);
                    canvas.drawBitmap(scaledBitmap,curx-obj.rad[obj.index],cury-obj.rad[obj.index],paint);
                }
                break;
            }

            case "left":{if (obj.temp == 0) {
                         cury = midy;
                         curx = midx-10;
                         obj.temp = 1;
                         }
                         else{
                         if(curx<=obj.rad[obj.index]){
                             curx=canvas.getWidth()-obj.rad[obj.index];
                         }
                         else{
                             curx-=10;
                         }
                         }
                if((obj.shape).matches("circle"))
                {canvas.drawCircle(curx,cury,obj.rad[obj.index], paint);}
                else if((obj.shape).matches("square")){
                    canvas.drawRect(curx-obj.rad[obj.index],cury-obj.rad[obj.index],curx+obj.rad[obj.index],cury+obj.rad[obj.index],paint);
                }
                else if((obj.shape).matches("image")){
                    scaledBitmap = Bitmap.createScaledBitmap(bitmap, 2*obj.rad[obj.index],2*obj.rad[obj.index], true);
                    canvas.drawBitmap(scaledBitmap,curx-obj.rad[obj.index],cury-obj.rad[obj.index],paint);
                }
                break;
            }
            case "right":{if (obj.temp == 0) {
                          cury = midy;
                          curx = midx+10;
                          obj.temp = 1;
                          }
                          else{
                          if(curx>=canvas.getWidth()-obj.rad[obj.index]){
                              curx=obj.rad[obj.index];
                          }
                          else{
                              curx+=10;
                          }
                          }
                if((obj.shape).matches("circle"))
                {canvas.drawCircle(curx,cury,obj.rad[obj.index], paint);}
                else if((obj.shape).matches("square")){
                    canvas.drawRect(curx-obj.rad[obj.index],cury-obj.rad[obj.index],curx+obj.rad[obj.index],cury+obj.rad[obj.index],paint);
                }
                else if((obj.shape).matches("image")){
                    scaledBitmap = Bitmap.createScaledBitmap(bitmap, 2*obj.rad[obj.index],2*obj.rad[obj.index], true);
                    canvas.drawBitmap(scaledBitmap,curx-obj.rad[obj.index],cury-obj.rad[obj.index],paint);
                }
                  break;
            }

       //****************************************************  resizing   **********************************************************

            case "smallest":{obj.rad[0]=obj.rad[1]=obj.rad[2]=10;
                             if(obj.temp==0){
                             curx=midx;cury=midy;
                             }
                if((obj.shape).matches("circle"))
                {canvas.drawCircle(curx,cury,obj.rad[obj.index], paint);}
                else if((obj.shape).matches("square")){
                    canvas.drawRect(curx-obj.rad[obj.index],cury-obj.rad[obj.index],curx+obj.rad[obj.index],cury+obj.rad[obj.index],paint);
                }
                else if((obj.shape).matches("image")){
                    scaledBitmap = Bitmap.createScaledBitmap(bitmap, 2*obj.rad[obj.index],2*obj.rad[obj.index], true);
                    canvas.drawBitmap(scaledBitmap,curx-obj.rad[obj.index],cury-obj.rad[obj.index],paint);
                }
                             break;
                           }

            case "biggest":{obj.rad[0]=obj.rad[1]=obj.rad[2]=canvas.getWidth()/2;
                           curx=midx;cury=midy;
                if((obj.shape).matches("circle"))
                {canvas.drawCircle(curx,cury,obj.rad[obj.index], paint);}
                else if((obj.shape).matches("square")){
                    canvas.drawRect(curx-obj.rad[obj.index],cury-obj.rad[obj.index],curx+obj.rad[obj.index],cury+obj.rad[obj.index],paint);
                }
                else if((obj.shape).matches("image")){
                    scaledBitmap = Bitmap.createScaledBitmap(bitmap, 2*obj.rad[obj.index],2*obj.rad[obj.index], true);
                    canvas.drawBitmap(scaledBitmap,curx-obj.rad[obj.index],cury-obj.rad[obj.index],paint);
                }
                           break;
                           }
       //***************************************************  drawable selection  *****************************************************

            case "square":{ obj.shape="square";obj.index=1;
                if(obj.temp==0){curx=midx;cury=midy;}
                canvas.drawRect(curx-obj.rad[obj.index],cury-obj.rad[obj.index],curx+obj.rad[obj.index],cury+obj.rad[obj.index],paint);
                break;
            }

            case "circle":{obj.shape="circle";obj.index=0;
                if(obj.temp==0){curx=midx;cury=midy;}
                canvas.drawCircle(midx,midy,obj.rad[obj.index],paint);
                break;
            }
            case "image":{ obj.shape="image";obj.index=2;
                if(obj.temp==0){curx=midx;cury=midy;}
                scaledBitmap = Bitmap.createScaledBitmap(bitmap, 2*obj.rad[obj.index],2*obj.rad[obj.index], true);
                canvas.drawBitmap(scaledBitmap,curx-obj.rad[obj.index],cury-obj.rad[obj.index],paint);
                break;
            }

    /********************************************************************************************************************************/
            default:{  if(obj.temp==0){
                      curx=midx;cury=midy;
                       }
                if((obj.shape).matches("circle"))
                {canvas.drawCircle(curx,cury,obj.rad[obj.index], paint);}
                else if((obj.shape).matches("square")){
                    canvas.drawRect(curx-obj.rad[obj.index],cury-obj.rad[obj.index],curx+obj.rad[obj.index],cury+obj.rad[obj.index],paint);
                }
                else if((obj.shape).matches("image")){
                    scaledBitmap = Bitmap.createScaledBitmap(bitmap, 2*obj.rad[obj.index],2*obj.rad[obj.index], true);
                    canvas.drawBitmap(scaledBitmap,curx-obj.rad[obj.index],cury-obj.rad[obj.index],paint);
                }
                Toast.makeText(getContext(), "INVALID COMMAND", Toast.LENGTH_SHORT).show();

            }
        }
    }
}