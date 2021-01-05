package com.example.anagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView ivHead;
    EditText etName1, etName2;
    Button btnCheck;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivHead = findViewById(R.id.ivHead);
        etName1 = findViewById(R.id.etName1);
        etName2 = findViewById(R.id.etName2);
        btnCheck = findViewById(R.id.btnCheck);
        tvResult = findViewById(R.id.tvResult);

        tvResult.setText(null);




        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String name1 = etName1.getText().toString().trim();
                final String name2 = etName2.getText().toString().trim();

                int c=0,k=0;
                int [] pos = {-1,-1,-1,-1,-1,-1,-1,-1};
                String check = name1;

                if(name1.length() == name2.length())
                {
                    for (int i=0; i<check.length(); i++)
                    {
                        if (c != 0) {
                            break;
                        }
                        for (int j = 0; j < name2.length(); j++)
                        {
                            if (j == pos[0] || j == pos[1] || j == pos[2] || j == pos[3] || j == pos[4] || j == pos[5] || j == pos[6])
                            {
                                continue;
                            }
                            if (check.charAt(i) != name2.charAt(j))
                            {
                                c++;
                            }
                            else
                            {
                                c = 0;
                                if(pos[k] == -1) {
                                    pos[k] = j;
                                }
                                else
                                {
                                    k++;
                                    pos[k] = k;
                                }
                                k++;
                                break;
                            }
                        }
                    }
                }
                else
                {
                    c=1;
                }



                if(tvResult != null)
                {
                    if(c==0)
                    {
                        tvResult.setText("They are Anagrams!!");
                    }
                    else
                    {
                        tvResult.setText("They are Not Anagrams!!");
                    }
                }


            }


        });

    }
}
