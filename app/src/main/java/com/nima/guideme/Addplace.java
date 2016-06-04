package com.nima.guideme;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Addplace extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    //private static final int SD_REQUEST = 1;
    private static final int SELECT_PICTURE = 1;
    private static final int TAKE_PICTURE = 2;
    EditText province,district,place;

    AddPlaceDatabaseAdapter placedatabase;
    Spinner s0,s1,s2;
    String type="";
    String pp="";
    String photopath="";
    private String selectedImage;
    private Uri imageUri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplace);

        province=(EditText)findViewById(R.id.provincevalue);
        district=(EditText)findViewById(R.id.districtvalue);
        place=(EditText)findViewById(R.id.placevalue);
        placedatabase=new AddPlaceDatabaseAdapter(this);




        s0=(Spinner)findViewById(R.id.spinner3);
        s1 = (Spinner)findViewById(R.id.spinner1);
        s2 = (Spinner)findViewById(R.id.spinner2);
        s0.setOnItemSelectedListener(this);
        s1.setOnItemSelectedListener(this);
    }




    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                               long arg3) {
        // TODO Auto-generated method stub

        String sp3=String.valueOf(s0.getSelectedItem());

        if(sp3.contentEquals("TYPE IS REQUIRED!")){
            type="TYPE IS REQUIRED!";
        }

        if(sp3.contentEquals("Attraction")){
            type="Attraction";

        }
        if(sp3.contentEquals("Restaurant")){
            type="Restaurant";

        }
        if(sp3.contentEquals("Hotel")){
            type="Hotel";

        }
        if(sp3.contentEquals("Shopping")){
            type="Shopping";

        }




        String sp1= String.valueOf(s1.getSelectedItem());
        //Toast.makeText(this, sp1, Toast.LENGTH_SHORT).show();
        if(sp1.contentEquals("Southern")) {
            List<String> list = new ArrayList<String>();
            list.add("Matara");
            list.add("Galle");
            list.add("Hambantota");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);



            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    if (position == 0) {
                         pp="Matara";
                         //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }

                    if (position == 1) {
                        pp="Galle";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }
                    if (position == 2) {
                        pp="Hambantota";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }
            });
        }
        if(sp1.contentEquals("Western")) {
            List<String> list = new ArrayList<String>();
            list.add("Colombo");
            list.add("Gampaha");
            list.add("Kaluathara");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);

            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    if (position == 0) {
                        pp="Colombo";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                        }

                    if (position == 1) {
                        pp="Gampaha";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }
                    if (position == 2) {
                        pp="Kaluathara";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }
            });


        }

        if(sp1.contentEquals("Central")) {
            List<String> list = new ArrayList<String>();
            list.add("Kandy");
            list.add("Matale");
            list.add("Nuwara Eliya");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);

            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    if (position == 0) {
                        pp="Kandy";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }

                    if (position == 1) {
                        pp="Matale";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }
                    if (position == 2) {
                        pp="Nuwara Eliya";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }
            });


        }

        if(sp1.contentEquals("NorthCentral")) {
            List<String> list = new ArrayList<String>();
            list.add("Anuradhapura");
            list.add("Polonaruwa");

            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);

            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    if (position == 0) {
                        pp="Anuradhapura";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }

                    if (position == 1) {
                        pp="Polonaruwa";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }


                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }
            });


        }

        if(sp1.contentEquals("Eastern")) {
            List<String> list = new ArrayList<String>();
            list.add("Ampara");
            list.add("Batticaloa");
            list.add("Trincomalee");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);

            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    if (position == 0) {
                        pp="Ampara";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }

                    if (position == 1) {
                        pp="Batticaloa";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }
                    if (position == 2) {
                        pp="Trincomalee";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }
            });


        }

        if(sp1.contentEquals("NorthWestern")) {
            List<String> list = new ArrayList<String>();
            list.add("Kurunegala");
            list.add("Puttalam");

            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);

            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    if (position == 0) {
                        pp="Kurunegala";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }

                    if (position == 1) {
                        pp="Puttalam";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }


                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }
            });


        }

        if(sp1.contentEquals("Uva")) {
            List<String> list = new ArrayList<String>();
            list.add("Badulla");
            list.add("Monaragala");
            //list.add("Purchase");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);

            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    if (position == 0) {
                        pp="Badulla";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }

                    if (position == 1) {
                        pp="Monaragala";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }


                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }
            });


        }

        if(sp1.contentEquals("Sabaragamuwa")) {
            List<String> list = new ArrayList<String>();
            list.add("Kegaale");
            list.add("Rathnapura");
            //list.add("Purchase");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);

            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    if (position == 0) {
                        pp="Kegaale";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }

                    if (position == 1) {
                        pp="Rathnapura";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }


                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }
            });


        }

        if(sp1.contentEquals("North")) {
            List<String> list = new ArrayList<String>();
            list.add("Jaffna");
            list.add("Killnochchi");
            list.add("Vavuniya");
            list.add("Mullatiuv");
            list.add("Mannar");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);

            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    if (position == 0) {
                        pp="Jaffna";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }

                    if (position == 1) {
                        pp="Killnochchi";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }
                    if (position == 2) {
                        pp="Vavuniya";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }
                    if (position == 3) {
                        pp="Mullatiuv";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }
                    if (position == 4) {
                        pp="Mannar";
                        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }
            });


        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void addplace(View view){

        //Toast.makeText(Addplace.this, pp, Toast.LENGTH_SHORT).show();
        String t=type;
        String dist =pp;
        String name = province.getText().toString();
        String add=district.getText().toString();
        String num=place.getText().toString();
        String path=photopath;





        if(type=="TYPE IS REQUIRED!"){

        }

        else if(name.length()==0){

            province.setHint("Name is required!");
        }
        else if(add.length()==0){
            district.setHint("Address is required!");
        }
        else if(num.length()==0 || num.length()!=10){
            place.setText("");
            place.setHint("Phone number is required(10 digits)!");

        }

        else {
            long id = placedatabase.insertData(t, dist, name, add, num,path);
            if (id < 0) {
                Message.message(this, "unseccessful");

            } else {
                Message.message(this, "successful");

            }

            province.setText("");
            district.setText("");
            place.setText("");
        }
    }


    public void viewDetails(View view){
        String data=placedatabase.getData();
        Message.message(this, data);

    }

    public void onview2(View view){
       /* String s1="Matara";
        String s=placedatabase.getsomedata(s1);

        Message.message(this, s);*/

        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(Addplace.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                //boolean result=Utility.checkPermission(Addplace.this);
                if (items[item].equals("Take Photo")) {

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File photo = new File(Environment.getExternalStorageDirectory(),  "Pic.jpg");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(photo));
                    imageUri = Uri.fromFile(photo);
                    startActivityForResult(intent, TAKE_PICTURE);
                } else if (items[item].equals("Choose from Library")) {

                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent,
                            "Select Picture"), SELECT_PICTURE);
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();


       /* */

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImage = getPath(selectedImageUri);
                ImageView imgView = (ImageView) findViewById(R.id.image3);
                imgView.setImageURI(Uri.parse(selectedImage));
                photopath= selectedImage.toString();
            }
            else{
                Uri selectedImage = imageUri;
                getContentResolver().notifyChange(selectedImage, null);
                ImageView imageView = (ImageView) findViewById(R.id.image3);
                ContentResolver cr = getContentResolver();
                Bitmap bitmap;
                try {
                    bitmap = android.provider.MediaStore.Images.Media
                            .getBitmap(cr, selectedImage);

                    imageView.setImageBitmap(bitmap);
                    selectedImage.toString();

                } catch (Exception e) {
                    Toast.makeText(this, "Failed to load", Toast.LENGTH_SHORT)
                            .show();
                    Log.e("Camera", e.toString());
                }


            }
        }
        Toast.makeText(this, selectedImage.toString(),
                Toast.LENGTH_LONG).show();

    }

    /**
     * helper to retrieve the path of an image URI
     */
    public String getPath(Uri uri) {
        // just some safety built in
        if( uri == null ) {
            // TODO perform some logging or show user feedback
            return null;
        }
        // try to retrieve the image from the media store first
        // this will only work for images selected from gallery
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if( cursor != null ){
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        // this is our fallback here


        return uri.getPath();
    }


















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_addplace, menu);
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
