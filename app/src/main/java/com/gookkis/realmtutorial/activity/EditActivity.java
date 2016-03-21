package com.gookkis.realmtutorial.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gookkis.realmtutorial.R;
import com.gookkis.realmtutorial.helper.RealmHelper;
import com.gookkis.realmtutorial.model.ArticleModel;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {


    private int position;
    private Button delete, save;
    private EditText inputTitle, inputDescription;
    private RealmHelper helper;
    private String title, description;
    private String intentTitle, intentDescription;
    private ArrayList<ArticleModel> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        helper = new RealmHelper(EditActivity.this);
        data = new ArrayList<>();
        position = getIntent().getIntExtra("id", 0);
        intentTitle = getIntent().getStringExtra("title");
        intentDescription = getIntent().getStringExtra("description");


        delete = (Button) findViewById(R.id.delete);
        save = (Button) findViewById(R.id.save);


        inputTitle = (EditText) findViewById(R.id.inputTitle);
        inputDescription = (EditText) findViewById(R.id.inputDescription);


        inputTitle.setText(intentTitle);
        inputDescription.setText(intentDescription);


        delete.setVisibility(View.VISIBLE);

        //perintah untuk menghapus
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //menghapus data dari database
                helper.deleteData(position);

                //berpindah ke MainActivity
                startActivity(new Intent(EditActivity.this, MainActivity.class));
                finish();
            }
        });

        //perintah mengupdate data
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //mengambil text dari edittext
                title = inputTitle.getText().toString();
                description = inputDescription.getText().toString();

                //melakukan update artikel
                helper.updateArticle(position, title, description);

                //berpindah ke MainActivity
                startActivity(new Intent(EditActivity.this, MainActivity.class));
                finish();
            }
        });


    }


} 