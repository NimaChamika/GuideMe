package com.nima.guideme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;


public class MainActivity extends AppCompatActivity {

    private Button btn_addplace;
    int PLACE_PICKER_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nearme();
        addattractions();
        addrestaurant();
        addhotel();
        addshopping();
        addplace();


    }



    public void Edo(){

        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        try {

            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }


    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                String toastMsg = String.format("Place: %s", place.getName());
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
            }
        }
    }


    public void nearme(){
        btn_addplace = (Button) findViewById(R.id.b1);
        btn_addplace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Edo();
            }
        });
    }

    public void addattractions() {

        btn_addplace = (Button) findViewById(R.id.b2);
        btn_addplace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Adddistrict.class));
            }
        });


    }

    public void addrestaurant() {

        btn_addplace = (Button) findViewById(R.id.b3);
        btn_addplace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShowDistrict.class));
            }
        });


    }

    public void addhotel() {

        btn_addplace = (Button) findViewById(R.id.b4);
        btn_addplace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProvincePage.class));
            }
        });
    }

    public void addshopping() {

        btn_addplace = (Button) findViewById(R.id.b5);
        btn_addplace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProvincePage.class));
            }
        });
    }


    public void addplace() {

        btn_addplace = (Button) findViewById(R.id.b6);
        btn_addplace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Addplace.class));
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
