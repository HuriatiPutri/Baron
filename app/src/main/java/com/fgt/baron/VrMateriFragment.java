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

public class VrMateriFragment extends Fragment {

    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
    Button btnVr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_vr_materi, container, false);

        btnVr = (Button) v.findViewById(R.id.btnVr);

        btnVr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnVr.setAnimation(buttonClick);
                Intent goVr = new Intent(getActivity(), LanjutVrActivity.class);
                startActivity(goVr);
            }
        });

        return v;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
