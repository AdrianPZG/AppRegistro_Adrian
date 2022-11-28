package com.example.appregistro_adrianpg.MyAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appregistro_adrianpg.JSON.MyData;
import com.example.appregistro_adrianpg.R;

import java.io.Serializable;
import java.util.List;

public class MyAdapter extends BaseAdapter implements Serializable {
    private List<MyData> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public MyAdapter(List<MyData> list, Context context){
        this.list = list;
        this.context = context;
        if(context != null){
            layoutInflater = LayoutInflater.from(context);
        }
    }
    public boolean isEmptyOrNull(){

        return list == null || list.size() == 0;
    }

    @Override
    public int getCount()
    {
        if(isEmptyOrNull())
        {
            return 0;
        }
        return list.size();
    }

    @Override
    public Object getItem(int i){
        if(isEmptyOrNull())
        {
            return null;
        }
        return list.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        EditText editText1 = null;
        EditText editText2 = null;
        EditText editText3 = null;
        Button button1 = null;
        Button button2 = null;
        Button button3 = null;
        view = layoutInflater.inflate(R.layout.activity_list_view, null);
        editText1 =view.findViewById(R.id.editText1);
        editText1.setText(list.get(i).getPassRed());
        editText2 =view.findViewById(R.id.editText2);
        editText2.setText(list.get(i).getPassRed());
        editText3 =view.findViewById(R.id.editText3);
        editText3.setText(list.get(i).getPassRed());
        button1 =view.findViewById(R.id.uno);
        button1.setText(list.get(i).getPassRed());
        button2 =view.findViewById(R.id.dos);
        button2.setText(list.get(i).getPassRed());
        button3 =view.findViewById(R.id.tres);
        button3.setText(list.get(i).getPassRed());

        return view;
    }
}
