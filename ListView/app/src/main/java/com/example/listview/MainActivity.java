package com.example.listview;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView1;
    IcontextListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //리스트 뷰의 아이디 값을 찾아서 불러온 후 변수에 담아준다
        listView1 = (ListView)findViewById(R.id.listView);

        //어댑터를 생성한다
        adapter = new IcontextListAdapter(this);

        //res 폴더 안에 필요한 무엇을 가져오기 위해서는 선언해줘야 됨
        Resources res = getResources();

        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon01),"추억의 테트리스", "30,000 다운로드","900 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon02),"고스톱 - 강호동 버전", "26,000 다운로드","1500 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon03),"추억의 테트리스", "30,000 다운로드","900 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon04),"고스톱 - 강호동 버전", "26,000 다운로드","1500 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05),"추억의 테트리스", "30,000 다운로드","900 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon06),"고스톱 - 강호동 버전", "26,000 다운로드","1500 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon01), "추억의 테트리스", "30,000 다운로드", "900 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon02), "고스톱 - 강호동 버전", "26,000 다운로드", "1500 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon03),"추억의 테트리스", "30,000 다운로드","900 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon04),"고스톱 - 강호동 버전", "26,000 다운로드","1500 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon01),"추억의 테트리스", "30,000 다운로드","900 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon02),"고스톱 - 강호동 버전", "26,000 다운로드","1500 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon03),"추억의 테트리스", "30,000 다운로드","900 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon04),"고스톱 - 강호동 버전", "26,000 다운로드","1500 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon05),"추억의 테트리스", "30,000 다운로드","900 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon06),"고스톱 - 강호동 버전", "26,000 다운로드","1500 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon01),"추억의 테트리스", "30,000 다운로드","900 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon02),"고스톱 - 강호동 버전", "26,000 다운로드","1500 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon03),"추억의 테트리스", "30,000 다운로드","900 원"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.icon04),"고스톱 - 강호동 버전", "26,000 다운로드","1500 원"));

        //리스트 뷰에 어댑터를 셋팅 함
        listView1.setAdapter(adapter);

        //리스트 뷰를 클릭하면 해당 위치값을 받아와서 그 위치값의 Data를 읽어와서 curData에 저장한 후 Toast로 보여줌
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IconTextItem curItem = (IconTextItem) adapter.getItem(position);

                //총 3개의 값을 가져오기 때문에 첫 번째 제목을 보여주기 위해선 배열 0번째의 값을 나타내주면 됨
                String[] curData=curItem.getData();

                //String temp = curItem.getData(0); 이렇게 써도 무관함 똑같은 의미를 지님
                Toast.makeText(getApplicationContext(), "Selected : " + curData[0], Toast.LENGTH_LONG).show();
            }
        });
    }
}
