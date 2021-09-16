package api;

public class WhatsAppVerification {
    private String number,otp;
    public WhatsAppVerification(){

    }
    public WhatsAppVerification(String number, String otp){
        this.number=number;
        this.otp=otp;
    }

    public String getNumber() {
        return number;
    }

    public String getOtp() {
        return otp;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
