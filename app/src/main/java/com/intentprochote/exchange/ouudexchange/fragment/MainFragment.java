package com.intentprochote.exchange.ouudexchange.fragment;

import android.content.DialogInterface;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
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
    private String moneyString;   //รับค่าที่ได้จาก text control มาเพื่อใช้กับ Java
    private double factorAdouble;
    private static double usdAdouble = 33;




//    สร้าง Method หลักที่ใช้ในการจัดการทำงาน


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Initial View ผูกความสัมพันธ์ของตัวแปรที่ประกาศ กับใน Layout
        initialView();

//        Click USD to THB First
        clickUSDToTHBFirst();

//        USD Controller
        USDController();

//        THB Controller
        THBController();

//        Exchange Controller
        exchangeController();

//        Rate Controller
        rateController();


    }  //Main Method

    private void rateController() {
        TextView textView = getView().findViewById(R.id.txtRateExchange); //ประกาศเพื่อเอามาใช้
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.ContentMainFragment, new ShowRateExchangeFragmant())
                        .addToBackStack(null).commit();


            }
        }); //ให้ใช้ T ตัวเล็ก  กด


    }

//    private void myAlertDialog(String strTitle, String strMessage) {  }


    private void exchangeController() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moneyString = editText.getText().toString().trim();

//                Check Space
                if (moneyString.isEmpty()) {
//                    Have Space
                    myAlertDialog("Have Space", "Please Fill All Blank");

                } else {
//                    No Space
                    calculate();

                }


            }
        });
    }

    private void calculate() {
        String tag = "3DecV1";
        Log.d(tag, "Factor ==> " + factorAdouble);

        double answerAdouble = Double.parseDouble(moneyString) * factorAdouble;
        //ประกาศตัวแปร answerAdouble
        myAlertDialog("Answer", "Money = " + String.format("%.2f" + " บาท",answerAdouble));



    } // calculate

    private void myAlertDialog(String strTitle, String strMessage) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();



    } //myAlert

    private void THBController() {
        thbRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setHint(getString(R.string.thb));
                factorAdouble = 1 / usdAdouble;
            }
        });
    }

    private void USDController() {
        usdRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               editText.setHint(getString(R.string.usd));
               factorAdouble = usdAdouble * 1;
            }
        });
    }

    private void clickUSDToTHBFirst() {
        usdRadioButton.setChecked(true);
        factorAdouble = usdAdouble;
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