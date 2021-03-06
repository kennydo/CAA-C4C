package com.caa.ui;

import java.util.ArrayList;
import java.util.Iterator;

import com.caa.bspace.BSpaceClass;
import com.caa.bspace.R;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ClassViewActivity extends ListActivity {

    ArrayList<BSpaceClass> listItems = new ArrayList<BSpaceClass>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Iterator<BSpaceClass> i = BSpaceMobileActivity.currentUser.classes.iterator();
        while (i.hasNext()) {
            listItems.add(i.next());
        }

        setListAdapter(new ArrayAdapter<BSpaceClass>(this, R.layout.list_item, listItems));

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);

        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // When clicked, show a toast with the TextView text
                Intent myIntent = new Intent(ClassViewActivity.this, ClassTabWidget.class);
                BSpaceMobileActivity.currentClass = listItems.get(position);
                ClassViewActivity.this.startActivity(myIntent);
            }
        });
    }
}
