package verification;

import controller.WhatsAppController;
import util.Constants;
import util.Test;

import java.util.Scanner;

public class Verification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int scan = sc.nextInt();
        String m = sc.nextLine();
        switch (scan) {
            case Constants.WHATSAPP_VERIFICATION:
//                long epoch1=System.currentTimeMillis();
//                System.out.println(epoch1);
                String number = sc.nextLine();
                String otp = sc.nextLine();
                System.out.println(number + " " + otp);
                Thread myWhatsAppThread = new MyWhatsAppThread(number,otp);
                myWhatsAppThread.start();
//                long epoch2=System.currentTimeMillis();
//                System.out.println("----------> "+(epoch2-epoch1));
                break;
            case Constants.TEST_CASE_FOR_ALL:
                System.out.println(Test.getTimestamp());
                break;

        }

    }
    private static class MyWhatsAppThread extends Thread{
        private String number,otp;

        public MyWhatsAppThread(String number, String otp) {
            this.number = number;
            this.otp = otp;
        }

        @Override
        public void run() {
            WhatsAppController.sendNumberOtpAndVerify(number, otp);
        }
    }

}
