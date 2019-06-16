package com.fgt.baron;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

import com.fgt.baron.adapter.TampilanArActivity;

public class ArMateriFragment extends Fragment {

    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
    Button btnAr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ar_materi, container, false);

        btnAr = (Button) v.findViewById(R.id.btnAr);

        btnAr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAr.setAnimation(buttonClick);
                Intent goAr = new Intent(getActivity(), TampilanArActivity.class);
                startActivity(goAr);
            }
        });

        return v;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

