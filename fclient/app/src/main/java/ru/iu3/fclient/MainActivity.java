package ru.iu3.fclient;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("mbedcrypto");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnClickMe);
        btn.setOnClickListener((View v) -> { onButtonClick(v);});

        int res = initRng();
        Log.i("fclient", "Init Rng = " + res);
//        byte[] rnd = randomBytes(16);
//        byte[] data = {'a', 'b', 'c', 'd', '1', '2', '3', '4'};
//        byte[] encrypted = encrypt(rnd, data);
//        byte[] decrypted = decrypt(rnd, encrypted);
//        String originalData = new String(data, StandardCharsets.UTF_8);
//        String encryptedData = new String(encrypted, StandardCharsets.UTF_8);
//        String decryptedData = new String(decrypted, StandardCharsets.UTF_8);

    }

    public static byte[] StringToHex(String s) {
        byte[] hex;
        try {
            hex = Hex.decodeHex(s.toCharArray());
        }
        catch (DecoderException ex) {
            hex = null;
        }
        return hex;
    }

    protected void onButtonClick(View v) {
//        Toast.makeText(this, stringFromJNI(), Toast.LENGTH_SHORT).show();
//        byte[] key = randomBytes(16);
//        byte[] data = {5, 3, 4, 7, 8, 9, 3};
//        System.out.println(data);
//        byte[] enc = encrypt(key, data);
//        byte[] dec = decrypt(key, enc);
//        String s = new String(Hex.encodeHex(dec)).toUpperCase();
//        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        Intent it = new Intent(this, PinPadActivity.class);
        startActivityForResult(it, 0);
    }
//    protected void TestHttpCLient(){
//        new Thread(()->{
//            try {
//
//            } catch (Exception ex) {
//                Log.e("fapptag", "Http Client Fails", ex);
//            }
//        }).start();
//    }


    public native String stringFromJNI();
    public static native int initRng();
    public static native byte[] randomBytes(int no);
    public static native byte[] encrypt(byte[] key, byte[] data);
    public static native byte[] decrypt(byte[] key, byte[] data);

}