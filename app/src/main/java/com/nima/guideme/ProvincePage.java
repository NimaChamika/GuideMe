package com.nima.guideme;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class ProvincePage extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province_page);

       southern();
        western();
        central();
        northcentral();
        eastern();
        northwestern();
        uva();
        sabaragamuwa();
        north();

    }




    public void southern(){

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.southernprovince, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                        if(position==1) {
                            Toast.makeText(ProvincePage.this, "Matara", Toast.LENGTH_SHORT).show();
                        }

                        if(position==2) {
                            Toast.makeText(ProvincePage.this, "Galle", Toast.LENGTH_SHORT).show();
                        }
                        if(position==3) {
                            Toast.makeText(ProvincePage.this, "Hambantotta", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // TODO Auto-generated method stub
                    }
                });

    }

    public void western(){

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.westernprovince, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if(position==1) {
                    Toast.makeText(ProvincePage.this, "Colombo", Toast.LENGTH_SHORT).show();
                }

                if(position==2) {
                    Toast.makeText(ProvincePage.this, "Gampaha", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Toast.makeText(ProvincePage.this, "Kaluthara", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void central(){

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.centralprovince, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if(position==1) {
                    Toast.makeText(ProvincePage.this, "Kandy", Toast.LENGTH_SHORT).show();
                }

                if(position==2) {
                    Toast.makeText(ProvincePage.this, "Matale", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Toast.makeText(ProvincePage.this, "NuwaraEliya", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void northcentral(){

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.northcentralprovince, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if(position==1) {
                    Toast.makeText(ProvincePage.this, "Anuradhapura", Toast.LENGTH_SHORT).show();
                }

                if(position==2) {
                    Toast.makeText(ProvincePage.this, "Polonnaruwa", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void eastern(){

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner5);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.easternprovince, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if(position==1) {
                    Toast.makeText(ProvincePage.this, "Ampara", Toast.LENGTH_SHORT).show();
                }

                if(position==2) {
                    Toast.makeText(ProvincePage.this, "Batticaloa", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Toast.makeText(ProvincePage.this, "Trincomalee", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void northwestern(){

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner6);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.northwesternprovince, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if(position==1) {
                    Toast.makeText(ProvincePage.this, "Kurunegala", Toast.LENGTH_SHORT).show();
                }

                if(position==2) {
                    Toast.makeText(ProvincePage.this, "Puttalam", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void uva(){

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner7);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.uvaprovince, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if(position==1) {
                    Toast.makeText(ProvincePage.this, "Badulla", Toast.LENGTH_SHORT).show();
                }

                if(position==2) {
                    Toast.makeText(ProvincePage.this, "Monaragala", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void sabaragamuwa(){

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner8);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.sabaragamuwaprovince, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if(position==1) {
                    Toast.makeText(ProvincePage.this, "keggale", Toast.LENGTH_SHORT).show();
                }

                if(position==2) {
                    Toast.makeText(ProvincePage.this, "Rathnapura", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void north(){

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner9);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.northprovince, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if(position==1) {
                    Toast.makeText(ProvincePage.this, "jaffna", Toast.LENGTH_SHORT).show();
                }

                if(position==2) {
                    Toast.makeText(ProvincePage.this, "Killinochchi", Toast.LENGTH_SHORT).show();
                }
                if(position==3) {
                    Toast.makeText(ProvincePage.this, "Vavuniya", Toast.LENGTH_SHORT).show();
                }

                if(position==4) {
                    Toast.makeText(ProvincePage.this, "Mullatiuv", Toast.LENGTH_SHORT).show();
                }
                if(position==5) {
                    Toast.makeText(ProvincePage.this, "Mannar", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_province_page, menu);
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
