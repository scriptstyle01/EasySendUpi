package open.upi.easysendupi;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import dev.shreyaspatil.easyupipayment.EasyUpiPayment;
import dev.shreyaspatil.easyupipayment.listener.PaymentStatusListener;
import dev.shreyaspatil.easyupipayment.model.PaymentApp;
import dev.shreyaspatil.easyupipayment.model.TransactionDetails;

public class EasySendUpi implements PaymentStatusListener {
    private final EasyUpiPayment.Builder builder;
    private EasyUpiPayment easyUpiPayment;
    PaymentApp paymentApp;
    Activity activity;

    public EasySendUpi(Activity activity) {
        this.activity = activity;
         builder = new EasyUpiPayment.Builder(activity);

    }

    private void withpay(PaymentApp paymentApp) {
        paymentApp = paymentApp;

    }
    private void setPayeeName(String payeeName) {

        builder.setPayeeName(payeeName);
    }
    private void setTransactionId(String payeeName) {

        builder.setTransactionId(payeeName);
    }
    private void setTransactionRefId(String payeeName) {

        builder.setTransactionRefId(payeeName);
    }
    private void setPayeeMerchantCode(String payeeName) {

        builder.setPayeeMerchantCode(payeeName);
    }
    private void setDescription(String payeeName) {

        builder.setDescription(payeeName);
    }
    private void setAmount(String payeeName) {

        builder.setAmount(payeeName);
    }

    private void pay(){
        try {
            // Build instance
            easyUpiPayment = builder.build();

            // Register Listener for Events
            easyUpiPayment.setPaymentStatusListener((PaymentStatusListener) activity);

            // Start payment / transaction
            easyUpiPayment.startPayment();
        } catch (Exception exception) {
            exception.printStackTrace();
            Toast.makeText(activity, "Error: "+exception.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onTransactionCompleted(TransactionDetails transactionDetails) {

    }

    @Override
    public void onTransactionCancelled() {

    }
}
