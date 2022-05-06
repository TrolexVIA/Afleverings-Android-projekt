package troels1.com.organisation.mypantry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textOnMain = findViewById(R.id.TextInMain);
        Button testButton = findViewById(R.id.testButton);

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            textOnMain.setText(R.string.changed);
            }
        });
        }
}

// Toast.makeText(context:this, text:"text1",toast.LENGTH_LONG).show();