package com.example.app.loading;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.app.loading.db.DaoSupportFactory;
import com.example.app.loading.db.IDaoSupport;
import com.example.app.loading.db.Person;
import com.example.app.loading.dialog.AlertDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        startService(new Intent(this, MessageService.class));
        startService(new Intent(this, GuardService.class));

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            startService(new Intent(this, JobAwakenService.class));
        }*/

        IDaoSupport<Person> daoSupport = DaoSupportFactory.getFactory().getDaoSupport(Person.class);
        // 插入数据对象
//        daoSupport.insert(new Person("Darren", 23));


    }

    public void test(View view){
        final AlertDialog dialog=new AlertDialog.Builder(this)
                .setContentView(R.layout.test_dialog_layout)
                .fromBottom(true).show();
        //dialog操作点击事件 特有操作对象listview recylerview checkbox---->dialog.getView()
        dialog.setOnClickListener(R.id.button, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setText(R.id.button,"改变了字体");
            }
        });
        //弹出软件盘网上有
    }






}
