package com.walle.controlself.deffect;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.greendaolib.DaoManager;
import com.example.greendaolib.dao.EventsInfoDao;
import com.example.greendaolib.pojo.db.EventsInfo;
import com.walle.controlself.deffect.adapter.DayDragAdapter;
import com.walle.controlself.deffect.adapter.decoration.DragHourDecoration;
import com.walle.controlself.deffect.dragSelector.DragSelectRecyclerView;
import com.walle.controlself.deffect.tools.CovertTools;

public class EventDetailActivity extends AppCompatActivity  implements DayDragAdapter.ClickListener,DayDragAdapter.SelectionListener{
    private String TAG="EventDetailActivity";
        DragSelectRecyclerView dragSelectRecyclerView;
    private TextView tvBack,tvConfirm;
    private EditText etTodo,etToBe;
        DayDragAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
//        Toolbar toolbar =getActionBar().getT;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewId();
    }
        private void viewId(){
            dragSelectRecyclerView= (DragSelectRecyclerView) findViewById(R.id.drag_recycler);
            tvBack= (TextView) findViewById(R.id.tv_back);
            tvConfirm= (TextView) findViewById(R.id.tv_confirm);
            etTodo= (EditText) findViewById(R.id.et_do_what);
            etToBe= (EditText) findViewById(R.id.et_do_how);
            tvConfirm.setOnClickListener(onClickListener);
            tvConfirm.setOnClickListener(onClickListener);


            adapter=new DayDragAdapter(this);
            GridLayoutManager grid=new GridLayoutManager(this,8);
            dragSelectRecyclerView.setLayoutManager(grid);
            adapter.setSelectionListener(this);
            dragSelectRecyclerView.setAdapter(adapter);
            dragSelectRecyclerView.addItemDecoration(new DragHourDecoration());
    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId()==tvBack.getId()){
                finish();
            }else if (view.getId()==tvConfirm.getId()){
               EventsInfoDao dao= (EventsInfoDao) DaoManager.getManager().getDao(EventsInfo.class);
                EventsInfo eventsInfo=new EventsInfo();
                eventsInfo.setDoWanna(etToBe.getText().toString());
                eventsInfo.setDoWhat(etTodo.getText().toString());
                eventsInfo.setColor(Color.RED);
                Integer[] select= adapter.getSelectedIndices();
                eventsInfo.setHours(CovertTools.integerToString(select));
               long id= dao.insert(eventsInfo);
                Log.d(TAG,"inserted id="+id);


            }
        }
    };


    @Override
    public void onClick(int index) {
        adapter.toggleSelected(index);
    }

    @Override
    public void onLongClick(int index) {
        dragSelectRecyclerView.setDragSelectActive(true, index);
    }

    @Override
    public void onDragSelectionChanged(int count) {
        Log.d(TAG,"onDragSelectionChanged>>>>>"+count);
    }
}
