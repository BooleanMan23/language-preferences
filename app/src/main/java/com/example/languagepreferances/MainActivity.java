package com.example.languagepreferances;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    SharedPreferences sharedPreferences;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);

        if(item.getItemId() == R.id.Indonesia){



            //setup alert
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Are you sure?")
                    .setMessage("Do you definietly want to change language to Indonesia?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            sharedPreferences.edit().putString("bahasa", "Indonesia").apply();
                            String bahasa = sharedPreferences.getString("bahasa", "");

                            textView.setText(bahasa);

                            Toast.makeText(MainActivity.this, "Its done", Toast.LENGTH_SHORT).show();

                        }
                    })
                    .setNegativeButton("No", null)
                    .show();


            return  true;

        }
        else if(item.getItemId() == R.id.English){



            //setup alert
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Apakah anda yakin?")
                    .setMessage("Apakah anda ingin merubah menjadi bahasa Inggris?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            sharedPreferences.edit().putString("bahasa", "Inggris").apply();
                            String bahasa = sharedPreferences.getString("bahasa", "");

                            textView.setText(bahasa);
                            Toast.makeText(MainActivity.this, "Selesai", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();


            return  true;
        }
        else {
            return  false;
        }
//        switch (item.getItemId()){
//            case R.id.Indonesia :
//                textView.setText("Indonesia");
//                return  true;
//            case R.id.English :
//                Log.i("Menu Item Selected", "Help");
//                textView.setText("English");
//                return  true;
//            default:
//                return  false;
//
//        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = this.getSharedPreferences("com.example.languagepreferances", Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        String bahasa = sharedPreferences.getString("bahasa", "");
        textView.setText(bahasa);




    }
}
