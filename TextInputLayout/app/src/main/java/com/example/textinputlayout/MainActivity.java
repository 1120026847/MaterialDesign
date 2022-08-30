package com.example.textinputlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String TAG="moli";
        TextInputLayout inputLayoutName=findViewById(R.id.InputLayoutName);
        TextInputEditText inputEditName=findViewById(R.id.inputEditName);
        TextInputLayout inputLayoutPassword=findViewById(R.id.inputLayoutPassword);
        //设置文本监听
inputEditName.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Log.e(TAG, "beforeTextChanged: " );
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Log.e(TAG, "onTextChanged: ");
    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (inputLayoutName.getEditText().getText().length()>inputLayoutName.getCounterMaxLength()){
inputLayoutName.setError("输入内容超过上限");
        }else {
            inputLayoutName.setError(null);
        }

    }
});
    }
}