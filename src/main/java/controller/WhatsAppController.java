package controller;

import api.WhatsAppVerification;
import com.google.gson.Gson;
import util.Constants;

import javax.net.ServerSocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

public class WhatsAppController {
    public static void sendNumberOtpAndVerify(String number,String otp){
        try {
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            URL url = new URL(Constants.BASE_URL_DOMAIN+"/test/v1/whatsapp/verify");
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setSSLSocketFactory(sslsocketfactory);
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            WhatsAppVerification whatsAppVerification=new WhatsAppVerification();
            whatsAppVerification.setNumber(number);
            whatsAppVerification.setOtp(otp);
            String jsonInputString = new Gson().toJson(whatsAppVerification);
            System.out.println(jsonInputString);
            OutputStream os = con.getOutputStream();
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);

            if (con.getResponseCode() == con.HTTP_OK) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    String line=null;
                    StringBuilder response = new StringBuilder();
                    while ((line = bufferedReader.readLine()) != null) {
                        // ... do something with line
                        response.append(line.trim());
                    }
                    System.out.println(response.toString());
                }
            } else {
                // ... do something with unsuccessful response
                System.out.println("Unsuccessfull response || responseCode "+con.getResponseCode());
            }

        }catch (Exception e){e.printStackTrace();}
    }
}
