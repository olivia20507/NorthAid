package park.jiyoon.northaid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Playgame extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playgame);

        Button btn1 = findViewById(R.id.button2);
        Button btn2 = findViewById(R.id.button3);
        Button btn3 = findViewById(R.id.button4);


        ImageView img = findViewById(R.id.imageView4);

        final int[] cnt = {1, 0}; // cnt, score

        final String[][] multiples = {{"사과", "포도", "사자"},
                {"사과", "포도", "병"},
                {"물티슈", "사자", "병"},
                {"달력", "신문", "사자"},
                {"책", "포도", "사진"},
                {"컴퓨터", "병", "사자"},
                {"책", "포도", "사자"},
                {"사과", "달력", "병"},
                {"책", "달력", "컴퓨터"},
                {"달력", "컴퓨터", "물티슈"}};
        final String[][] answers = {{"사과", "apple"},
                {"포도", "grapes"},
                {"사자", "lion"},
                {"신문", "news"},
                {"사진", "photo"},
                {"병", "bottle"},
                {"책", "book"},
                {"달력", "calendar"},
                {"컴퓨터", "computer"},
                {"물티슈", "watertissue"}};

        Button button = findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt[0] == 10) {
                    Intent it = new Intent(Playgame.this, Finalscore.class);
                    it.putExtra("score", cnt[1]);
                    startActivity(it);
                }
                else {
                    cnt[0] = cnt[0] + 1;

                    int resId = getResources().getIdentifier(answers[cnt[0]-1][1], "drawable", "park.jiyoon.northaid");
                    img.setImageResource(resId);

                    btn1.setText(multiples[cnt[0]-1][0]);
                    btn2.setText(multiples[cnt[0]-1][1]);
                    btn3.setText(multiples[cnt[0]-1][2]);


                    btn1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.oggreen));
                    btn2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.oggreen));
                    btn3.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.oggreen));

                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.lighterog));
                if (btn1.getText().toString() == answers[cnt[0]-1][0]){
                    cnt[1] += 1;
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.lighterog));
                if (btn2.getText().toString() == answers[cnt[0]-1][0]){
                    cnt[1] += 1;
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.lighterog));
                if (btn3.getText().toString() == answers[cnt[0]-1][0]){
                    cnt[1] += 1;
                }
            }
        });
    }
}