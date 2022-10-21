package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMenu;
    private ArrayList<Menu> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMenu = findViewById(R.id.rv_menu);
        rvMenu.setHasFixedSize(true);

        list.addAll(MenuData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvMenu.setLayoutManager(new LinearLayoutManager(this));
        ListMenuAdapter listMenuAdapter = new ListMenuAdapter(list);
        rvMenu.setAdapter(listMenuAdapter);

        listMenuAdapter.setOnItemClickCallBack(new ListMenuAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Menu menu) {
                Intent moveIntent = new Intent(MainActivity.this, DetailList.class);
                moveIntent.putExtra(DetailList.ITEM_EXTRA, menu);
                startActivity(moveIntent);
            }
        });
    }



}