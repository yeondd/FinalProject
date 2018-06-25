package com.example.random;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class selectRandom extends AppCompatActivity implements ListViewAdapter.ListBtnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_random);

        // id가져오기
        final ListView listview = (ListView) findViewById(R.id.listView1);
        ListView listview2 = (ListView) findViewById(R.id.listView2);
        Button start = (Button) findViewById(R.id.startSelect);
        Button refresh = (Button) findViewById(R.id.refresh);

        // 이미지 가져오기 위해서 필요함
        Resources res = getResources();

////////////////////////////////////////////////////////////////////////////
        // 원래 리스트 - 랜덤에 포함될 음식점 리스트(item, adapter)
        ArrayList<ListViewItem> item = new ArrayList<ListViewItem>();

        ListViewItem temp = new ListViewItem(res.getDrawable(R.drawable.icon01),"노는게", "제일좋아","www.aaa.com");
        item.add(temp);

        temp = new ListViewItem(res.getDrawable(R.drawable.icon02),"친구들", "모여라","www.bbb.com");
        item.add(temp);

        // 어댑터 만들기
        final ListViewAdapter adapter = new ListViewAdapter(this, R.layout.list_item, item, this);

        // 어댑터 연결
        listview.setAdapter(adapter);

////////////////////////////////////////////////////////////////////////////
        // 랜덤에서 제외할 음식점 리스트(item2, adapter2)
        ArrayList<ListViewItem> item2 = new ArrayList<ListViewItem>();

        ListViewItem temp2 = new ListViewItem(res.getDrawable(R.drawable.icon01),"노는게", "제일좋아","www.aaa.com");
        item2.add(temp2);

        temp2 = new ListViewItem(res.getDrawable(R.drawable.icon02),"친구들", "모여라","www.bbb.com");
        item2.add(temp);

        ListViewAdapter adapter2 = new ListViewAdapter(this, R.layout.list_item, item, this);
        listview2.setAdapter(adapter2);

        // 랜덤 실행으로 이동
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
        ListView listview = (ListView) findViewById(R.id.listView1);
        View parentView = (View)v.getParent();
        String p = (String) parentView.getTag();

        Button b = (Button) v;
        String buttonText = b.getText().toString();
/*
        if(buttonText.equals("+")) {
            Toast.makeText(this, "plus 선택됨", Toast.LENGTH_LONG).show();
        }
        else if(buttonText.equals("-")) {
            int check = listview.getCheckedItemPosition();
            Toast.makeText(this, p + ": minus 선택됨", Toast.LENGTH_LONG).show();

        }
        else
            Toast.makeText(this, "뭐가 선택된거지...? -> " + buttonText , Toast.LENGTH_LONG).show();
            */
    }
}
