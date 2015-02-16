package com.ericvogl.greatestcommondivisor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.ericvogl.greatestcommondivisor.calculator.EuclidGcdCalculator;
import com.ericvogl.greatestcommondivisor.calculator.GcdCalculator;
import com.ericvogl.greatestcommondivisor.math.Integers;
import com.google.common.base.Optional;

import java.text.NumberFormat;


public class Calculate extends ActionBarActivity {

    private EditText _firstNumber;
    private EditText _secondNumber;
    private TextView _greatestCommonDivisor;
    private GcdCalculator _calculator = new EuclidGcdCalculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        _firstNumber = (EditText)findViewById(R.id.editFirstNumber);
        _secondNumber = (EditText)findViewById(R.id.editSecondNumber);
        _firstNumber.addTextChangedListener(new CalculatorTextWatcher());
        _secondNumber.addTextChangedListener(new CalculatorTextWatcher());
        _greatestCommonDivisor = (TextView)findViewById(R.id.textGreatestCommonDivisor);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class CalculatorTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            Optional<Integer> a = Integers.tryParse(_firstNumber.getText().toString());
            Optional<Integer> b = Integers.tryParse(_secondNumber.getText().toString());
            if (a.isPresent() && b.isPresent()) {
                _greatestCommonDivisor.setText(NumberFormat.getInstance().format(_calculator.calculate(a.get(), b.get())));
            } else {
                _greatestCommonDivisor.setText("");
            }
        }
    }
}
