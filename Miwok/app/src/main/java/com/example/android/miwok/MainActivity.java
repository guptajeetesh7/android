/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {


    private Toolbar mtool;
    private TabLayout mtab;
    private ViewPager viewPager;

    private SimpleFragmentPagerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtool=(Toolbar) findViewById(R.id.tool);
        mtab=(TabLayout) findViewById(R.id.tab);

        mtab.addTab(mtab.newTab().setText("Number"));
        mtab.addTab(mtab.newTab().setText("Family"));
        mtab.addTab(mtab.newTab().setText("Colors"));

        setSupportActionBar(mtool);
        getSupportActionBar().setHomeButtonEnabled(true);

        setTitle("MIWOK");

        viewPager=(ViewPager) findViewById(R.id.pager);

        adapter=new SimpleFragmentPagerAdapter((getSupportFragmentManager()));

        viewPager.setAdapter(adapter);
        mtab.setupWithViewPager(viewPager);




    }
}



