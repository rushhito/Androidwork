package com.example.rush.menutest3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
   TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView) findViewById(R.id.txt);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
       this.getMenuInflater().inflate(R.menu.menu_main,menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi)
    {

        //判断单击的是哪个菜单项 ，并有针对性的做出响应
        switch (mi.getItemId())
        {
            case R.id.font_10:
                txt.setTextSize(10*2);
                break;
            case R.id.font_16:
                txt.setTextSize(16*2);
                break;
            case R.id.font_20:
                txt.setTextSize(20*2);
                break;
            case R.id.red_font:
                txt.setTextColor(Color.RED);
                break;
            case R.id.black_font:
                txt.setTextColor(Color.BLACK);
                break;
            case R.id.plain_item:
                Toast toast=Toast.makeText(MainActivity.this, "你点击了普通菜单项", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
        return true;
    }
}
