package com.diglesia.hw2017mobiledev.lec7;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GenericFragment extends Fragment {

    public static GenericFragment newInstance(int color, int position, int menuId) {
        Bundle args = new Bundle();
        args.putInt("color", color);
        args.putInt("position", position);
        args.putInt("menuId", menuId);
        GenericFragment f = new GenericFragment();
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(getArguments().getInt("menuId"), menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("DEI", "GENERIC at "+getArguments().getInt("position")+":"+item.toString());
        if (item.getItemId() == R.id.send_nasty_tweet) {
            Log.i("DEI", "SENDING NASTY TWEET!");

            View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_edit_text, null);
            final EditText commentEditText = (EditText) view.findViewById(R.id.plain_text_input);
            //commentEditText.addTextChangedListener();

            AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
                    .setTitle("Are you sure, that is kind of mean...")
                    .setView(commentEditText)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            final String query = commentEditText.getText().toString();
                            Log.i("DEI", query);
                        }
                    })
                    .setNegativeButton(android.R.string.cancel, null)
                    .create();

            alertDialog.show();
        }

        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_generic, container, false);

        TextView textView = v.findViewById(R.id.text_view);
        String text = "" + getArguments().getInt("position");
        textView.setText(text);

        LinearLayout topLayout = v.findViewById(R.id.top_layout);
        topLayout.setBackgroundColor(getArguments().getInt("color"));

        return v;
    }
}
