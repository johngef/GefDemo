package com.sumu.gefdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sumu.gefdemo.R;

import java.util.ArrayList;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    private ArrayList<String> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        /**
         * 三种LayoutManager
         */
        //1
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //2.
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        //3.
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        //设置layoutmanager
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        Random random = new Random();

        for (int i = 0;i < 100;i++){
            random.nextInt();
            arrayList.add(i + "gefufeng" + random.nextInt(10000000));
        }
        myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
    }
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(parent.getContext(),R.layout.myview,null);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.content.setText(arrayList.get(position));

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder{

            private TextView content;
            public ViewHolder(View itemView) {
                super(itemView);
                content = (TextView) ((FrameLayout) itemView).getChildAt(0);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,1,"add");
        menu.add(Menu.NONE,2,2,"delete");
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1){
            arrayList.add(1,"gefufenggefufenggefufenggefufenggefufeng");
            myAdapter.notifyItemInserted(1);
        }else{
            arrayList.remove(2);
            myAdapter.notifyItemRemoved(2);
        }
        return super.onOptionsItemSelected(item);
    }
}
