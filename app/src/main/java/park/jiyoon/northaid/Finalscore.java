package park.jiyoon.northaid;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Finalscore extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalscore);

        TextView tv = findViewById(R.id.textView9);
        int score = getIntent().getIntExtra("score", 0)/10*100;
        tv.setText(score+"%");
    }
}