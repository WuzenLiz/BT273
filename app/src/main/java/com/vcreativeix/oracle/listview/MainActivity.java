package com.vcreativeix.oracle.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private ListView listView;
    private ArrayList<item> arrayList = new ArrayList<>();
    private Adapter myAdapter = new Adapter(MainActivity.this, arrayList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_item);
        listView.setAdapter(myAdapter);

        initData();
        setClickOfListView();
    }

    private void initData(){
        arrayList.add(new item(R.drawable.yourname, "Your Name", "Shinkai Makoto"));
        arrayList.add(new item(R.drawable.jusbefriend, "Just be friend", "Chiren Kina"));
        arrayList.add(new item(R.drawable.bs3, "Và Rồi, Tháng 9 Không Có Cậu Đã Tới", "Natsuki Amasawa"));
        arrayList.add(new item(R.drawable.bs4, "Another S/0", "Yukito Ayatsuji"));
        arrayList.add(new item(R.drawable.bs5, "Những Đứa Trẻ Đuổi Theo Tinh Tú", "Shinkai Makoto"));
        myAdapter.notifyDataSetChanged();
    }

    private void setClickOfListView(){
        listView.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        listView.setOnItemLongClickListener((AdapterView.OnItemLongClickListener) this);
    }

    public void onitemClick(AdapterView<?> parent, View view, int position, long id) {
        arrayList.remove(position);
        myAdapter.notifyDataSetChanged();
    }

    public boolean onitemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, ItemActivity.class);
        Bundle bundle = new Bundle();

        bundle.putInt("Image", arrayList.get(position).getImageView());
        bundle.putString("Title", arrayList.get(position).getTitle());
        bundle.putString("Author", arrayList.get(position).getAuthor());

        intent.putExtras(bundle);

        startActivity(intent);

        return true;
    }

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    /**
     * Callback method to be invoked when an item in this view has been
     * clicked and held.
     * <p>
     * Implementers can call getItemAtPosition(position) if they need to access
     * the data associated with the selected item.
     *
     * @param parent   The AbsListView where the click happened
     * @param view     The view within the AbsListView that was clicked
     * @param position The position of the view in the list
     * @param id       The row id of the item that was clicked
     * @return true if the callback consumed the long click, false otherwise
     */
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }

    /**
     * Called when pointer capture is enabled or disabled for the current window.
     *
     * @param hasCapture True if the window has pointer capture.
     */
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
