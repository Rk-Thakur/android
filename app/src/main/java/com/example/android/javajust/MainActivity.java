package com.example.android.javajust;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView textview = new TextView(this);
//        textview.setTextSize(23);
//        textview.setTextColor(Color.GREEN);
//        setContentView(textview);
    }
    public void submitOrder(View view){
        CheckBox whippedcheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox choclatecheckbox = (CheckBox) findViewById(R.id.choclate_checkbox);
        Boolean hasWhippedCream = whippedcheckbox.isChecked();
        Boolean hasChoclate = choclatecheckbox.isChecked();
        EditText name = (EditText) findViewById(R.id.name);
        String user = name.getText().toString();
                int price= calculatePrice();
                int choclateprice = calculatechoclate();
                String priceMessage = createOrderSummary(user,price,choclateprice,hasWhippedCream,hasChoclate);
                displayMessage(priceMessage);
                display(quantity);
                displaychoclate(choclatenumber);
    }

    private String createOrderSummary(String user, int price, int choclateprice, boolean addWhippedCream, boolean addchoclate){

    String priceMessage  = "Name:"+user;
    if(addWhippedCream == addchoclate){
        priceMessage +="\n Whipped Cream and Choclate";
        priceMessage +="\n Whipped No: "+quantity;
        priceMessage +="\n Whipped Cream: "+"$"+price;
        priceMessage +="\n Choclate No: "+choclatenumber;
        priceMessage +="\n  Choclate: "+"$"+choclateprice;
        priceMessage +="\n  Total: "+"$"+(choclateprice+price);
    }else{
        if(addWhippedCream){
            priceMessage +="\n Whipped No: "+quantity;
            priceMessage +="\n Whipped Cream: "+"$"+price;
        }
        if(addchoclate){
            priceMessage +="\n Choclate No: "+choclatenumber;
            priceMessage +="\n Choclate: "+"$"+choclateprice;
        }
    }

    priceMessage +="\n Please Place an Another Order,Thankyou!!";
    return priceMessage;
    }

    private int calculatePrice(){
        return quantity * 5 ;
    }

    private int calculatechoclate(){
        return choclatenumber * 4 ;
    }
    int quantity=0;
    public void increment(View view){
        quantity= quantity + 1;
        display(quantity);
    }
    public void decrement(View view){
        quantity= quantity - 1;
        display(quantity);
    }
    private void display(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText(" "+number);
    }
    int choclatenumber = 0;
    public void incrementchoclate(View view){
        choclatenumber= choclatenumber + 1;
        displaychoclate(choclatenumber);
    }
    public void decrementchoclate(View view){
        choclatenumber= choclatenumber - 1;
        displaychoclate(choclatenumber);
    }
    private void displaychoclate(int choclatenumber){
        TextView choclateTextView = (TextView) findViewById(R.id.choclate_textview);
        choclateTextView.setText(" "+choclatenumber);
    }

//    private void displayPrice(int number){
//        TextView ordersummarytextview = (TextView) findViewById((R.id.order_summary_text_view));
////        priceTextView.setText("$"+number);
//            //it will give the number with a currency symbol
//        ordersummarytextview.setText(NumberFormat.getCurrencyInstance().format(number));
//    }


    private void displayMessage(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.price_text_view);
        orderSummaryTextView.setText(message);
    }


}