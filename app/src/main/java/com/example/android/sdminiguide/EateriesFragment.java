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
public class EateriesFragment extends Fragment {


    public EateriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tourist_tips, container, false);

        //Setting the map of tourist_tips programmatically
        ImageView mapOfEateries  = new ImageView(getActivity());
        mapOfEateries.setImageResource(R.drawable.map_eateries);
        // This is to preserve the original aspect ratio
        mapOfEateries.setAdjustViewBounds(true);

        //Variable needed to build the footer
        TextView footer = new TextView(getActivity());

        //Creating the ArrayList and using it to display content on tourist_tips.xml
        ArrayList<TouristTip> eateriesList = new ArrayList<TouristTip>();

        //Populating the ArrayList
        eateriesList.add(new TouristTip(R.drawable.dluis_thumbnail, R.string.eatery1_name,
                R.string.eatery1_address_text, R.drawable.dluis_main_photo, R.string.eatery1_description,
                R.string.eatery1_phone_number, R.string.eatery1_opening_hours, R.string.eatery1_website,
                R.drawable.map_dluis, R.string.eatery1_coordinates, R.string.eatery1_address_for_map));

        eateriesList.add(new TouristTip(R.drawable.payan_thumbnail, R.string.eatery2_name,
                R.string.eatery2_address_text, R.drawable.payan_main_photo, R.string.eatery2_description,
                R.string.eatery2_phone_number, R.string.eatery2_opening_hours, R.string.eatery2_website,
                R.drawable.map_payan, R.string.eatery2_coordinates, R.string.eatery2_address_for_map));

        eateriesList.add(new TouristTip(R.drawable.meson_dbari_thumbnail, R.string.eatery3_name,
                R.string.eatery3_address_text, R.drawable.meson_dbari_main_photo, R.string.eatery3_description,
                R.string.eatery3_phone_number, R.string.eatery3_opening_hours, R.string.eatery3_website,
                R.drawable.map_meson_dbari, R.string.eatery3_coordinates, R.string.eatery3_address_for_map));

        eateriesList.add(new TouristTip(R.drawable.cafetera_thumbnail, R.string.eatery4_name,
                R.string.eatery4_address_text, R.drawable.cafetera_main_photo, R.string.eatery4_description,
                R.string.eatery4_phone_number, R.string.eatery4_opening_hours, R.string.eatery4_website,
                R.drawable.map_cafetera, R.string.eatery4_coordinates, R.string.eatery4_address_for_map));

        eateriesList.add(new TouristTip(R.drawable.patepalo_thumbnail, R.string.eatery5_name,
                R.string.eatery5_address_text, R.drawable.patepalo_main_photo, R.string.eatery5_description,
                R.string.eatery5_phone_number, R.string.eatery5_opening_hours, R.string.eatery5_website,
                R.drawable.map_patepalo, R.string.eatery5_coordinates, R.string.eatery5_address_for_map));

        //Creating an ArrayAdapter and a ListView to recycle the views
        TouristTipAdapter eateriesItemsAdapter = new TouristTipAdapter(getActivity(), eateriesList);
        ListView eateriesListView = (ListView) rootView.findViewById(R.id.tourist_tips_list_view);

        //Populating the ListView
        eateriesListView.setAdapter(eateriesItemsAdapter);
        //Adding the map as a header
        eateriesListView.addHeaderView(mapOfEateries, null, false);
        eateriesListView.addFooterView(footer, null, false);


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
