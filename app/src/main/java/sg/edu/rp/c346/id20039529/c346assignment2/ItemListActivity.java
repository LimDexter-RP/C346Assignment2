package sg.edu.rp.c346.id20039529.c346assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

public class ItemListActivity extends AppCompatActivity {
    Spinner spn136month;
    EditText etProduct;
    EditText etIndex;
    Button btnAdd;
    Button btnEdit;
    Button btnDel;
    EditText etSearch;
    ListView lvProduct;
    ArrayAdapter aaProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        spn136month = findViewById(R.id.spinner136month);
        etProduct = findViewById(R.id.editTextProduct);
        etIndex = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.buttonAdd);
        btnEdit = findViewById(R.id.buttonEdit);
        btnDel  = findViewById(R.id.buttonDel);
        etSearch = findViewById(R.id.editTextSearch);
        lvProduct = findViewById(R.id.listViewProduct);

        ArrayList alProduct = new ArrayList<>();
        alProduct.add("Expires 2022-1-10 Apple Watch");
        alProduct.add("Expires 2021-8-26 Razer Viper Ultimate Mouse");
        alProduct.add("Expires 2021-10-10 Acer Nitro 5 Laptop");
        alProduct.add("Expires 2021-10-26 iPhone SE Gen 2");
        alProduct.add("Expires 2022-1-3 Xbox One Controller");

        aaProduct = new ArrayAdapter(ItemListActivity.this, android.R.layout.simple_list_item_1, alProduct);
        lvProduct.setAdapter(aaProduct);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);

        Collections.sort(alProduct);
        spn136month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        etSearch.setText("Expires " + currentYear + "-" +(currentMonth + 2));
                        etSearch.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                (ItemListActivity.this).aaProduct.getFilter().filter(s);
                            }

                            @Override
                            public void afterTextChanged(Editable s) {

                            }
                        });
                        break;
                    case 1:
                        etSearch.setText("Expires " + currentYear + "-" +(currentMonth + 4));
                        etSearch.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                (ItemListActivity.this).aaProduct.getFilter().filter(s);
                            }

                            @Override
                            public void afterTextChanged(Editable s) {

                            }
                        });
                        break;
                    case 2:
                        etSearch.setText("Expires " + (currentYear + 1) + "-" +(currentMonth - 5));
                        etSearch.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                (ItemListActivity.this).aaProduct.getFilter().filter(s);
                            }

                            @Override
                            public void afterTextChanged(Editable s) {

                            }
                        });
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String product = etProduct.getText().toString();
                int index = Integer.parseInt(etIndex.getText().toString());
                alProduct.add(index, product);
                aaProduct.notifyDataSetChanged();

            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String product = etProduct.getText().toString();
                int index = Integer.parseInt(etIndex.getText().toString());
                alProduct.set(index, product);
                aaProduct.notifyDataSetChanged();
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = Integer.parseInt(etIndex.getText().toString());
                alProduct.remove(index);
                aaProduct.notifyDataSetChanged();
            }
        });


    }
}