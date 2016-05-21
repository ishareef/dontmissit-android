package com.corp.dontmissit.dontmissit;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Your message has been saved!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        int numGC = 3;
        final String[] giftCardNames = {"iTunes", "Victoria Secret", "Walmart"};
        int imageViewId = R.id.giftcard_1;

        // Selected Gift Card Holder Variables
        final LinearLayout linearLayout = (LinearLayout)findViewById(R.id.selected_gift_holder);
        final TextView textView = (TextView)findViewById(R.id.gift_card_data);

        for (int i = 0; i < numGC; i ++) {
            ImageButton imageButton = (ImageButton)findViewById(imageViewId + i);
            assert imageButton != null;
            final int position = i;
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Make the layout holder visible
                    assert linearLayout != null;
                    linearLayout.setVisibility(View.VISIBLE);

                    // Set the selected gift card name to text
                    assert textView != null;
                    textView.setText(giftCardNames[position]);
                }
            });
        }

        // Set reset button
        Button resetBtn = (Button)findViewById(R.id.reset_button);
        assert resetBtn != null;
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert linearLayout != null;
                linearLayout.setVisibility(View.GONE);
            }
        });
    }

}
