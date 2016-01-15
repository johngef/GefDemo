package com.sumu.gefdemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sumu.gefdemo.R;

import java.util.ArrayList;
import java.util.List;

public class ListviewActivity extends AppCompatActivity {
    private ListView listview;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        createData();
        initView();

    }
    private void initView(){
        listview = (ListView) findViewById(R.id.listview);

    }
    private void createData(){
        for (int i = 0;i < 10;i++){
            list.add("gefufeng" + i);
        }
    }
    public class MyAdapter extends ArrayAdapter{



        public MyAdapter(Context context, int resource, List objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            return super.getView(position, convertView, parent);
        }
    }

}
