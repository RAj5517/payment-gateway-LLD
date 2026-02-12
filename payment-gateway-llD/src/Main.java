import com.payment.controller.PaymentController;
import com.payment.factory.GatewayType;
import com.payment.model.PaymentRequest;

public class Main {

    public static void main(String[] args) {

        PaymentController controller = new PaymentController();

        PaymentRequest request =
                new PaymentRequest("Raj", "Shubham", 1000, "INR");

        boolean result = controller.handlePayment(
                GatewayType.PAYTM,
                request
        );

        System.out.println("Payment Result: " + result);
    }
}
