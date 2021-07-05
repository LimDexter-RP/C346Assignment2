package sg.edu.rp.c346.id20039529.c346assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button web;
    Button products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    web = findViewById(R.id.buttonWeb);
    products = findViewById(R.id.buttonProducts);

    web.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/LimDexter-RP"));
            startActivity(i);
        }
    });
    products.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, ItemListActivity.class);
            startActivity(i);
        }
    });
    }
}