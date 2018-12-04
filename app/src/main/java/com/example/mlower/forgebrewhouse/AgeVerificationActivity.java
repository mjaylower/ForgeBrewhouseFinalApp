package com.example.mlower.forgebrewhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.Objects;

public class AgeVerificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_age_verification);
        Objects.requireNonNull (getSupportActionBar ()).setDisplayShowHomeEnabled (true);
        getSupportActionBar ().setLogo (R.mipmap.ic_launcher);
        getSupportActionBar ().setDisplayUseLogoEnabled (true);

        // pulling user entered data from app
        final Spinner spnMonth = findViewById (R.id.spnMonth);
        final Spinner spnDay = findViewById (R.id.spnDay);
        final Spinner spnYear = findViewById (R.id.spnYear);
        final Button btnEnter = findViewById (R.id.btnEnter);

        btnEnter.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                // converting spinner items to string and then to int for comparison

                String userMonth = spnMonth.getSelectedItem().toString();
                int userMonthInt = Integer.parseInt(userMonth);
                String userDay = spnDay.getSelectedItem().toString ();
                int userDayInt = Integer.parseInt(userDay);
                String userYear = spnYear.getSelectedItem().toString ();
                int userYearInt = Integer.parseInt(userYear);
                LocalDate userDate = LocalDate.of(userYearInt, userMonthInt, userDayInt);

                // getting today's date info
                LocalDate ld = LocalDate.now ();
                int month = ld.getMonthValue ();
                int day = ld.getDayOfMonth ();
                int year = ld.getYear ();
                int adjYear = year - 21;  // adjusting year to compare and verify over 21 years old
                LocalDate adjDate = LocalDate.of (adjYear, month, day); // full date to compare to verify over 21 years old

                if(userDate.isAfter (adjDate)){
                    Toast.makeText (getApplicationContext (),getString (R.string.errMessageAge), Toast.LENGTH_LONG).show();
                }
                else {
                    Intent nextScreen = new Intent (AgeVerificationActivity.this, MainPageActivity.class);
                    startActivity (nextScreen);
                }
            }
        });
    }
}


