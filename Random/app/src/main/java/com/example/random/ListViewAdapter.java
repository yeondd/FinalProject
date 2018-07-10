package com.example.random;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 수연 on 2018-05-16.
 */

public class ListViewAdapter extends ArrayAdapter implements View.OnClickListener{
    private ImageView mIcon;
    private TextView restaurant;
    private TextView address;
    private TextView url;
    private Button plus;
    private Button minus;

    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    public interface ListBtnClickListener {
        void onListBtnClick(int position, View v) ;}

    // 생성자로부터 전달된 resource id 값을 저장.
    int resourceId ;
    // 생성자로부터 전달된 ListBtnClickListener  저장.
    private ListBtnClickListener listBtnClickListener ;

    // ListViewBtnAdapter 생성자. 마지막에 ListBtnClickListener 추가.
    ListViewAdapter(Context context, int resource, ArrayList<ListViewItem> list, ListBtnClickListener clickListener) {
        super(context, resource, list) ;
        // resource id 값 복사. (super로 전달된 resource를 참조할 방법이 없음.)
        this.resourceId = resource ;
        this.listBtnClickListener = clickListener ;
    }
/*
    public Object getItem(int position){
        return items.get(position);
    }
*/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position ;
        final Context context = parent.getContext();
        final ListViewItem listViewItem = (ListViewItem) getItem(position);

        // 생성자로부터 저장된 resourceId(listview_btn_item)에 해당하는 Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.resourceId/*R.layout.listview_btn_item*/, parent, false);
        }
        //각 변수를 설정하고 그 변수가 어떤 값을 의미하는지 또, 무엇을 읽어오고 보여주는지를 설정
        mIcon = (ImageView) convertView.findViewById(R.id.iconItem);
        mIcon.setImageDrawable(listViewItem.getIcon());

        restaurant = (TextView) convertView.findViewById(R.id.restaurantName);
        restaurant.setText(listViewItem.getData(0));

        address = (TextView) convertView.findViewById(R.id.address);
        address.setText(listViewItem.getData(1));

        url = (TextView) convertView.findViewById(R.id.url);
        url.setText(listViewItem.getData(2));

        plus = (Button) convertView.findViewById(R.id.plus);
        plus.setTag(position);
        //plus.setOnClickListener(this);

        minus = (Button) convertView.findViewById(R.id.minus);
        minus.setTag(position);
        //minus.setOnClickListener(this);

        convertView.setTag(position);

        return convertView;
    }
    @Override
    public void onClick(View view) {
        if (this.listBtnClickListener != null) {
            this.listBtnClickListener.onListBtnClick((int)view.getTag(), view) ;
        }
    }

    public void addItem(Drawable icon, String title, String desc) {
        ListViewItem item = new ListViewItem();

        String[] contexts = new String[3];
        contexts[0] = title;
        contexts[1] = desc;
        contexts[2] = "";

        item.setIcon(icon);
        item.setData(contexts);

        listViewItemList.add(item);
    }
}
/*
    private Context mContext;
    private List<ListViewItem> mItems = new ArrayList<ListViewItem>();
    int resourceId;

    public ListViewAdapter(Context context, int resource, ArrayList<ListViewItem> list) {
        super(context, resource, list);
        this.resourceId = resource;
        mContext = context;
    }

    public void addItem(ListViewItem it) {
        mItems.add(it);
    }

    public void setListItems(List<ListViewItem> lit) {
        mItems = lit;
    }

    public int getCount() {
        return mItems.size();
    }

    public Object getItem(int position) {
        return mItems.get(position);
    }

    public boolean areAllItemsSelectable() {
        return false;
    }

    public boolean isSelectable(int position) {
        try {
            return mItems.get(position).isSelectable();
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemView itemView;
        if (convertView == null) {
            itemView = new ListItemView(mContext, mItems.get(position));
        } else {
            itemView = (ListItemView) convertView;

            itemView.setIcon(mItems.get(position).getIcon());
            itemView.setText(0, mItems.get(position).getData(0));
            itemView.setText(1, mItems.get(position).getData(1));
            itemView.setText(2, mItems.get(position).getData(2));
        }

        return itemView;
    }
}
*/
