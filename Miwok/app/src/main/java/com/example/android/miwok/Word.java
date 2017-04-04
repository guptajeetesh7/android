package com.example.android.miwok;

/**
 * Created by Jeetesh on 2/25/2017.
 */

public class Word {
    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private int mImage=image_present;

    private static final int image_present=-1;

    private int mmedia;

    public Word(String DefaultTranslation, String MiwokTranslation,int Image, int Media)
    {
        mDefaultTranslation=DefaultTranslation;
        mMiwokTranslation=MiwokTranslation;
        mImage=Image;
        mmedia=Media;
    }
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }


    public int getImage(){
        return mImage;
    }

    public Word(String DefaultTranslation, String MiwokTranslation,int Media)
    {
        mDefaultTranslation=DefaultTranslation;
        mMiwokTranslation=MiwokTranslation;
        mmedia=Media;

    }

    public boolean has_image(){
        return mImage!=image_present;
    }

    public int getmedia(){
        return mmedia;
    }
}
