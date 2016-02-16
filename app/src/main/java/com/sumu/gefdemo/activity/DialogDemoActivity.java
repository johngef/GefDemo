package com.sumu.gefdemo.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.sumu.gefdemo.R;

public class DialogDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_demo);
    }
    public void dialog(View view){
        NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(this);
        niftyDialogBuilder.withTitle("你好").withMessage("你好吗").withDialogColor("#000000").show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Log.e("dialog", "onCreateDialog");
        return super.onCreateDialog(id);
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        Log.e("dialog", "onPrepareDialog");
        super.onPrepareDialog(id, dialog);
    }

}
