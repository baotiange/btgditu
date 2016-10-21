package com.example.administrator.ditu;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class LisActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private ArrayAdapter<String>arr_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lis);
        listView=(ListView) findViewById(R.id.listView);
        String[]arr_data={"点击发送"};
        arr_adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr_data);
        listView.setAdapter(arr_adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        EditText editText =(EditText)findViewById(R.id.editText);
        String phone=editText.getText().toString();
        String text="where are you";
        SmsManager manager=SmsManager.getDefault();
        manager.sendTextMessage(phone,null,text,null,null);
        Toast.makeText(getApplicationContext(), "发送成功", Toast.LENGTH_SHORT).show();
    }
}
