package park.jiyoon.northaid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Mainpage extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    private Toolbar toolbar;
    private NavigationView navigationView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        ListView listview = findViewById(R.id.listView);
        ListViewAdapter adapter = new ListViewAdapter();

        //Adapter 안에 아이템의 정보 담기
        adapter.addItem(new SupportItem("medical", "[서울아산병원] 2023 희망나누기 캠페인 수술치료비 지원사업 안내(연중상시)", "http://m.naver.com"));
        adapter.addItem(new SupportItem("education", "[북한인권시민연합] 반딧불이 멘토링 참가 탈북 청소년(멘티) 모집(~4.17)", ""));
        adapter.addItem(new SupportItem("education", "2023학년도 특별전형 입시 자료집 (일반대)", ""));
        adapter.addItem(new SupportItem("medical", "남북하나재단 의료지원", ""));
        adapter.addItem(new SupportItem("life", "북한이탈주민정책: 정착지원제도:지원제도", ""));
        adapter.addItem(new SupportItem("education", "2023년 상반기 장학생 선발 공고(~4.25)", ""));

        //리스트뷰에 Adapter 설정
        listview.setAdapter(adapter);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_menu_24);
        getSupportActionBar().setTitle("");


        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item1:
                        item.setChecked(true);
                        Toast.makeText(getApplicationContext(), "Support selected", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        Intent it = new Intent(Mainpage.this, Supportview.class);
                        startActivity(it);
                        break;
                    case R.id.item2:
                        item.setChecked(true);
                        Toast.makeText(getApplicationContext(), "Class Matching selected", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        Intent it2 = new Intent(Mainpage.this, Matchpage.class);
                        startActivity(it2);
                        break;
                    case R.id.item3:
                        item.setChecked(true);
                        Toast.makeText(getApplicationContext(), "Word Game selected", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        Intent it3 = new Intent(Mainpage.this, Langgame.class);
                        startActivity(it3);
                        break;
                    case R.id.item4:
                        item.setChecked(true);
                        Toast.makeText(getApplicationContext(), "About us selected", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        Intent it4 = new Intent(Mainpage.this, Aboutus.class);
                        startActivity(it4);
                        break;
                }
                item.setChecked(false);
                return false;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public class ListViewAdapter extends BaseAdapter {
        ArrayList<SupportItem> items = new ArrayList<SupportItem>();

        public void addItem(SupportItem item) {
            items.add(item);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();
            final SupportItem item = items.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // listitem layout을 inflate 해준다.(memory에 올려준다)
            convertView = inflater.inflate(R.layout.listitemlayout, viewGroup, false);

            TextView tv_num = (TextView) convertView.findViewById(R.id.tv_num);
            TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);

            tv_num.setText(item.getNum());
            tv_name.setText(item.getName());

            //각 아이템 선택 event
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, item.getNum()+" "+item.getName()+" clicked!", Toast.LENGTH_SHORT).show();
                    Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getUrl()));
                    startActivity(it);
                }
            });

            return convertView;  //뷰 객체 반환
        }
    }
}
