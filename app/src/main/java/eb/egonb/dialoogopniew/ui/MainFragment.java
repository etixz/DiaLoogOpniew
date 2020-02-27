package eb.egonb.dialoogopniew.ui;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import eb.egonb.dialoogopniew.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {




    private View.OnClickListener toastListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast toasty = Toast.makeText(getActivity(), "Hello popup!", Toast.LENGTH_SHORT);
            toasty.setGravity(Gravity.TOP, 0, 0);
            toasty.show();
        }
    };
    private View.OnClickListener simpleListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new SimpleDialogFragment().show(getParentFragmentManager(), "sdf");
        }
    };
    private View.OnClickListener fluListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new FluDialogFragment().show(getParentFragmentManager(), "fed");
        }
    };
    private View.OnClickListener dateListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new DateOfBirthDialogFragment().show(getParentFragmentManager(), "dte");
        }
    };
    private View.OnClickListener snackListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Snackbar snackbar = Snackbar.make(rootView.findViewById(R.id.frag_container),
                    "Wurum? Durum", Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("Gefaald", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            snackbar.setActionTextColor(Color.YELLOW);

            snackbar.show();
        }
    };
    private View rootView;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    public MainFragment() {
        // Required empty public constructor
    }



    //early optimalisation is the root of all evil
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Button btnToast = rootView.findViewById(R.id.btn_toast);
        btnToast.setOnClickListener(toastListener);

        Button btnSimple = rootView.findViewById(R.id.btn_simple);
        btnSimple.setOnClickListener(simpleListener);

        Button btnFlu = rootView.findViewById(R.id.btn_catch);
        btnFlu.setOnClickListener(fluListener);

        Button btnDate = rootView.findViewById(R.id.btn_date);
        btnDate.setOnClickListener(dateListener);

        FloatingActionButton fabSnackBar = rootView.findViewById(R.id.fab_snackbar);
        fabSnackBar.setOnClickListener(snackListener);

        return rootView;
    }

}
