package com.example.android.sdminiguide;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SightsFragment extends Fragment {

    public SightsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tourist_tips, container, false);

        //Setting the map of tourist_tips programmatically
        ImageView mapOfSights = new ImageView(getActivity());
        mapOfSights.setImageResource(R.drawable.map_sights);
        //This is to preserve the original aspect ratio
        mapOfSights.setAdjustViewBounds(true);

        //Variable needed to build the footer
        TextView footer = new TextView(getActivity());


        //Creating the ArrayList and using it to display content on tourist_tips.xml
        ArrayList<TouristTip> sightsList = new ArrayList<TouristTip>();

        //Populating the ArrayList
        sightsList.add(new TouristTip(R.drawable.alcazar_thumbnail, R.string.sight1_name,
                R.string.sight1_address_text, R.drawable.alcazar_main_photo, R.string.sight1_description,
                R.string.sight1_phone_number, R.string.sight1_opening_hours, R.string.sight1_website,
                R.drawable.map_alcazar, R.string.sight1_coordinates, R.string.sight1_address_for_map));

        sightsList.add(new TouristTip(R.drawable.monasterio_thumbnail, R.string.sight2_name,
                R.string.sight2_address_text, R.drawable.monasterio_main_photo, R.string.sight2_description,
                R.string.sight2_phone_number, R.string.sight2_opening_hours, R.string.sight2_website,
                R.drawable.map_monasterio, R.string.sight2_coordinates, R.string.sight2_address_for_map));

        sightsList.add(new TouristTip(R.drawable.catedral_thumbnail, R.string.sight3_name,
                R.string.sight3_address_text, R.drawable.catedral_main_photo, R.string.sight3_description,
                R.string.sight3_phone_number, R.string.sight3_opening_hours, R.string.sight3_website,
                R.drawable.map_catedral, R.string.sight3_coordinates, R.string.sight3_address_for_map));

        sightsList.add(new TouristTip(R.drawable.larimar_museum_thumbnail, R.string.sight4_name,
                R.string.sight4_address_text, R.drawable.larimar_museum_main_photo, R.string.sight4_description,
                R.string.sight4_phone_number, R.string.sight4_opening_hours, R.string.sight4_website,
                R.drawable.map_larimar, R.string.sight4_coordinates, R.string.sight4_address_for_map));

        sightsList.add(new TouristTip(R.drawable.fortaleza_thumbnail, R.string.sight5_name,
                R.string.sight5_address_text, R.drawable.fortaleza_main_photo, R.string.sight5_description,
                R.string.sight5_phone_number, R.string.sight5_opening_hours, R.string.sight5_website,
                R.drawable.map_fortaleza, R.string.sight5_coordinates, R.string.sight5_address_for_map));

        //Creating an ArrayAdapter and a ListView to recycle the views
        TouristTipAdapter sightsItemsAdapter = new TouristTipAdapter(getActivity(), sightsList);
        ListView sightsListView = (ListView) rootView.findViewById(R.id.tourist_tips_list_view);

        //Populating the ListView
        sightsListView.setAdapter(sightsItemsAdapter);
        //Adding the map as a header
        sightsListView.addHeaderView(mapOfSights, null, false);
        sightsListView.addFooterView(footer, null, false);


        // *** Beginning of the code that builds the Footer section ***

        /*Variables for the emojis I chose to use
         * Unicodes from http://www.unicode.org/emoji/charts/full-emoji-list.html
         * How to display the flag: https://stackoverflow.com/questions/42234666/get-emoji-flag-by-country-code/42235254
         */
        int unicodeEmojiHeart = 0x2665;
        int flagOffset = 0x1F1E6; //regional indicator symbol letter A
        int asciiOffset = 0x41; //ascii code of uppercase letter A
        /*For some reason leaving these values as is, instead of using the codes for the
         * Dominican flag, works.
         */
        String country = getString(R.string.country_iso_code); //ISO code for Dominican Republic  String country = "DO";

        int firstChar = Character.codePointAt(country, 0) - asciiOffset + flagOffset;
        int secondChar = Character.codePointAt(country, 1) - asciiOffset + flagOffset;

        String emojiHeart = new String(Character.toChars(unicodeEmojiHeart));
        String emojiDominicanFlag = new String(Character.toChars(firstChar))
                + new String(Character.toChars(secondChar));

        /* Code for writing emojis found on
         * https://stackoverflow.com/questions/26893796/how-set-emoji-by-unicode-in-a-textview
         * getString(R.string.footer_part_X) = will return the strings of
         * resource IDs footer_part_1 and footer_part_2 as defined in strings.xml
         */
        footer.setText(getString(R.string.footer_part_1) + emojiHeart
                + getString(R.string.footer_part_2) + emojiDominicanFlag);
        footer.setGravity(Gravity.CENTER);
        footer.setTextColor(Color.BLACK);
        footer.setTextSize(TypedValue.COMPLEX_UNIT_SP,
                getResources().getDimension(R.dimen.footer_size));

        // *** End of the code that builds the Footer section  ***

        return rootView;
    }

}
