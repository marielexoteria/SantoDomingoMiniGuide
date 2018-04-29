package com.example.android.sdminiguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TouristGuide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_guide);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        TouristTipsCategoryAdapter adapter = new TouristTipsCategoryAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);


        // *** Beginning of Footer section ***

        //Variables needed to build the footer section of the app
        TextView footer = (TextView) findViewById(R.id.footer);

        /*Variables for the emojis I chose to use
         * Unicodes from http://www.unicode.org/emoji/charts/full-emoji-list.html
         */
        int unicodeEmojiHeart = 0x2665;
        int unicodeEmojiCake = 0x1F370;

        /* Code for writing emojis found on
         * https://stackoverflow.com/questions/26893796/how-set-emoji-by-unicode-in-a-textview
         * getString(R.string.footer_part_X) = will return the strings of
         * resource IDs footer_part_1 and footer_part_2 as defined in strings.xml
         */
        footer.setText(getString(R.string.footer_part_1) + getEmojiByUnicode(unicodeEmojiHeart)
                + getString(R.string.footer_part_2) + getEmojiByUnicode(unicodeEmojiCake));

        // *** End of Footer section ***
    }

    /*
     * Function that returns an emoji as a string to display it in the footer
     * without needing to use a Drawable resource (found on the link above)
     * @param unicode     the int code of the emoji defined in the variables unicodeEmojiHeart
     * & unicodeEmojiCake
     */

    private String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

}
