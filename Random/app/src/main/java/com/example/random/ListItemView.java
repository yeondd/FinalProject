package com.example.random;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 수연 on 2018-05-17.
 */

public class ListItemView extends LinearLayout implements View.OnClickListener  {
    private ImageView mIcon;
    private TextView restaurant;
    private TextView address;
    private TextView url;
    private Button plus;
    private Button minus;

    public interface ListBtnClickListener {
        void onListBtnClick(int position) ;
    }

    private ListBtnClickListener listBtnClickListener;

    public ListItemView(Context context, ListViewItem aItem) {
        super(context);

        //보일 해당 listView에 들어갈 디자인 레이아웃 xml 설정(만들어진 listitem.xml을 보일 디자인 레이아웃으로 설정하였음)
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.list_item, this, true);

        //각 변수를 설정하고 그 변수가 어떤 값을 의미하는지 또, 무엇을 읽어오고 보여주는지를 설정
        mIcon = (ImageView) findViewById(R.id.iconItem);
        mIcon.setImageDrawable(aItem.getIcon());

        restaurant = (TextView) findViewById(R.id.restaurantName);
        restaurant.setText(aItem.getData(0));

        address = (TextView) findViewById(R.id.address);
        address.setText(aItem.getData(1));

        url = (TextView) findViewById(R.id.url);
        url.setText(aItem.getData(2));

        plus = (Button) findViewById(R.id.plus);
        plus.setOnClickListener(this);

        minus = (Button) findViewById(R.id.minus);
        //minus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        /*
        if(this.listBtnClickListener != null){
            this.listBtnClickListener.onListBtnClick(view.);
        }
        */
        Log.d("plus", "버튼 눌림");
    }

    //위에 방법과 구성은 동일한 방법이지만 조건 문과 파라메타 값으로 자동적으로 셋팅을 해주는것
    //파라메타로 Adapter 자바에서 설정된 int형 index 값과 String형 데이터 값을 가져와서 위처럼 변수를 자동으로 설정해줌
    public void setText(int index, String data){
        if (index == 0 ){
            restaurant.setText(data);
        } else if (index == 1){
            address.setText(data);
        } else if (index == 2){
            url.setText(data);
        } else {
            throw new IllegalArgumentException();
        }
    }

   public void setIcon(Drawable icon){
        mIcon.setImageDrawable(icon);
    }

    public ListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ListItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

}