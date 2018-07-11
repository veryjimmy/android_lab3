package com.example.panyenru.height_bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private EditText Age;
    private EditText Knee;
    private EditText Weight;
    private EditText Height;
    private TextView result_Height;
    private TextView Bmi;
    private TextView Output;
    private Button Input;
    private Button Sex;
    private Button Reset;
    private int age,turnzero=0,counter1=0,counter2=0;
    //counter1奇數是女生.偶數是男生 ，  counter2奇數是估計值.偶數是自行輸入

    private double inWeight,inHeight,inKnee;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Age = (EditText) findViewById(R.id.et_age);
        Knee = (EditText) findViewById(R.id.et_knee);
        Weight = (EditText) findViewById(R.id.et_weight);
        Height = (EditText) findViewById(R.id.et_height);
        result_Height = (TextView) findViewById(R.id.tv_height);
        Bmi = (TextView) findViewById(R.id.tv_bmi);
        Output = (TextView) findViewById(R.id.tv_output);
        Input = (Button) findViewById(R.id.btn_input);
        Sex = (Button) findViewById(R.id.btn_sex);
        Reset = (Button) findViewById(R.id.btn_reset);

        Sex.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                counter1++;
                if (counter1 % 2 == 1)
                {
                    Sex.setText("女生");
                    inKnee = Integer.parseInt(Knee.getText().toString());
                    add_height(inKnee, age);
                    age = Integer.parseInt(Age.getText().toString());
                    add_height(inKnee, age);

                    if(counter2 % 2 == 1)
                    {
                        inHeight = Integer.parseInt(Height.getText().toString());
                        add_bmi(inWeight, inHeight);
                        inWeight = Integer.parseInt(Weight.getText().toString());
                        add_input(inKnee, age, inWeight);
                    }

                }
                else
                {
                    Sex.setText("男生");
                    inKnee = Integer.parseInt(Knee.getText().toString());
                    add_height(inKnee, age);
                    age = Integer.parseInt(Age.getText().toString());
                    add_height(inKnee, age);

                    if(counter2 % 2 == 1)
                    {
                        inHeight = Integer.parseInt(Height.getText().toString());
                        add_bmi(inWeight, inHeight);
                        inWeight = Integer.parseInt(Weight.getText().toString());
                        add_input(inKnee, age, inWeight);
                    }
                }
            }
        });

        Input.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                counter2++;
                if (counter2 % 2 == 1)
                {
                    Input.setText("估計值");
                    Height.setEnabled(false);

                    inHeight = Integer.parseInt(Height.getText().toString());
                    add_bmi(inWeight, inHeight);
                    inWeight = Integer.parseInt(Weight.getText().toString());
                    add_input(inKnee, age, inWeight);
                }
                else
                {
                    Input.setText("自行輸入");
                    Height.setEnabled(true);

                    inHeight = Integer.parseInt(Height.getText().toString());
                    add_bmi(inWeight, inHeight);
                    inWeight = Integer.parseInt(Weight.getText().toString());
                    add_bmi(inWeight, inHeight);
                }
            }
        });

        Reset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Knee.setText(Integer.toString(turnzero));
                Age.setText(Integer.toString(turnzero));
                result_Height.setText(Integer.toString(turnzero));
                Height.setText(Integer.toString(turnzero));
                Weight.setText(Integer.toString(turnzero));
                Bmi.setText(Integer.toString(turnzero));
                counter1 = 0;
                counter2 = 0;
                Sex.setText("男生");
                Input.setText("自行輸入");
                Output.setText("結果");
            }
        });

        Knee.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(Knee.length()==0)
                {
                    Knee.setText(Integer.toString(turnzero));
                }
                else
                {
                    inKnee = Integer.parseInt(Knee.getText().toString());
                    add_height(inKnee, age);
                }
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        Age.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(Age.length()==0)
                {
                    Age.setText(Integer.toString(turnzero));
                }
                else
                {
                    age = Integer.parseInt(Age.getText().toString());
                    add_height(inKnee, age);
                }
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        Height.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(Height.length()==0)
                {
                    Height.setText(Integer.toString(turnzero));
                }
                else
                {
                    inHeight = Integer.parseInt(Height.getText().toString());
                    add_bmi(inWeight, inHeight);
                }

            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        Weight.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(Weight.length()==0)
                {
                    Weight.setText(Integer.toString(turnzero));
                }
                else
                {
                    inWeight = Integer.parseInt(Weight.getText().toString());
                    if (counter2 % 2 == 0)
                        add_bmi(inWeight, inHeight);
                    else
                        add_input(inKnee, age, inWeight);
                }

            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }

    public void add_input(double k,int a,double iw)
    {
        double H;
        double d=(double) a;
        if(counter1%2==0)
        {
            H = ((85.1 + (1.73 * k) - (0.11 * d)));
        }
        else
            H=((91.45 + (1.53 * k) - (0.16 * d)));


        double b=iw/((H/100)*(H/100));
        Bmi.setText(String.valueOf(b));
        if(b<18.5)
            Output.setText("體重過輕");
        else
            if(b>=18.5 && b<24)
                Output.setText("正常");
            else
                if(b>=35)
                    Output.setText("重度肥胖");
                else
                    if(b<35 && b>=30)
                        Output.setText("中度肥胖");
                    else
                        if(b<30 && b>=27)
                            Output.setText("輕度肥胖");
                        else
                            if(b<27 && b>=24)
                                Output.setText("過重");
    }

    public void add_height(double k,int a)
    {
        double h;
        double d=(double) a;
        if(counter1%2==0)
        {
            h = ((85.1 + (1.73 * k) - (0.11 * d)));
        }
        else
            h=((91.45 + (1.53 * k) - (0.16 * d)));

        result_Height.setText(String.valueOf(h));
    }

    public void add_bmi(double w,double h)
    {
        double b=w/((h/100)*(h/100));
        Bmi.setText(String.valueOf(b));
        if(b<18.5)
            Output.setText("體重過輕");
        else
            if(b>=18.5 && b<24)
                Output.setText("正常");
            else
                if(b>=35)
                    Output.setText("重度肥胖");
                else
                    if(b<35 && b>=30)
                        Output.setText("中度肥胖");
                    else
                        if(b<30 && b>=27)
                            Output.setText("輕度肥胖");
                        else
                            if(b<27 && b>=24)
                                Output.setText("過重");
    }

}
