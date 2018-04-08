package com.example.rush.listviewtest2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String[] names = new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};

    private int[] imageids = new int[]{R.mipmap.icon1,R.mipmap.icon2,R.mipmap.icon3,R.mipmap.icon4,R.mipmap.icon5,R.mipmap.icon6};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 创建一个List集合，List集合的元素是Map
        List<Map<String,Object>> listItems = new ArrayList<>();

        for(int i = 0; i <names.length ; i++) {
            Map<String,Object> listItem = new HashMap<>();
            listItem.put("header",imageids[i]);
            listItem.put("personName",names[i]);

            listItems.add(listItem);
        }
        // 创建一个SimpleAdapter
        SimpleAdapter simple = new SimpleAdapter(this,listItems, R.layout.activity_item,
                new String[] {"header","personName"},
                new int[]{R.id.header, R.id.personName});

        ListView list = (ListView) findViewById(R.id.mylist);
        // 为ListView设置Adapter
        list.setAdapter(simple);
        // 为ListView的列表项的单击事件绑定事件监听器
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(MainActivity.this, names[position],Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}