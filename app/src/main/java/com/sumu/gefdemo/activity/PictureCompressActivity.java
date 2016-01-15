package com.sumu.gefdemo.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sumu.gefdemo.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PictureCompressActivity extends AppCompatActivity {



    private String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_compress);
        TAG = getClass().getSimpleName();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.about);
        Log.e(TAG,"bitmap时的大小:" + bitmap.getByteCount());
        try {
            FileInputStream inputStream = (FileInputStream) getAssets().open("about.png");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void compressBmpToFile(Bitmap bmp, File file){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int options = 80;//个人喜欢从80开始,
        bmp.compress(Bitmap.CompressFormat.JPEG, options, baos);
        while (baos.toByteArray().length / 1024 > 100) {
            baos.reset();
            options -= 10;
            bmp.compress(Bitmap.CompressFormat.JPEG, options, baos);
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public byte [] compressBitmap(Bitmap bitmap,int max){
        int quality = 100;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,quality,byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length / 1024 > max){
            byteArrayOutputStream.reset();
            quality = quality -10;
            bitmap.compress(Bitmap.CompressFormat.JPEG,quality,byteArrayOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }
    public File saveToFile(byte [] content) throws Exception {
        File file = getCacheDir();
        File file2 = new File(file,"gefufeng");
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(content);
        fileOutputStream.flush();
        return file2;
    }
    public Bitmap saveToBitmap(byte [] content) throws Exception {
        return BitmapFactory.decodeByteArray(content,0,content.length);
    }
    public void compressForsize(Bitmap bitmap){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
    }
    private Bitmap getimage(String srcPath) {
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        //开始读入图片，此时把options.inJustDecodeBounds 设回true了
        newOpts.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath,newOpts);//此时返回bm为空

        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        //现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
        float hh = 800f;//这里设置高度为800f
        float ww = 480f;//这里设置宽度为480f
        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;//be=1表示不缩放
        if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放
            be = (int) (newOpts.outHeight / hh);
        }
        if (be <= 0)
            be = 1;
        newOpts.inSampleSize = be;//设置缩放比例
        //重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
        return bitmap;
    }

}
