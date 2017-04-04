package com.example.android.miwok;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Phrases extends Fragment {

private MediaPlayer mmedia;
    public Phrases() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_phrases, container, false);

        final ArrayList<Word> words = new ArrayList<Word>();


        words.add(new Word("Where are you going","kha ja raha h mc",R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name","Nam bta tera",R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is","Wassepuri Hagu",R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling","kaisa lag raha hai",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I 'm feeling good","thike hu",R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?","chal raha hai?",R.raw.phrase_are_you_coming));
        words.add(new Word("Yes I 'm coming","aaraha hu",R.raw.phrase_are_you_coming));
        words.add(new Word("Let's Go","chal be",R.raw.phrase_lets_go));
        words.add(new Word("Come here","idar aa saale",R.raw.phrase_come_here));

////        words.add("two");
////        words.add("three");
//
        WordAdapter itemsAdapter = new WordAdapter(getActivity(),words,R.color.category_phrases);

        ListView listView = (ListView) rootView.findViewById(R.id.phrases);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Word word= words.get(position);
                releaseMediaPlayer();
                mmedia= MediaPlayer.create(getActivity(),word.getmedia());
                mmedia.start();
                mmedia.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer media) {
                        releaseMediaPlayer();
                    }
                });
            }
        });
        return rootView;
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mmedia != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mmedia.release();
        }

        //Set the media player back to null. For our code, we've decided that
        // setting the media player to null is an easy way to tell that the media player
        // is not configured to play an audio file at the moment.
        mmedia = null;
    }


}
