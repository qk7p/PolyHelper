package ru.qk7p.polyhelper.screens.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.qk7p.polyhelper.App;
import ru.qk7p.polyhelper.model.Material;

public class MainViewModel extends ViewModel {
    private LiveData<List<Material>> modelMaterialData = App.getInstance().getMaterialDao().getAllLiveData();

    public LiveData<List<Material>> getModelMaterialData() {
        return modelMaterialData;
    }

    private MutableLiveData<String> materialName;

    public MutableLiveData<String> getMaterialName() {
        if (materialName == null) {
            materialName = new MutableLiveData<String>();
        }
        return materialName;
    }
    

}
