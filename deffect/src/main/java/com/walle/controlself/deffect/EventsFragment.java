package com.walle.controlself.deffect;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.greendaolib.DaoManager;
import com.example.greendaolib.dao.EventsInfoDao;
import com.example.greendaolib.pojo.db.EventsInfo;
import com.walle.controlself.deffect.adapter.DayDragAdapter;
import com.walle.controlself.deffect.adapter.EventsAdapter;
import com.walle.controlself.deffect.adapter.decoration.DragHourDecoration;
import com.walle.controlself.deffect.dragSelector.DragSelectRecyclerView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment
//        implements DayDragAdapter.ClickListener,DayDragAdapter.SelectionListener
{
    private String TAG="EventsFragment";
 RecyclerView eventsRecycler,hoursRecycler;
    EventsAdapter eventsAdapter;
    View view;
//    DayDragAdapter adapter;
    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view==null ){
            view=inflater.inflate(R.layout.fragment_events, container, false);
            viewId();
        }
        return view;
    }
    private void viewId(){
        eventsRecycler=view.findViewById(R.id.recycler_events);
        hoursRecycler=view.findViewById(R.id.recycler_day_hours);
        initData();
    }
    private void initData(){
        EventsInfoDao dao= (EventsInfoDao) DaoManager.getManager().getDao(EventsInfo.class);
        List<EventsInfo> events=dao.loadAll();
        Log.d(TAG,events.toString());
        eventsAdapter=new EventsAdapter(events);
        eventsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        eventsRecycler.setAdapter(eventsAdapter);

    }


//    @Override
//    public void onClick(int index) {
//        adapter.toggleSelected(index);
//    }
//
//    @Override
//    public void onLongClick(int index) {
//        dragSelectRecyclerView.setDragSelectActive(true, index);
//    }
//
//    @Override
//    public void onDragSelectionChanged(int count) {
//        Log.d(TAG,"onDragSelectionChanged>>>>>"+count);
//    }
}
