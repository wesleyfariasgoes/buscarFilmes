package br.com.zup.omdb.buscadorfilmes.view.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.zup.omdb.buscadorfilmes.R;
import br.com.zup.omdb.buscadorfilmes.view.activity.content.ContentActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent negativeActivity = new Intent(MainActivity.this, ContentActivity.class);
        startActivity(negativeActivity);
    }
}
