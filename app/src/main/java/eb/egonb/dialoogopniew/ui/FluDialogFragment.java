package eb.egonb.dialoogopniew.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class FluDialogFragment extends DialogFragment {

    String[] flues = {"Vanilla Flu", "Corona", "Spanish flu", "Sars"};

    private DialogInterface.OnClickListener itemSelectListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getActivity(), "you caught " + flues[which], Toast.LENGTH_SHORT).show();
        }
    };

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Gotta catch 'em all");
        builder.setItems(flues, itemSelectListener);
        builder.setNegativeButton(android.R.string.cancel, null);

        return builder.create();
    }
}
