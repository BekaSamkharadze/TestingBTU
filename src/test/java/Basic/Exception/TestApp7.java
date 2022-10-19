package Basic.Exception;

public class TestApp7 {

    public static void main(String[] args) {
        String text = "199";
        try {
            text = text.concat(".1");
            double decimal = Double.parseDouble(text);
            text = Double.toString(decimal);
            int status = (int) Math.ceil(Double.valueOf(text));
            System.out.println(status);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
        }
    }
}

