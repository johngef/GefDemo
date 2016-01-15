package com.sumu.gefdemo;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sumu.gefdemo.activity.AnimationActivity;
import com.sumu.gefdemo.activity.ListViewDemoActivity;
import com.sumu.gefdemo.activity.ListViewSingleChoiceActivity;
import com.sumu.gefdemo.activity.ListviewActivity;
import com.sumu.gefdemo.activity.PictureCompressActivity;
import com.sumu.gefdemo.activity.ScrollingActivity;
import com.sumu.gefdemo.activity.ViewActivity;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(),0);

            Log.e(getClass().getSimpleName(),"版本名: " + packageInfo.versionName );
            Log.e(getClass().getSimpleName(),"版本号：" + packageInfo.versionCode );
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void handlerTestClick(View view){
        startActivity(new Intent(this,HandlerTestActivity.class));
    }
    public void serviceTest(View view){
        startActivity(new Intent(this,ServiceActivity.class));
    }
    public void ScrollingActivity(View view){
        startActivity(new Intent(this,ScrollingActivity.class));
    }
    public void ListviewActivity(View view){
        startActivity(new Intent(this,ListViewDemoActivity.class));
    }
    public void Animation(View view){
        startActivity(new Intent(this,AnimationActivity.class));
    }
    public void PictureCompress(View view){
        startActivity(new Intent(this,PictureCompressActivity.class));
    }
    public void listviewActivity(View view){
        startActivity(new Intent(this,ListviewActivity.class));
    }
    public void singleChoice(View view){
        startActivity(new Intent(this,ListViewSingleChoiceActivity.class));
    }
    public void ViewActivity(View view){
        startActivity(new Intent(this,ViewActivity.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
