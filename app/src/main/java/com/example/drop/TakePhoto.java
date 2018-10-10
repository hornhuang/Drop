package com.example.drop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.print.PrinterId;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.Switch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TakePhoto extends AppCompatActivity {

    public static final int TAKE_POTHO=1;

    private ImageView imageView;

    private Button button;

    private Uri uri;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_take_photo);

        imageView=(ImageView)findViewById(R.id.picture);

        button=(Button)findViewById(R.id.take_photo);

        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                File outImage=new File(getExternalCacheDir(),"output_image.jpg");

                try{

                    if(outImage.exists())

                    {

                        outImage.delete();

                    }

                    outImage.createNewFile();

                }

                catch (IOException e)

                {

                    e.printStackTrace();

                }

                if(Build.VERSION.SDK_INT>=24)

                {

                    uri= FileProvider.getUriForFile(TakePhoto.this,"com.example.drop.fileprovider",outImage);

                }

                else

                {

                    uri=Uri.fromFile(outImage);

                }

                Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");

                intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);

                startActivityForResult(intent,TAKE_POTHO);

            }

        });

    }

    @Override

    protected void onActivityResult(int requestCode,int resultCode,Intent data)

    {

        switch (requestCode)

        {

            case TAKE_POTHO:

                if(resultCode==RESULT_OK)

                {

                    try{

                        Bitmap bitmap= BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));

                        imageView.setImageBitmap(bitmap);

                    }catch (FileNotFoundException e)

                    {

                        e.printStackTrace();

                    }

                }

                break;

            default:

                break;

        }

    }

}