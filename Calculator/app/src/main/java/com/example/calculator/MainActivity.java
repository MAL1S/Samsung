package com.example.calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.icu.number.Precision;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stat.Calculations;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

import dalvik.system.DexClassLoader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private double number1, number2;
    Calculations calc;
    Button sin, cos, tg, ctg;
    TextView text;
    DecimalFormat df = new DecimalFormat(".###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc = new Calculations();

        Button button1 = findViewById(R.id.one);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.two);
        button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.three);
        button3.setOnClickListener(this);
        Button button4 = findViewById(R.id.four);
        button4.setOnClickListener(this);
        Button button5 = findViewById(R.id.five);
        button5.setOnClickListener(this);
        Button button6 = findViewById(R.id.six);
        button6.setOnClickListener(this);
        Button button7 = findViewById(R.id.seven );
        button7.setOnClickListener(this);
        Button button8 = findViewById(R.id.eight);
        button8.setOnClickListener(this);
        Button button9 = findViewById(R.id.nine);
        button9.setOnClickListener(this);
        Button button0 = findViewById(R.id.zero);
        button0.setOnClickListener(this);
        Button buttonAdd = findViewById(R.id.addition);
        buttonAdd.setOnClickListener(this);
        Button buttonSub = findViewById(R.id.subtraction);
        buttonSub.setOnClickListener(this);
        Button buttonDiv = findViewById(R.id.division);
        buttonDiv.setOnClickListener(this);
        Button buttonMult = findViewById(R.id.multiplication);
        buttonMult.setOnClickListener(this);
        Button buttonPoint = findViewById(R.id.point);
        buttonPoint.setOnClickListener(this);
        Button buttonClear = findViewById(R.id.clear);
        buttonClear.setOnClickListener(this);
        Button buttonEqual = findViewById(R.id.equal);
        buttonEqual.setOnClickListener(this);
        Button buttonSign = findViewById(R.id.sign);
        buttonSign.setOnClickListener(this);
        Button buttonRemove = findViewById(R.id.remove);
        buttonRemove.setOnClickListener(this);


        sin = findViewById(R.id.sin);
        sin.setOnClickListener(this);
        cos = findViewById(R.id.cos);
        cos.setOnClickListener(this);
        tg = findViewById(R.id.tg);
        tg.setOnClickListener(this);
        ctg = findViewById(R.id.ctg);
        ctg.setOnClickListener(this);
        Toast.makeText(this, "switched", Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            Data.getInstance().setOrientation(1);
//        }
//        else Data.getInstance().setOrientation(0);
//        Toast.makeText(context, ""+Data.getInstance().getOrientation(), Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void onClick(View v) {
        text = findViewById(R.id.output);
        String[] equation;

        switch (v.getId()) {
            case R.id.one:
                if (text.getText().toString().contains("="))
                    text.setText("1");
                else
                    text.append("1");
                break;
            case R.id.two:
                if (text.getText().toString().contains("="))
                    text.setText("2");
                else
                    text.append("2");
                break;
            case R.id.three:
                if (text.getText().toString().contains("="))
                    text.setText("3");
                else
                    text.append("3");
                break;
            case R.id.four:
                if (text.getText().toString().contains("="))
                    text.setText("4");
                else
                    text.append("4");
                break;
            case R.id.five:
                if (text.getText().toString().contains("="))
                    text.setText("5");
                else
                    text.append("5");
                break;
            case R.id.six:
                if (text.getText().toString().contains("="))
                    text.setText("6");
                else
                    text.append("6");
                break;
            case R.id.seven:
                if (text.getText().toString().contains("="))
                    text.setText("7");
                else
                    text.append("7");
                break;
            case R.id.eight:
                if (text.getText().toString().contains("="))
                    text.setText("8");
                else
                    text.append("8");
                break;
            case R.id.nine:
                if (text.getText().toString().contains("="))
                    text.setText("9");
                else
                    text.append("9");
                break;
            case R.id.zero:
                equation = text.getText().toString().split(" ");
                if (!text.getText().toString().isEmpty() && !text.getText().toString().contains("=") && equation.length != 2) {
                    text.append("0");
                }
                break;
            case R.id.point:
                equation = text.getText().toString().split(" ");
                if (!text.getText().toString().isEmpty() && !text.getText().toString().contains("=")) {
                    if (equation.length == 1 && equation[0].length() > 0 && !equation[0].contains(".")) {
                        text.append(".");
                    }
                    else if (equation.length == 3 && equation[2].length() > 0 && !equation[2].contains(".")) {
                        text.append(".");
                    }
                }
                break;
            case R.id.sign:
                if (text.getText().toString().isEmpty()) break;
                if (!startsWithTrig()) {
                    if (text.getText().toString().contains("-")) {
                        text.setText(text.getText().toString().substring(0, 4) + text.getText().toString().substring(5));
                    }
                    else {
                        text.setText(text.getText().toString().substring(0, 4) + "-" + text.getText().toString().substring(4));
                    }
                    break;
                }
                equation = text.getText().toString().split(" ");
                if (!text.getText().toString().isEmpty() && !text.getText().toString().contains("=")) {
                    if (equation.length == 1 && equation[0].length() > 0) {
                        if (!equation[0].contains("-")) {
                            text.setText("-" + text.getText());
                        }
                        else {
                            text.setText(text.getText().subSequence(1, text.getText().length()));
                        }
                    }
                    else if (equation.length == 3 && equation[2].length() > 0) {
                        if (!equation[2].contains("-")) {
                            text.setText(equation[0] + " " + equation[1] + " -" + equation[2]);
                        }
                        else {
                            text.setText(equation[0] + " " + equation[1] + " " + equation[2].substring(1));
                        }
                    }
                }
                break;
            case R.id.remove:
                if (text.getText().toString().isEmpty()) break;
                if (!equalsTrig()) {
                    text.setText("");
                    break;
                }
                if (text.getText().charAt(text.getText().length()-1) != ' ') {
                    text.setText(text.getText().subSequence(0, text.getText().length() - 1));
                }
                else if (text.getText().charAt(text.getText().length()-1) == ' ') {
                    text.setText(text.getText().subSequence(0, text.getText().length() - 3));
                }
                break;
            case R.id.clear:
                text.setText("");
                break;
            case R.id.equal:
                if (!text.getText().toString().isEmpty()) {
                    if (text.getText().toString().charAt(
                            text.getText().toString().length() - 1) == '.') text.append("0");
                    if (text.getText().toString().startsWith("sin(")) {
                        String number = text.getText().toString().substring(4);
                        if (number.equals("")) return;
                        try {
                            text.append(") = " + String.format("%.3f", sin(Math.round(Double.parseDouble(number)))));
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "неверная запись внутри скобок", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        return;
                    }
                    if (text.getText().toString().startsWith("cos(")) {
                        String number = text.getText().toString().substring(4);
                        if (number.equals("")) return;
                        try {
                            text.append(") = " + String.format("%.3f", cos(Math.round(Double.parseDouble(number)))));
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "неверная запись внутри скобок", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        return;
                    }
                    if (text.getText().toString().startsWith("tan(")) {
                        String number = text.getText().toString().substring(4);
                        if (number.equals("")) return;
                        try {
                            text.append(") = " + String.format("%.3f", tg(Math.round(Double.parseDouble(number)))));
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "неверная запись внутри скобок", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        return;
                    }
                    if (text.getText().toString().startsWith("ctg(")) {
                        String number = text.getText().toString().substring(4);
                        if (number.equals("")) return;
                        try {
                            text.append(") = " + String.format("%.3f", ctg(Math.round(Double.parseDouble(number)))));
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "неверная запись внутри скобок", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        return;
                    }

                    equation = text.getText().toString().split(" ");
                    if (equation.length != 3) {
                        Toast.makeText(this, "неверное выражение", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    try {
                        number1 = Double.parseDouble(equation[0]);
                        number2 = Double.parseDouble(equation[2]);

                        switch (equation[1]) {
                            case "+":
                                text.append(" = " + (calc.sum(number1, number2)));
                                break;
                            case "-":
                                text.append(" = " + (calc.subtraction(number1, number2)));
                                break;
                            case "*":
                                text.append(" = " + (calc.multiplication(number1, number2)));
                                break;
                            case "/":
                                text.append(" = " + (calc.division(number1, number2)));
                                break;
                        }
                    } catch (NumberFormatException ex) {
                    }
                }
                break;
            case R.id.sin:
                if (text.getText().toString().isEmpty()) {
                    text.append("sin(");
                }
                break;
            case R.id.cos:
                if (text.getText().toString().isEmpty()) {
                    text.append("cos(");
                }
                break;
            case R.id.tg:
                if (text.getText().toString().isEmpty()) {
                    text.append("tan(");
                }
                break;
            case R.id.ctg:
                if (text.getText().toString().isEmpty()) {
                    text.append("ctg(");
                }
                break;
            default:
                if (!text.getText().toString().isEmpty() && startsWithTrig()) {
                    try {
                        if (text.getText().toString().charAt(
                                text.getText().toString().length() - 1) == '.') text.append("0");

                        Double.parseDouble(text.getText().toString());

                        switch (v.getId()) {
                            case R.id.addition:
                                text.append(" + ");
                                break;
                            case R.id.subtraction:
                                text.append(" - ");
                                break;
                            case R.id.multiplication:
                                text.append(" * ");
                                break;
                            case R.id.division:
                                text.append(" / ");
                                break;
                        }
                    } catch (NumberFormatException ex) {
                    }
                }
        }
    }

    private boolean startsWithTrig() {
        return !text.getText().toString().startsWith("sin(")
                && !text.getText().toString().startsWith("cos(")
                && !text.getText().toString().startsWith("tan(")
                && !text.getText().toString().startsWith("ctg(");
        //true - no trig
        //false - one of trigs
    }

    private boolean equalsTrig() {
        return !text.getText().toString().equals("sin(")
                && !text.getText().toString().equals("cos(")
                && !text.getText().toString().equals("tan(")
                && !text.getText().toString().equals("ctg(");
        //true - no trig
        //false - one of trigs
    }

    double sin(double number) {
        String jarPath = getFilesDir().getPath() + "/dyn.dex";

        final DexClassLoader classLoader = new DexClassLoader(jarPath, getCacheDir().getAbsolutePath(), null, this.getClass().getClassLoader());

        try {
            Class<?> calcClass = classLoader.loadClass("com.example.dyn.ExtendedCalculations");
            Method method = calcClass.getDeclaredMethod("sin", double.class);
            Constructor<?> constr = calcClass.getConstructor();
            Object obj = constr.newInstance();
            return (double) method.invoke(obj, number);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    double cos(double number) {
        String jarPath = getFilesDir().getPath() + "/dyn.dex";

        final DexClassLoader classLoader = new DexClassLoader(jarPath, getCacheDir().getAbsolutePath(), null, this.getClass().getClassLoader());

        try {
            Class<?> calcClass = classLoader.loadClass("com.example.dyn.ExtendedCalculations");
            Method method = calcClass.getDeclaredMethod("cos", double.class);
            Constructor<?> constr = calcClass.getConstructor();
            Object obj = constr.newInstance();
            return (double) method.invoke(obj, number);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    double tg(double number) {
        String jarPath = getFilesDir().getPath() + "/dyn.dex";

        final DexClassLoader classLoader = new DexClassLoader(jarPath, getCacheDir().getAbsolutePath(), null, this.getClass().getClassLoader());

        try {
            Class<?> calcClass = classLoader.loadClass("com.example.dyn.ExtendedCalculations");
            Method method = calcClass.getDeclaredMethod("tg", double.class);
            Constructor<?> constr = calcClass.getConstructor();
            Object obj = constr.newInstance();
            return (double) method.invoke(obj, number);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    double ctg(double number) {
        String jarPath = getFilesDir().getPath() + "/dyn.dex";

        final DexClassLoader classLoader = new DexClassLoader(jarPath, getCacheDir().getAbsolutePath(), null, this.getClass().getClassLoader());

        try {
            Class<?> calcClass = classLoader.loadClass("com.example.dyn.ExtendedCalculations");
            Method method = calcClass.getDeclaredMethod("ctg", double.class);
            Constructor<?> constr = calcClass.getConstructor();
            Object obj = constr.newInstance();
            return (double) method.invoke(obj, number);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}