import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class DecodeLabs_Java_P4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Exchange rates based on USD
        BigDecimal USD = new BigDecimal("1.0");
        BigDecimal EUR = new BigDecimal("0.92");
        BigDecimal INR = new BigDecimal("83.50");
        BigDecimal GBP = new BigDecimal("0.79");
        BigDecimal JPY = new BigDecimal("149.50");
        BigDecimal AUD = new BigDecimal("1.52");

        boolean running = true;

        System.out.println("======================================");
        System.out.println("       DECODE LABS - CURRENCY         ");
        System.out.println("             CONVERTER                ");
        System.out.println("======================================");

        while (running) {

            try {
                System.out.println("\nSupported currencies:");
                System.out.println("USD  EUR  INR  GBP  JPY  AUD");

                System.out.print("\nEnter source currency: ");
                String source = sc.next().toUpperCase();

                System.out.print("Enter target currency: ");
                String target = sc.next().toUpperCase();

                System.out.print("Enter amount: ");
                BigDecimal amount = sc.nextBigDecimal();

                // Security Gate
                if (amount.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("Error: Amount cannot be negative.");
                    continue;
                }

                BigDecimal sourceRate;
                BigDecimal targetRate;

                // Source currency rate
                switch (source) {
                    case "USD":
                        sourceRate = USD;
                        break;
                    case "EUR":
                        sourceRate = EUR;
                        break;
                    case "INR":
                        sourceRate = INR;
                        break;
                    case "GBP":
                        sourceRate = GBP;
                        break;
                    case "JPY":
                        sourceRate = JPY;
                        break;
                    case "AUD":
                        sourceRate = AUD;
                        break;
                    default:
                        System.out.println("Invalid source currency.");
                        continue;
                }

                // Target currency rate
                switch (target) {
                    case "USD":
                        targetRate = USD;
                        break;
                    case "EUR":
                        targetRate = EUR;
                        break;
                    case "INR":
                        targetRate = INR;
                        break;
                    case "GBP":
                        targetRate = GBP;
                        break;
                    case "JPY":
                        targetRate = JPY;
                        break;
                    case "AUD":
                        targetRate = AUD;
                        break;
                    default:
                        System.out.println("Invalid target currency.");
                        continue;
                }

                // Convert source -> USD -> target
                BigDecimal usdAmount = amount.divide(
                        sourceRate, 10, RoundingMode.HALF_UP
                );

                BigDecimal convertedAmount = usdAmount.multiply(targetRate);

                convertedAmount = convertedAmount.setScale(
                        2, RoundingMode.HALF_UP
                );

                System.out.println("\n--------------------------------------");
                System.out.printf(
                        "Converted Amount: %s %s%n",
                        convertedAmount.toPlainString(),
                        target
                );
                System.out.println("--------------------------------------");

            } catch (java.util.InputMismatchException e) {

                System.out.println(
                        "Invalid input! Please enter a valid number."
                );

                // Clear invalid Scanner input
                sc.nextLine();
            }

            System.out.print("\nDo you want another conversion? (yes/no): ");
            String choice = sc.next().toLowerCase();

            if (!choice.equals("yes")) {
                running = false;
            }
        }

        System.out.println("\nThank you for using Currency Converter!");
        sc.close();
    }
}