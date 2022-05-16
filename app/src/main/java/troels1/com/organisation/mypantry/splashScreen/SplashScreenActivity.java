package troels1.com.organisation.mypantry.splashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;

import androidx.appcompat.app.AppCompatActivity;

import troels1.com.organisation.mypantry.R;
import troels1.com.organisation.mypantry.mainListVIew.MenuActivity;


public class SplashScreenActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_splash_screen);
        super.onCreate(savedInstanceState);
        try {
            HandlerThread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
                Intent intent = new Intent(this, MenuActivity.class);

                startActivity(intent);

    }
}
