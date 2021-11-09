package com.alicumber.versatile.vip;

import static com.android.billingclient.api.BillingClient.SkuType.INAPP;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.alicumber.versatile.R;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;

import java.util.List;

public class InapppucharseActivity extends AppCompatActivity implements PurchasesUpdatedListener {
    private TextView tvStatus;
    private Button bPucharse;


    public static final String PREF_FILE= "MyPref";
    public static final String PURCHASE_KEY= "purchase";
    public static final String PRODUCT_ID= "purchase";

    private BillingClient billingClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inapppucharse);
        tvStatus = (TextView) findViewById(R.id.activity_inapppucharse_tv_status);
        bPucharse = (Button) findViewById(R.id.activity_inapppucharse_b_pucharse);
        billingClient = BillingClient.newBuilder(this).enablePendingPurchases().build();
        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingSetupFinished(@NonNull BillingResult billingResult) {
                if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                    Purchase.PurchasesResult queryPuchar = billingClient.queryPurchases(INAPP);
                    List<Purchase> queryPurchases = queryPuchar.getPurchasesList();
                    if (queryPurchases != null && queryPurchases.size() > 0) {
//                    handlePurchases(queryPurchases);
                    } else {
//                        savedInstanceState(false);
                    }

                }
            }

            @Override
            public void onBillingServiceDisconnected() {
            }
        });

    // item Purchase
//        if()



    }









    @Override
    public void onPurchasesUpdated(@NonNull BillingResult billingResult, @Nullable List<Purchase> list) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}