package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    int i = 0;
    private MediaPlayer mmedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        final ArrayList<Word> words = new ArrayList<Word>();


        words.add(new Word("one", "ekk no", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "do", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "teen", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "chaar", R.drawable.number_four, R.raw.number_three));
        words.add(new Word("five", "paach", R.drawable.number_five, R.raw.number_four));
        words.add(new Word("six", "chaaka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("seven", "saath", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("eight", "aaath", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("nine", "noou", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("ten", "dus", R.drawable.number_nine, R.raw.number_nine));
//        words.add("two");
//        words.add("three");

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = words.get(position);
                releaseMediaPlayer();
                mmedia = MediaPlayer.create(NumbersActivity.this, word.getmedia());


                mmedia.start();
                mmedia.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer media) {
                        releaseMediaPlayer();
                    }
                });
            }
        });
    }

    /**
     * Clean up the media player by releasing its resources.
     */


    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();

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

