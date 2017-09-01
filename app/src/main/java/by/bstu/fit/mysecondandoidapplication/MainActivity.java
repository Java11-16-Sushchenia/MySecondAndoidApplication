package by.bstu.fit.mysecondandoidapplication;

import android.app.Activity;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int pressCount;

    private TextView textView;
    private TextView textView2;
    private SeekBar seekBar;
    private ProgressBar progressBar;
    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        aSwitch = (Switch)findViewById(R.id.switch1);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView2.setText("SeekBar value: "+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                aSwitch.setChecked(true);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                aSwitch.setChecked(false);
            }
        });

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action",
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });
    }

    public void onButtonClick(View view){
        pressCount++;
        textView.setText("Press count: " + pressCount);
    }

    public void onClearCounterClick(View view){
        pressCount = 0;
        textView.setText("Cleared");
    }
}
