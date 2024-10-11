package com.example.simplemusic;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

    public class Recommend extends AppCompatActivity {
    private ListView mListView;
    private  String[] names={"Die For You ———— The Weeknd","Stayboy ———— The Weeknd","Young and beautiful ———— Lana Del Rey"};
    private int[] icons={R.drawable.music2,R.drawable.music3,R.drawable.music4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
        mListView=(ListView)findViewById(R.id.lv);
        mListView.setAdapter(new MyBaseAdapter());

    }
    class MyBaseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names [position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {//组装数据
            View view=View.inflate(Recommend.this,R.layout.item_layout,null);//在list_item中有两个id,现在要把他们拿过来
            TextView mTextView=(TextView) view.findViewById(R.id.item_name);
            ImageView imageView=(ImageView)view.findViewById(R.id.iv);
            //组件一拿到，开始组装
            mTextView.setText(names[position]);
            imageView.setBackgroundResource(icons[position]);
            //组装玩开始返回
            return view;
        }
    }
}