package com.vishal.learningjava;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Utils {
	
	public static byte[] getimg_bytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }
 
    public static Bitmap getimg(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
 
    public static byte[] getbytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
 
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }
 
}
