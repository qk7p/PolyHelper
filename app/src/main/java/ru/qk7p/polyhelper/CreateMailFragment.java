package ru.qk7p.polyhelper;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.zip.Inflater;

import static ru.qk7p.polyhelper.R.id.offsetPress;

public class CreateMailFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_create_mail, container, false);
        Button offsetPressButton = v.findViewById(offsetPress);
        offsetPressButton.setOnClickListener(this);
        Button digitalPressButton = v.findViewById(R.id.digitalPress);
        digitalPressButton.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.digitalPress: {
                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                DigitalPressFragment digitalPressFragment = new DigitalPressFragment();
                ft.replace(R.id.sendMessageFragment, digitalPressFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
                break;
            }
            default: {
                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                OffsetPressFragment offsetPressFragment = new OffsetPressFragment();
                ft.replace(R.id.sendMessageFragment, offsetPressFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
                break;
            }

        }
    }

}

