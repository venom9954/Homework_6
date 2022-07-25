package com.example.homework_6;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class NamesFragment extends Fragment {

    private Notes noteOne;
    private Notes noteTwo;
    private Notes noteThree;


    public static NamesFragment newInstance() {
        NamesFragment fragment = new NamesFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_names, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initNotes();
        ArrayList<Notes> notes = new ArrayList<>();
        notes.add(noteOne);
        notes.add(noteTwo);
        notes.add(noteThree);

        for(int i=0; i < notes.size(); i++){
            TextView tv = new TextView(getContext());
            tv.setTextSize(30f);
            Notes note = notes.get(i);
            tv.setText((String)note.getNameNote());
            ((LinearLayout) view).addView(tv);

            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                        TextFragment textFragment = TextFragment.newInstance(note);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.text_fragment, textFragment ).commit();
                    } else{
                        TextFragment textFragment = TextFragment.newInstance(note);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.names, textFragment ).addToBackStack("").commit();
                    }
                }
            });

        }

    }
    public void initNotes(){
        noteOne = new Notes("Заметка-1", "Какое-то описание заметки-1 бла-бла-бла", "nn.nn.nnnn");
        noteTwo = new Notes("Заметка-2", "Какое-то описание заметки-2 бла-бла-бла", "nn.nn.nnnn");
        noteThree = new Notes("Заметка-3", "Какое-то описание заметки-3 бла-бла-бла", "nn.nn.nnnn");
    }
}