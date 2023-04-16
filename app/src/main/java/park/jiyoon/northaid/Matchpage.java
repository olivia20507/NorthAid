package park.jiyoon.northaid;

import android.content.Context;
import android.content.Intent;
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

public class Matchpage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ListView listview;
    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matchpage);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.match_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter2);
        spinner.setOnItemSelectedListener(this);


        listview = findViewById(R.id.listView4);

    }
    public class ListViewAdapter extends BaseAdapter {
        ArrayList<Item> items = new ArrayList<Item>();

        public void addItem(Item item) {
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
            final Item item = items.get(position);

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
                    Intent it = new Intent(Matchpage.this, Matchdetail.class);
                    startActivity(it);
                }
            });

            return convertView;  //뷰 객체 반환
        }
    }

    // onCreate 바깥쪽
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                adapter = new ListViewAdapter();

                //Adapter 안에 아이템의 정보 담기
                adapter.addItem(new Item("middle\nschool", "홍길동"));
                adapter.addItem(new Item("high\nschool", "이몽룡"));
                adapter.addItem(new Item("basic\nclass", "윤동주"));

                //리스트뷰에 Adapter 설정
                listview.setAdapter(adapter);
                break;
            case 1:
                adapter = new ListViewAdapter();

                //Adapter 안에 아이템의 정보 담기
                adapter.addItem(new Item("middle\nschool", "a"));
                adapter.addItem(new Item("high\nschool", "b"));
                adapter.addItem(new Item("basic\nclass", "c"));

                //리스트뷰에 Adapter 설정
                listview.setAdapter(adapter);
                break;
            case 2:
                adapter = new ListViewAdapter();

                //Adapter 안에 아이템의 정보 담기
                adapter.addItem(new Item("middle\nschool", "d"));
                adapter.addItem(new Item("high\nschool", "e"));
                adapter.addItem(new Item("basic\nclass", "f"));

                //리스트뷰에 Adapter 설정
                listview.setAdapter(adapter);
                break;
            case 3:
                adapter = new ListViewAdapter();

                //Adapter 안에 아이템의 정보 담기
                adapter.addItem(new Item("middle\nschool", "g"));
                adapter.addItem(new Item("high\nschool", "h"));
                adapter.addItem(new Item("basic\nclass", "i"));

                //리스트뷰에 Adapter 설정
                listview.setAdapter(adapter);
                break;
            case 4:
                adapter = new ListViewAdapter();

                //Adapter 안에 아이템의 정보 담기
                adapter.addItem(new Item("middle\nschool", "j"));
                adapter.addItem(new Item("high\nschool", "k"));
                adapter.addItem(new Item("basic\nclass", "l"));

                //리스트뷰에 Adapter 설정
                listview.setAdapter(adapter);
                break;
            case 5:
                adapter = new ListViewAdapter();

                //Adapter 안에 아이템의 정보 담기
                adapter.addItem(new Item("middle\nschool", "m"));
                adapter.addItem(new Item("high\nschool", "n"));
                adapter.addItem(new Item("basic\nclass", "o"));

                //리스트뷰에 Adapter 설정
                listview.setAdapter(adapter);
                break;
            case 6:
                adapter = new ListViewAdapter();

                //Adapter 안에 아이템의 정보 담기
                adapter.addItem(new Item("middle\nschool", "p"));
                adapter.addItem(new Item("high\nschool", "q"));
                adapter.addItem(new Item("basic\nclass", "r"));

                //리스트뷰에 Adapter 설정
                listview.setAdapter(adapter);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}