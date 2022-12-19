package utils;

public class MessageUtil {

    private String message;

    public MessageUtil(){
    }

    public MessageUtil(String message){
        this.message = message;
    }

    public String printMessage (){
        System.out.println(message);
        return message;
    }

    public String printDivisionMessage(int a, int b){
        int divisionResult = a / b;
        return a + "/" + b + " = " + divisionResult;
    }

}
