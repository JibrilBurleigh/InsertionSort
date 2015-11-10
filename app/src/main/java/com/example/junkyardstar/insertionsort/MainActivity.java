package com.example.junkyardstar.insertionsort;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String SORTING = "com.example.junkyardstar.SORTING";

    int [] unsortedInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

    public void insertionSort(View view)
    {
        Intent intent = new Intent(this, InsertionSort.class);
        EditText unsorted = (EditText) findViewById(R.id.editText);
        String unsortedString = unsorted.getText().toString();
        unsortedInt = new int[unsortedString.length()];


        for(int i = 0; i < unsortedString.length(); i++)
        {
            unsortedInt[i] = Integer.parseInt(unsortedString.substring(i, i+1));
        }

        for(int i = 1; i < unsortedInt.length; i++)
        {
            int key = unsortedInt[i];

            int temp = i - 1;
            while(i > 0 && unsortedInt[temp] > key)
            {
                unsortedInt[temp + 1] = unsortedInt[temp];
                temp = temp - 1;
            }
            unsortedInt[temp + 1] = key;
        }

        intent.putExtra(SORTING, unsortedInt);
        startActivity(intent);
    }
    
}
