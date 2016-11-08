package com.somnus.toolbar.androidcollapsingtoolbarlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.somnus.toolbar.androidcollapsingtoolbarlayout.bean.ParcelableBean;

/****
 *
 * ReadMe :
 *     安装插件姿势：Setting - >Plugins - >
 *   SelectorChapek ： 插件，按照不同状态(normal、pressed)的标准命名后，右键文件树Generate Android Selectors 就可以自动创建selector
 *
 *   GsonFormat ：见GonsFormatBean
 *   Android Parcelable Code Generator :Android中的序列化有两种方式，分别是实现Serializable接口和Parcelable接口，
 *   但在Android中是推荐使用Parcelable，只不过我们这种方式要比Serializable方式要繁琐，
 *  \
 *  LeakCanary:检测出内存泄露的问题  http://www.liaohuqiu.net/cn/posts/leak-canary-read-me/
 *
 *JsonOnlineViewer 可实现直接在android studio中调试接口数据，可以选择请求类型，自定义请求头及请求体，json数据格式化后展示
 *Android Drawable Importer
 * CodeGlance 可用于快速定位代码
 *
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView card_view;
    private CardView card_view_01;
    private CardView card_view_02;
    private CardView card_view_03;
    private CardView card_view_04;
    private CardView card_view_05;
    private CardView card_view_grid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        card_view = (CardView) findViewById(R.id.card_view);
        card_view.setOnClickListener(this);
        card_view_01 = (CardView) findViewById(R.id.card_view_01);
        card_view_01.setOnClickListener(this);
        card_view_02 = (CardView) findViewById(R.id.card_view_02);
        card_view_02.setOnClickListener(this);
        card_view_03 = (CardView) findViewById(R.id.card_view_03);
        card_view_03.setOnClickListener(this);
        card_view_04 = (CardView) findViewById(R.id.card_view_04);
        card_view_04.setOnClickListener(this);

        card_view_05 = (CardView) findViewById(R.id.card_view_05);
        card_view_05.setOnClickListener(this);

        card_view_grid = (CardView) findViewById(R.id.card_view_grid);
        card_view_grid.setOnClickListener(this);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                startActivity(new Intent(MainActivity.this, CollapsingToolbarLayoutActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.card_view:
              startActivity(new Intent(this,TabLayoutDemo.class));
              break;
          case R.id.card_view_01:
              startActivity(new Intent(this,RecyclerViewActivity.class));
              break;
          case R.id.card_view_grid:
              startActivity(new Intent(this,RecyclerViewGridActivity.class));
              break;
          case R.id.card_view_02:
              startActivity(new Intent(this,MaterialDesignActivity.class));
              break;
          case R.id.card_view_03:
              ParcelableBean bean = new ParcelableBean();
              bean.setAge(18);
              bean.setFlag(true);
              bean.setName("张三");
              Intent intent  = new Intent();
              intent.setClass(this, ParcelableActivity.class);
              intent.putExtra(ParcelableBean.KEY,bean);
              startActivity(intent);
              break;

          case R.id.card_view_04:
                startActivity(new Intent(this,NavigationViewAcitivty.class));
              break;
          case R.id.card_view_05:
              startActivity(new Intent(this,RecyclerAnimViewActivity.class));
              break;
          default:
              break;
      }

    }
}
