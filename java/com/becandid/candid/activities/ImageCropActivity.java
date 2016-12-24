/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.BitmapFactory
 *  android.graphics.Matrix
 *  android.media.ExifInterface
 *  android.os.Bundle
 *  android.os.Environment
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.thirdparty.nocropper.CropperView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImageCropActivity
extends BaseActivity {
    public static String ASPECT_X;
    public static String ASPECT_Y;
    public static String IMAGE_PATH;
    public static String USE_FULL_IMAGE;
    private boolean b = false;
    private Bitmap c;
    private Handler d;
    private int e = 5;
    private int f = 6;
    private String g;
    @BindView(value=2131624190)
    ImageView mCropButton;
    @BindView(value=2131624187)
    RelativeLayout mCropContainer;
    @BindView(value=2131624188)
    FrameLayout mCropperFrameLayout;
    @BindView(value=2131624189)
    CropperView mImageView;
    @BindView(value=2131624191)
    ProgressBar mProgressBar;

    static {
        IMAGE_PATH = "image_path";
        USE_FULL_IMAGE = "use_full_image";
        ASPECT_X = "aspectX";
        ASPECT_Y = "aspectY";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Matrix a(Bitmap bitmap, float f2, String string2) {
        int n2 = (int)((float)bitmap.getWidth() / f2);
        int n3 = (int)((float)bitmap.getHeight() / f2);
        Matrix matrix = new Matrix();
        matrix.postRotate(0.0f);
        matrix.postScale((float)n2 / (float)bitmap.getWidth(), (float)n3 / (float)bitmap.getHeight());
        try {
            int n4 = new ExifInterface(string2).getAttributeInt("Orientation", 0);
            if (n4 == 6) {
                matrix.postRotate(90.0f);
                return matrix;
            }
            if (n4 == 3) {
                matrix.postRotate(180.0f);
                return matrix;
            }
            if (n4 != 8) return matrix;
            {
                matrix.postRotate(270.0f);
                return matrix;
            }
        }
        catch (IOException var9_8) {
            var9_8.printStackTrace();
            return matrix;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a() {
        Intent intent = new Intent();
        intent.putExtra(USE_FULL_IMAGE, false);
        Bitmap bitmap = this.mImageView.getCroppedBitmap();
        if (bitmap != null) {
            try {
                String string2 = (Object)Environment.getExternalStorageDirectory() + "/crop_test.jpg";
                this.a(bitmap, new File(string2), 100);
                intent.putExtra(IMAGE_PATH, string2);
                intent.putExtra(ASPECT_X, bitmap.getWidth());
                intent.putExtra(ASPECT_Y, bitmap.getHeight());
                this.setResult(-1, intent);
                jb.b(string2, new ExifInterface(string2).getAttributeInt("Orientation", 1));
            }
            catch (Exception var4_4) {
                Toast.makeText((Context)this, (CharSequence)"Error while processing photo...", (int)0).show();
                this.setResult(0);
            }
        } else {
            Toast.makeText((Context)this, (CharSequence)"Error while processing photo...", (int)0).show();
            this.setResult(0);
        }
        bitmap.recycle();
        this.finish();
    }

    private void a(int n2, int n3) {
        TypedArray typedArray = this.getTheme().obtainStyledAttributes(new int[]{16843499});
        (int)typedArray.getDimension(0, 0.0f);
        typedArray.recycle();
        int n4 = (int)(0.5 + (double)(((float)(n3 - this.mCropperFrameLayout.getHeight()) - (float)this.mCropButton.getHeight()) / 2.0f));
        if (n4 > 0) {
            ((RelativeLayout.LayoutParams)this.mCropButton.getLayoutParams()).setMargins(0, 0, 0, n4);
        }
        this.mCropContainer.requestLayout();
    }

    private void a(Bitmap bitmap, File file, int n2) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.JPEG, n2, (OutputStream)fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String string2) {
        try {
            this.c = BitmapFactory.decodeFile((String)string2);
            float f2 = (float)Math.max((int)this.c.getWidth(), (int)this.c.getHeight()) / 1280.0f;
            if (this.mImageView.getWidth() != 0) {
                this.mImageView.setMaxZoom((float)(2 * this.mImageView.getWidth()) / 1280.0f);
            } else {
                this.mImageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(){

                    public boolean onPreDraw() {
                        ImageCropActivity.this.mImageView.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
                        ImageCropActivity.this.mImageView.setMaxZoom((float)(2 * ImageCropActivity.this.mImageView.getWidth()) / 1280.0f);
                        return true;
                    }
                });
            }
            Matrix matrix = super.a(this.c, f2, string2);
            this.c = Bitmap.createBitmap((Bitmap)this.c, (int)0, (int)0, (int)this.c.getWidth(), (int)this.c.getHeight(), (Matrix)matrix, (boolean)true);
            this.runOnUiThread(new Runnable(){

                public void run() {
                    ImageCropActivity.this.mImageView.setImageBitmap(ImageCropActivity.this.c);
                    ImageCropActivity.this.mProgressBar.setVisibility(8);
                }
            });
            return;
        }
        catch (Exception var2_4) {
            this.runOnUiThread(new Runnable(){

                public void run() {
                    Toast.makeText((Context)ImageCropActivity.this, (CharSequence)"Could not process the image...  Please try again.", (int)0).show();
                    ImageCropActivity.this.finish();
                }
            });
            return;
        }
    }

    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968614);
        ButterKnife.bind((Activity)this);
        this.d = new Handler(this.getMainLooper());
        this.e = this.getIntent().getIntExtra(ASPECT_X, 1);
        this.f = this.getIntent().getIntExtra(ASPECT_Y, 1);
        this.g = this.getIntent().getStringExtra(IMAGE_PATH);
        this.mProgressBar.setVisibility(0);
        this.mCropButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                ImageCropActivity.this.a();
            }
        });
        this.mCropContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){

            public void onGlobalLayout() {
                ImageCropActivity.this.mCropContainer.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                ImageCropActivity.this.a(ImageCropActivity.this.mCropContainer.getWidth(), ImageCropActivity.this.mCropContainer.getHeight());
                ImageCropActivity.this.d.post(new Runnable(){

                    public void run() {
                        ImageCropActivity.this.a(ImageCropActivity.this.g);
                    }
                });
            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}

