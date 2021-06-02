package com.example.listview_click_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ContactModel> listContact = new ArrayList<>();
    private ListView lvContact;
    private ContactAdapter mAdapter;
    private ImageView ivUser;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();

        mAdapter = new ContactAdapter(this,listContact);
        mAdapter.registerChildItemClick(this);
        lvContact.setAdapter(mAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactModel model = listContact.get(i);
                Toast.makeText(MainActivity.this, model.getName() + ":" + model.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        lvContact = (ListView) findViewById(R.id.lvContact);
        ivUser = (ImageView) findViewById(R.id.ivUser);
        tvName = (TextView) findViewById(R.id.tvName);
    }

    private void initData() {
        listContact.add(new ContactModel("Trần Trường Sơn","0987654345", R.drawable.ic_user_a));
        listContact.add(new ContactModel("Trần Trường Giang","0987654345", R.drawable.ic_user_a));
        listContact.add(new ContactModel("Trần Trường Hi","0913434344", R.drawable.ic_user_a));
        listContact.add(new ContactModel("Trần Trang Sơn","0987654345", R.drawable.ic_user_a));
        listContact.add(new ContactModel("Trần Long Sơn","098765345", R.drawable.ic_user_a));
        listContact.add(new ContactModel("Trần Hai Sơn","0987654345", R.drawable.ic_user_a));
        listContact.add(new ContactModel("Trần Dat Sơn","0987654345", R.drawable.ic_user_a));
        listContact.add(new ContactModel("Nguyễn Sơn","0987654345", R.drawable.ic_user_a));

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mAdapter.unRegisterChildItemClick();
    }

    @Override
    public void onItemChildClick(int position){
        ContactModel contact = listContact.get(position);
        ivUser.setImageResource(contact.getImage());
        tvName.setText(contact.getName());
    }
}
