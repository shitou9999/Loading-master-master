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

    //网络访问会延时，一半的网络访问缓存是按照时间计算的，比如在规定的时间内只会拿缓存，
    //如果超过规定的时间才会向后台发起请求。如果要确保获取的数据是及时的就最好不用第三方的自带缓存。

    //每次都会请求数据，先去拿本地缓存，如果本地有先显示，然后获取到后台返回数据后，如果数据一样
    //则不刷新界面，如果不一致刷新界面，加入缓存。







}
