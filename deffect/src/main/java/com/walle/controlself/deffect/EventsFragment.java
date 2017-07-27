package com.walle.controlself.deffect;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.walle.controlself.deffect.adapter.DayDragAdapter;
import com.walle.controlself.deffect.adapter.decoration.DragHourDecoration;
import com.walle.controlself.deffect.dragSelector.DragSelectRecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment implements DayDragAdapter.ClickListener,DayDragAdapter.SelectionListener{
    private String TAG="EventsFragment";
    DragSelectRecyclerView dragSelectRecyclerView;
    View view;
    DayDragAdapter adapter;
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
        dragSelectRecyclerView=view.findViewById(R.id.drag_recycler);

        adapter=new DayDragAdapter(this);
        GridLayoutManager grid=new GridLayoutManager(getActivity(),8);
        dragSelectRecyclerView.setLayoutManager(grid);
        adapter.setSelectionListener(this);
        dragSelectRecyclerView.setAdapter(adapter);
        dragSelectRecyclerView.addItemDecoration(new DragHourDecoration());

    }


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
