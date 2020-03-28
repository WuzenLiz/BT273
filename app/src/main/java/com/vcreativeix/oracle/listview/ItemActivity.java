package com.vcreativeix.oracle.listview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ItemActivity extends AppCompatActivity {
    private ImageView imageMusic;
    private TextView textTitle, textAuthor;

    private String title, author;
    private int idImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_item);

        imageMusic = findViewById(R.id.imageMusic);
        textTitle = findViewById(R.id.textTitle);
        textAuthor = findViewById(R.id.textAuthor);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        assert bundle != null;
        title = bundle.getString("Title");
        author = bundle.getString("Author");
        idImage = bundle.getInt("Image");

        imageMusic.setImageResource(idImage);
        textTitle.setText(title);
        textAuthor.setText(author);
    }
}
