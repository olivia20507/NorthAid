package park.jiyoon.northaid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Langgame extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.langgame);

        ListView listview = findViewById(R.id.listView3);
        ListViewAdapter adapter = new ListViewAdapter();

        //Adapter 안에 아이템의 정보 담기
        adapter.addItem(new Item("1", "그림"));
        adapter.addItem(new Item("2", "택시"));
        adapter.addItem(new Item("3", "차"));
        adapter.addItem(new Item("4", "휴지"));
        adapter.addItem(new Item("5", "화장실"));
        adapter.addItem(new Item("6", "필통"));
        adapter.addItem(new Item("7", "연필"));
        adapter.addItem(new Item("8", "장 바구니"));
        adapter.addItem(new Item("9", "화장품"));
        adapter.addItem(new Item("10", "칫솔"));

        //리스트뷰에 Adapter 설정
        listview.setAdapter(adapter);
        Button Play = findViewById(R.id.play);
        Play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent it = new Intent(Langgame.this, Playgame.class);
                startActivity(it);
            }
        });
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
                }
            });

            return convertView;  //뷰 객체 반환
        }
    }
}