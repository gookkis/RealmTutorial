package com.gookkis.realmtutorial.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gookkis.realmtutorial.R;
import com.gookkis.realmtutorial.helper.RealmHelper;

public class AddActivity extends AppCompatActivity {


    private RealmHelper realmHelper;
    private EditText inputDescription;
    private EditText inputTitle;
    private Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);


        realmHelper = new RealmHelper(AddActivity.this);


        inputTitle = (EditText) findViewById(R.id.inputTitle);
        inputDescription = (EditText) findViewById(R.id.inputDescription);
        save = (Button) findViewById(R.id.save);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //inisialisasi string
                String title, description;

                //mengambil text dr edittext
                title = inputTitle.getText().toString();
                description = inputDescription.getText().toString();

                //menambahkan data pada database
                realmHelper.addArticle(title, description);

                //menutup Add Activity
                finish();
                //kembali ke MainActivity
                Intent i = new Intent(AddActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
} 