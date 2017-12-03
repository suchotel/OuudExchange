package com.intentprochote.exchange.ouudexchange.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.intentprochote.exchange.ouudexchange.R;

/**
 * Created by Temp on 2/12/2560.
 */

public class MainFragment extends Fragment{
    //    Explicit ประกาศตัวแปร
    private RadioGroup radioGroup;
    private RadioButton usdRadioButton, thbRadioButton;
    private EditText editText;
    private Button button;



//    สร้าง Method หลักที่ใช้ในการจัดการทำงาน


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Initial View ผูกความสัมพันธ์ของตัวแปรที่ประกาศ กับใน Layout
        initialView();

//        Click USD to THB First
        clickUSDToTHBFirst();




    }  //Main Method

    private void clickUSDToTHBFirst() {
        usdRadioButton.setChecked(true);
    }

    private void initialView() {
        radioGroup = getView().findViewById(R.id.ragMoney);
        usdRadioButton = getView().findViewById(R.id.radUSD);
        thbRadioButton = getView().findViewById(R.id.radTHB);
        editText = getView().findViewById(R.id.edtMoney);
        button = getView().findViewById(R.id.butMoney);
    } //Method ที่ให้ Gen. ขี้น


//    สร้าง Fragment (หน้ากาก)


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.flegment_main,container,false);
        return view;
    }

}// End of Main Class