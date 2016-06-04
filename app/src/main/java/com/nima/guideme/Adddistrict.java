package com.nima.guideme;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Adddistrict extends ActionBarActivity {

    EditText provincename,districtname;
    DatabaseAdapter ddatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddistrict);

        provincename=(EditText)findViewById(R.id.pnamevalue);
        districtname=(EditText)findViewById(R.id.dnamevalue);
        ddatabase=new DatabaseAdapter(this);
    }


    public void adduser(View view){

        String pros = provincename.getText().toString();
        String dist =districtname.getText().toString();

         long id=ddatabase.insertData(pros,dist);

        if(id<0){
            Message.message(this,"unseccessful");

        }else{
            Message.message(this,"successful");

        }

    }

    public void viewdetails(View view){
        String data=ddatabase.getData();
        Message.message(this,data);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_adddistrict, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
