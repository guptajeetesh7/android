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
public class Family extends Fragment {

private  MediaPlayer mmedia;
    public Family() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_family, container, false);
        final ArrayList<Word> words = new ArrayList<Word>();


        words.add(new Word("father","papa",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("mother","mom",R.drawable.family_mother,R.raw.family_mother));
        words.add(new Word("son","beta",R.drawable.family_son,R.raw.family_son));
        words.add(new Word("daugther","bhaan",R.drawable.family_older_sister,R.raw.family_daughter));
        words.add(new Word("older bro","bada bhaiya",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new Word("younger bhaiya","choota bhaiya",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new Word("young sister","chooti bhaan",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new Word("grandmother","daadi",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new Word("grandfather","dada",R.drawable.family_grandfather,R.raw.family_grandfather));

////        words.add("two");
////        words.add("three");
//
        WordAdapter itemsAdapter = new WordAdapter(getActivity(),words,R.color.category_family);

        ListView listView = (ListView) rootView.findViewById(R.id.family);

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
                    public void onCompletion(MediaPlayer mediaPlayer) {
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
