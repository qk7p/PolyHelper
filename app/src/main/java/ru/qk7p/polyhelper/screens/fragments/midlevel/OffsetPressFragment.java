package ru.qk7p.polyhelper.screens.fragments.midlevel;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.brunomndantas.tpl4j.task.Task;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.textfield.TextInputEditText;

import ru.qk7p.polyhelper.App;
import ru.qk7p.polyhelper.adapters.MaterialsAdapter;
import ru.qk7p.polyhelper.R;
import ru.qk7p.polyhelper.model.Material;


public class OffsetPressFragment extends Fragment
        implements View.OnClickListener {

    private RecyclerView materialList;
    private MaterialsAdapter materialsAdapter;
    int layoutId;
    Dialog dialog;
    Button addMaterialButton;
    Button deleteMaterialButton;


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
        addMaterialButton = v.findViewById(R.id.add_material);
        deleteMaterialButton = v.findViewById(R.id.btn_delete);
        addMaterialButton.setOnClickListener(this);
        deleteMaterialButton.setOnClickListener(this);

        MaterialButtonToggleGroup toggleGroup = v.findViewById(R.id.tb_materials);
        toggleGroup.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if (isChecked) {
                layoutId = R.layout.material_list_delete_item;
            } else {
                layoutId = R.layout.material_list_item;
            }
            materialList.setAdapter(new MaterialsAdapter(100, layoutId));


        });


        return v;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add_material) {
            dialog = new Dialog(v.getContext());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.add_material_dialog);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            Button btnCloseDialog = dialog.findViewById(R.id.btn_close_dialog);
            btnCloseDialog.setOnClickListener(v1 -> dialog.cancel());


            Button btnAddMaterial = dialog.findViewById(R.id.btn_add_material);
            btnAddMaterial.setOnClickListener(v1 -> {
                TextInputEditText editTextMaterialName = dialog.findViewById(R.id.et_material_name);
                if (editTextMaterialName.getText().toString() == null) {
                    Toast.makeText(v.getContext(), "опять ноль", Toast.LENGTH_SHORT).show();
                } else {

                    String materialName = editTextMaterialName.getText().toString();
                    Material material = new Material(materialName);
                    new Task(() -> App.getInstance().getMaterialDao().insert(material)).start();
                    dialog.cancel();
                }
            });

            dialog.show();
        }
    }
}

