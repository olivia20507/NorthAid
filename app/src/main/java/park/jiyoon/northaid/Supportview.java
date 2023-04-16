package park.jiyoon.northaid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Supportview extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ListView listview;
    ListViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supportview);

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.support_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter2);
        spinner.setOnItemSelectedListener(this);

        listview = findViewById(R.id.listView2);

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                adapter = new ListViewAdapter();

                //Adapter 안에 아이템의 정보 담기
                adapter.addItem(new SupportItem("1", "[서울아산병원] 2023 희망나누기 캠페인 수술치료비 지원사업 안내(연중상시)", "https://www.koreahana.or.kr/home/kor/board.do?menuPos=60&act=detail&idx=17667"));
                adapter.addItem(new SupportItem("2", "남북하나재단 의료지원", "https://www.koreahana.or.kr/home/kor/contents.do?menuPos=8"));

                //리스트뷰에 Adapter 설정
                listview.setAdapter(adapter);
                break;
            case 1:
                adapter = new ListViewAdapter();

                //Adapter 안에 아이템의 정보 담기
                adapter.addItem(new SupportItem("1", "[북한인권시민연합] 반딧불이 멘토링 참가 탈북 청소년(멘티) 모집(~4.17)", "https://www.koreahana.or.kr/home/kor/board.do?menuPos=60&act=detail&idx=17663"));
                adapter.addItem(new SupportItem("2", "2023학년도 특별전형 입시 자료집 (일반대)", "https://unikorea.go.kr/unikorea/business/NKDefectorsPolicy/archive/?boardId=bbs_0000000000000012&mode=view&searchCondition=all&searchKeyword=&cntId=54186&category=&pageIdx=1"));
                adapter.addItem(new SupportItem("3", "2023년 상반기 장학생 선발 공고(~4.25)", "https://www.koreahana.or.kr/home/kor/board.do?menuPos=54&act=detail&idx=17633"));

                //리스트뷰에 Adapter 설정
                listview.setAdapter(adapter);
                break;
            case 2:
                adapter = new ListViewAdapter();

                //Adapter 안에 아이템의 정보 담기
                adapter.addItem(new SupportItem("1", "북한이탈주민정책: 정착지원제도:지원제도", "https://www.unikorea.go.kr/unikorea/business/NKDefectorsPolicy/settlement/System/"));

                //리스트뷰에 Adapter 설정
                listview.setAdapter(adapter);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}