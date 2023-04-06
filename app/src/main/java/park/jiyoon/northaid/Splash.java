package park.jiyoon.northaid;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    public void onCreate(Bundle splash) {
        super.onCreate(splash);
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(Splash.this, Signin.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
