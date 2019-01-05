package com.example.gamze.gelecegiyazanlar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Gamze on 11/17/2018.
 */

public class UserAdapter extends BaseAdapter {
    private List<User> userList;
    private LayoutInflater inflater;
    private Context context;

    public UserAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.userList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View resultView;
        resultView = inflater.inflate(R.layout.sonuc_item, null);
        TextView userName = ((TextView) resultView.findViewById(R.id.userName));
        TextView verilenCevap = ((TextView) resultView.findViewById(R.id.verilenCevap));

        User u = (User) getItem(i);
        userName.setText(u.getUsername());
        verilenCevap.setText(u.getOy());

        return resultView;
    }
}
