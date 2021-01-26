package ru.qk7p.polyhelper;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class OffsetPressFragment extends Fragment {

    private RecyclerView materialList;
    private MaterialsAdapter materialsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_offset_press, container, false);
        materialList = v.findViewById(R.id.rv_materials);

        materialList.setLayoutManager(new LinearLayoutManager(getActivity()));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        materialList.setLayoutManager(layoutManager);

        materialList.setAdapter(new MaterialsAdapter(100));

        return v;
    }
}