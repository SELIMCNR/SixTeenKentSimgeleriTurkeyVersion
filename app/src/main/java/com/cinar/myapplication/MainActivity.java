package com.cinar.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cinar.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

private ActivityMainBinding binding;

ArrayList<Landmark> landmarkArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landmarkArrayList = new ArrayList<>();

        Landmark konya = new Landmark("Konya","Turkey",R.drawable.simge);
        Landmark nevsehir = new Landmark("Nevşehir","Turkey",R.drawable.simge2);
        Landmark antalya = new Landmark("Antalya","Turkey",R.drawable.simge3);
        Landmark ankara = new Landmark("Ankara","Turkey",R.drawable.simge4);

        landmarkArrayList.add(konya);
        landmarkArrayList.add(nevsehir);
        landmarkArrayList.add(antalya);
        landmarkArrayList.add(ankara);
        landmarkArrayList.add(konya);
        landmarkArrayList.add(nevsehir);
        landmarkArrayList.add(antalya);
        landmarkArrayList.add(ankara);

        //Adapter veri kaynağı ile xml'i birbirine bağlar.
        //ListView

        //Mapping bir yapıyı başka bir yapıya dönüştürür
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList()));
        binding.listView.setAdapter(arrayAdapter);

        //Listviewde bir elemana Tıklanma olayı
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,landmarkArrayList.get(i).name,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,ActvityDetails.class);
                intent.putExtra("landmark",landmarkArrayList.get(i));
                startActivity(intent);
            }
        });

    }
}