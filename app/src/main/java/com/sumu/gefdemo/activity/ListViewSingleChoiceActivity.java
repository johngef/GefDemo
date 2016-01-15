package com.sumu.gefdemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.sumu.gefdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gefufeng on 16/1/15.
 */
public class ListViewSingleChoiceActivity extends AppCompatActivity{
    private ListView listview;
    private ArrayList<String> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlechoice);
        listview = (ListView) findViewById(R.id.listview);
        listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        for (int i = 0;i < 10;i++){
            arrayList.add("hahahahahahhahaha" + i);
        }
        listview.setAdapter(new MyAdapter(this,1,arrayList));


    }
    class MyAdapter extends ArrayAdapter<String>{

        public MyAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MyView myView = null;
            if (convertView == null){
                myView = new MyView(ListViewSingleChoiceActivity.this);
            }else{
                myView = (MyView) convertView;
            }
            myView.setText(getItem(position));
            return myView;
        }
    }
    class MyView extends FrameLayout implements Checkable{
        private TextView content;
        private CheckBox checkBox;

        public MyView(Context context) {
            super(context);
            View.inflate(context,R.layout.item_single_choice,this);
            content = (TextView) findViewById(R.id.content);
            checkBox = (CheckBox) findViewById(R.id.checkbox);
        }

        public void setText(String text) {
            content.setText(text);
        }
        @Override
        public void setChecked(boolean checked) {
            checkBox.setChecked(checked);
        }

        @Override
        public boolean isChecked() {
            return checkBox.isChecked();
        }

        @Override
        public void toggle() {
            checkBox.toggle();
        }
    }


}
