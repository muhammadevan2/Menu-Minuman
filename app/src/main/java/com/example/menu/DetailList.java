package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailList extends AppCompatActivity {
    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_listmenu);

        ImageView imgMenu =  findViewById(R.id.imgFoto);
        TextView menuName = findViewById(R.id.menuDtlName);
        TextView menuDetail = findViewById(R.id.menuDetail);

        Menu menu = getIntent().getParcelableExtra(ITEM_EXTRA);
        if(menu != null){
            Glide.with(this)
                    .load(menu.getPhoto())
                    .into(imgMenu);
            menuName.setText(menu.getName());
            menuDetail.setText(menu.getDetail());
        }
        if(getSupportActionBar() != null){//membuat menu diatas
            getSupportActionBar().setTitle("Menu Detail");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}