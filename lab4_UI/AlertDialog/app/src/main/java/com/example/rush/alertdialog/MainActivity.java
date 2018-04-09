package com.example.rush.alertdialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void customView(View source)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this)
                .setTitle("ANDROID APP")
                .setView(R.layout.login)
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (TextUtils.isEmpty(editText1.getText().toString())||
                                TextUtils.isEmpty(editText2.getText().toString())){
                            Toast.makeText(MainActivity.this,"pless fill out the complete",Toast.LENGTH_SHORT).show();

                            try{
                                Field field=dialog.getClass().getSuperclass().getDeclaredField("mshowing");
                                field.setAccessible(true);
                                field.set(dialog,false);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }else{
                            Log.d("acccc",editText1.getText().toString());
                            Log.d("acccc",editText2.getText().toString());

                            try{
                                Field field=dialog.getClass().getSuperclass().getDeclaredField("mstring");
                                field.setAccessible(true);
                                field.set(dialog,true);

                            }catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try{
                            Field field = dialog.getClass().getSuperclass().getDeclaredField("mstring");
                            field.setAccessible(true);
                            field.set(dialog,true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();

        editText1=(EditText)dialog.findViewById(R.id.editText1);
        editText2=(EditText)dialog.findViewById(R.id.editText2);

    }
}

