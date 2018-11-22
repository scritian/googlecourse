package com.scritian.googlecourse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSave;
    private EditText etTripName;
    private EditText etDestination;
    private RadioGroup rgTripType;
    private RadioButton rbSelected;
    private SeekBar sbPrice;
    private RatingBar rbRating;
    private EditText etStartDate, etEndDate;
    private TextView tvPrice;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgTripType=findViewById(R.id.rgTripType);
        btnSave=findViewById(R.id.bSave);
        tvPrice=findViewById(R.id.tvPrice);
        sbPrice=findViewById(R.id.sbPrice);
        sbPrice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvPrice.setText("Price("+progress+"€)");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected_id=rgTripType.getCheckedRadioButtonId();
                rbSelected=findViewById(selected_id);
                etTripName=findViewById(R.id.etTripName);
                etDestination=findViewById(R.id.etDestination);
                sbPrice=findViewById(R.id.sbPrice);
                rbRating=findViewById(R.id.rbRating);
                etStartDate=findViewById(R.id.etStartDate);
                etEndDate=findViewById(R.id.etEndDate);
                String result="";
                result+="Trip name: "+etTripName.getText().toString()+"\nDestination: "+etDestination.getText().toString();
                result+="\nTrip type: "+rbSelected.getText().toString()+"\nPrice(€): "+sbPrice.getProgress();
                result+="€\nStart date: "+etStartDate.getText().toString()+"\nEnd date: "+etEndDate.getText().toString();
                result+="\nRating: "+rbRating.getRating()+" stars";
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }
}
