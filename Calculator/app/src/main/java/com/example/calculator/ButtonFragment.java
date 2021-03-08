package com.example.calculator;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ButtonFragment extends Fragment implements View.OnClickListener{
    private double number1, number2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.button_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button button1 = getView().findViewById(R.id.one);
        button1.setOnClickListener(this);
        Button button2 = getView().findViewById(R.id.two);
        button2.setOnClickListener(this);
        Button button3 = getView().findViewById(R.id.three);
        button3.setOnClickListener(this);
        Button button4 = getView().findViewById(R.id.four);
        button4.setOnClickListener(this);
        Button button5 = getView().findViewById(R.id.five);
        button5.setOnClickListener(this);
        Button button6 = getView().findViewById(R.id.six);
        button6.setOnClickListener(this);
        Button button7 = getView().findViewById(R.id.seven );
        button7.setOnClickListener(this);
        Button button8 = getView().findViewById(R.id.eight);
        button8.setOnClickListener(this);
        Button button9 = getView().findViewById(R.id.nine);
        button9.setOnClickListener(this);
        Button button0 = getView().findViewById(R.id.zero);
        button0.setOnClickListener(this);
        Button buttonAdd = getView().findViewById(R.id.addition);
        buttonAdd.setOnClickListener(this);
        Button buttonSub = getView().findViewById(R.id.subtraction);
        buttonSub.setOnClickListener(this);
        Button buttonDiv = getView().findViewById(R.id.division);
        buttonDiv.setOnClickListener(this);
        Button buttonMult = getView().findViewById(R.id.multiplication);
        buttonMult.setOnClickListener(this);
        Button buttonPoint = getView().findViewById(R.id.point);
        buttonPoint.setOnClickListener(this);
        Button buttonClear = getView().findViewById(R.id.clear);
        buttonClear.setOnClickListener(this);
        Button buttonEqual = getView().findViewById(R.id.equal);
        buttonEqual.setOnClickListener(this);
        Button buttonSign = getView().findViewById(R.id.sign);
        buttonSign.setOnClickListener(this);
        Button buttonRemove = getView().findViewById(R.id.remove);
        buttonRemove.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView text = getView().findViewById(R.id.output);
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
                    equation = text.getText().toString().split(" ");
                    if (text.getText().toString().charAt(
                            text.getText().toString().length() - 1) == '.') text.append("0");
                    try {
                        number1 = Double.parseDouble(equation[0]);
                        number2 = Double.parseDouble(equation[2]);
                        Toast.makeText(getActivity(), equation[1], Toast.LENGTH_SHORT).show();

                        switch (equation[1]) {
                            case "+":
                                text.append(" = " + (number1 + number2));
                                break;
                            case "-":
                                text.append(" = " + (number1 - number2));
                                break;
                            case "*":
                                text.append(" = " + (number1 * number2));
                                break;
                            case "/":
                                text.append(" = " + (number1 / number2));
                                break;
                        }
                    } catch (NumberFormatException ex) {
                        Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
                if (!text.getText().toString().isEmpty()) {
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
                        Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        }
    }
}
