package com.example.random;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.List;

public class normalRandom extends AppCompatActivity implements ListViewAdapter.ListBtnClickListener {
    ListViewAdapter adapter;
    ListViewAdapter adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_random);

        // id가져오기
        ListView listview = (ListView) findViewById(R.id.listView1);
        ListView listview2 = (ListView) findViewById(R.id.listView2);
        Button start = (Button) findViewById(R.id.start);
        Button refresh = (Button) findViewById(R.id.refresh);

        ArrayList<ListViewItem> item = new ArrayList<ListViewItem>();

        // 이미지 가져오기 위해서 필요함
        Resources res = getResources();

        ListViewItem temp = new ListViewItem(res.getDrawable(R.drawable.icon01),"노는게", "제일좋아","www.aaa.com");
        item.add(temp);

        temp = new ListViewItem(res.getDrawable(R.drawable.icon02),"친구들", "모여라","www.bbb.com");
        item.add(temp);

        temp = new ListViewItem(res.getDrawable(R.drawable.icon02),"친구들", "모여라","www.bbb.com");
        item.add(temp);

        temp = new ListViewItem(res.getDrawable(R.drawable.icon02),"친구들", "모여라","www.bbb.com");
        item.add(temp);

        temp = new ListViewItem(res.getDrawable(R.drawable.icon02),"친구들", "모여라","www.bbb.com");
        item.add(temp);

        temp = new ListViewItem(res.getDrawable(R.drawable.icon02),"친구들", "모여라","www.bbb.com");
        item.add(temp);

        temp = new ListViewItem(res.getDrawable(R.drawable.icon02),"친구들", "모여라","www.bbb.com");
        item.add(temp);

        // 어댑터 만들기
        adapter = new ListViewAdapter(this, R.layout.list_item, item, this);

        // 리스트 요소 추가하기
//        adapter.addItem(new ListViewItem(res.getDrawable(R.drawable.icon01),"노는게", "제일좋아","www.aaa.com"));
//        adapter.addItem(new ListViewItem(res.getDrawable(R.drawable.icon02),"친구들", "모여라","www.bbb.com"));

        // 어댑터 연결
        listview.setAdapter(adapter);
////////////////////////////////////////////////////////////////////////////
        ArrayList<ListViewItem> item2 = new ArrayList<ListViewItem>();
        ListViewItem temp2 = new ListViewItem(res.getDrawable(R.drawable.icon01),"노는게", "제일좋아","www.aaa.com");
        item2.add(temp2);

        temp2 = new ListViewItem(res.getDrawable(R.drawable.icon02),"친구들", "모여라","www.bbb.com");
        item2.add(temp);

        adapter2 = new ListViewAdapter(this, R.layout.list_item, item, this);
        listview2.setAdapter(adapter2);

        /*
        ListViewAdapter adapter2 = new ListViewAdapter(this, R.layout.list_item, item, this);
        adapter2.addItem(new ListViewItem(res.getDrawable(R.drawable.icon01),"노는게", "제일좋아","www.aaa.com"));
        adapter2.addItem(new ListViewItem(res.getDrawable(R.drawable.icon02),"친구들", "모여라","www.bbb.com"));
        listview2.setAdapter(adapter2);
        */



        // 돌림판 화면으로 이동
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), randomExecute.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onListBtnClick(int position, View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();


        if(buttonText.equals("+")) {
            Toast.makeText(this, "plus 선택됨", Toast.LENGTH_LONG).show();
        }
        else if(buttonText.equals("-")) {
            Toast.makeText(this, "minus 선택됨", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this, "뭐가 선택된거람...? -> " + buttonText , Toast.LENGTH_LONG).show();
    }
}