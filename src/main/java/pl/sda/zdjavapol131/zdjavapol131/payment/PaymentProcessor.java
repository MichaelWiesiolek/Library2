package pl.sda.zdjavapol131.zdjavapol131.payment;

import java.util.Scanner;
interface PaymentProcessor {
    void processPayment(double amount);
    void refundPayment(double amount);
}
 class PaymentsProcessor implements PaymentProcessor{
    @Override
    public void processPayment(double amount){
        // Logika przetwarzania płatności przez PayPal
        System.out.println("Processing PayPal payment: $" + amount);
    }


    @Override
    public void refundPayment(double amount) {
        // Logika zwrotu płatności przez PayPal
        System.out.println("Refunding PayPal payment: $" + amount);
    }
  //  // Klasa implementująca procesor płatności za pośrednictwem Stripe
  //  public class StripePaymentProcessor implements PaymentProcessor {
  //      @Override
  //      public void processPayment(double amount) {
  //          // Logika przetwarzania płatności przez Stripe
  //          System.out.println("Processing Stripe payment: $" + amount);
  //      }
//
  //      @Override
  //      public void refundPayment(double amount) {
  //          // Logika zwrotu płatności przez Stripe
  //          System.out.println("Refunding Stripe payment: $" + amount);
  //      }
  //  }

    // Klasa reprezentująca system płatności
    class PaymentSystem {
        private PaymentProcessor paymentProcessor;

        public PaymentSystem(PaymentProcessor paymentProcessor) {
            this.paymentProcessor = paymentProcessor;
        }

        public void processPayment(double amount) {
            paymentProcessor.processPayment(amount);
        }

        public void refundPayment(double amount) {
            paymentProcessor.refundPayment(amount);
        }
    }

    // Klasa główna
    public class Main {
        public void main(String[] args) {
            // Inicjalizacja systemu płatności
            PaymentProcessor paymentProcessor = new PayPalPaymentProcessor(); // lub StripePaymentProcessor
            PaymentSystem paymentSystem = new PaymentSystem(paymentProcessor);

            // Przykładowe użycie systemu płatności
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter payment amount: ");
            double amount = scanner.nextDouble();

            paymentSystem.processPayment(amount);

            // Możliwość zwrotu płatności
            System.out.print("Do you want to refund the payment? (Y/N): ");
            String refundChoice = scanner.next();

            if (refundChoice.equalsIgnoreCase("Y")) {
                paymentSystem.refundPayment(amount);
            }
        }
}
}
