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
public class Colors extends Fragment {

private MediaPlayer mmedia;
    public Colors() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_colors, container, false);

        final ArrayList<Word> words = new ArrayList<Word>();


        words.add(new Word("red", "laaal", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("green", "haara", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("brown", "burraa", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("grey", "grey", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("black", "kalaa", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("white", "sphade", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("dusty yellow", "sand", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "mustard", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

////        words.add("two");
////        words.add("three");
//
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_colors);

        ListView listView = (ListView) rootView.findViewById(R.id.colours);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = words.get(position);

                releaseMediaPlayer();
                mmedia = MediaPlayer.create(getActivity(), word.getmedia());
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
