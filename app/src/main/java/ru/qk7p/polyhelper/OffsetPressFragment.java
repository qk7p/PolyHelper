package ru.qk7p.polyhelper;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.widget.Toolbar;

import com.google.android.material.button.MaterialButtonToggleGroup;


public class OffsetPressFragment extends Fragment {

    private RecyclerView materialList;
    private MaterialsAdapter materialsAdapter;
    int layoutId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_offset_press, container, false);
        materialList = v.findViewById(R.id.rv_materials);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        materialList.setLayoutManager(layoutManager);

        layoutId = R.layout.material_list_item;

        materialsAdapter = new MaterialsAdapter(100, layoutId);

        materialList.setAdapter(materialsAdapter);

        MaterialButtonToggleGroup toggleGroup = v.findViewById(R.id.tb_materials);
toggleGroup.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
    if (isChecked) {
            layoutId = R.layout.material_list_delete_item;
            materialList.setAdapter(new MaterialsAdapter(100, layoutId));
        } else {
            layoutId = R.layout.material_list_item;
            materialList.setAdapter(new MaterialsAdapter(100, layoutId));
        }
    });


        return v;
    }


}

