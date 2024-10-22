
interface PaymentGateway {
    void processPayment();
}

class CreditCardPayment implements PaymentGateway {
    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment...");
    }
}

class PayPalPayment implements PaymentGateway {
    @Override
    public void processPayment() {
        System.out.println("Processing PayPal payment...");
    }
}
class BankTransferPayment implements PaymentGateway {
    @Override
    public void processPayment() {
        System.out.println("Processing bank transfer payment...");
    }
}

abstract class PaymentFactory {
    abstract PaymentGateway createPaymentGateway();
}

class CreditCardFactory extends PaymentFactory {
    @Override
    PaymentGateway createPaymentGateway() {
        return new CreditCardPayment();
    }
}

class PayPalFactory extends PaymentFactory {
    @Override
    PaymentGateway createPaymentGateway() {
        return new PayPalPayment();
    }
}

class BankTransferFactory extends PaymentFactory {
    @Override
    PaymentGateway createPaymentGateway() {
        return new BankTransferPayment();
    }
}

public class paymentsystem {
    public static void main(String[] args) {
        PaymentFactory paymentFactory;
        String userInput = "PayPal";

        if (userInput.equals("CreditCard")) {
            paymentFactory = new CreditCardFactory();
        } else if (userInput.equals("PayPal")) {
            paymentFactory = new PayPalFactory();
        } else {
            paymentFactory = new BankTransferFactory();
        }

        PaymentGateway gateway = paymentFactory.createPaymentGateway();
        gateway.processPayment();
    }
}


