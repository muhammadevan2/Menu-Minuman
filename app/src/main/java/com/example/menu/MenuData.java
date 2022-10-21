package com.example.menu;

import java.util.ArrayList;

public class MenuData {

    private static String[] menuName = {
            "Es Americano",
            "Es Susu Cincau",
            "Es Kopi Susu",
            "Es Susu Coklat",
            "Es Kopi Late"

    };

    private static String [] menuDetail = {
            "kopi yang dibuat dengan cara diseduh dengan tekanan dan suhu tinggi yang menghasilkan ekstrak kopi yang kental.",
            "Susu putih yang dicampur dengan cincau.",
            "Kopi Susu adalah campuran antara kopi dan susu yang menghasilkan minuman nikmat",
            "Susu Coklat adalah minuman yang berwarna coklat",
            "Caffé latte atau kopi latte ini merupakan salah satu jenis minuman kopi susu yang populer di samping Cappucino."

    };

    private static int [] menuImage = {
            R.drawable.kopiamericano,
            R.drawable.cincau,
            R.drawable.kopisusu,
            R.drawable.susucoklat,
            R.drawable.kopillate,

    };

    static ArrayList<Menu> getListData(){
        ArrayList<Menu> list = new ArrayList<>();
        for(int position = 0; position <menuName.length; position++){
            Menu menu = new Menu();
            menu.setName(menuName[position]);
            menu.setDetail(menuDetail[position]);
            menu.setPhoto(menuImage[position]);
            list.add(menu);
        }
        return list;
    };
}
