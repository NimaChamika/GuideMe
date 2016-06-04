package com.nima.guideme;

/**
 * Created by user on 5/24/2016.
 */
import android.content.Context;
import android.widget.Toast;

public class Message {
    public static void message(Context context,String message){

        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

}
