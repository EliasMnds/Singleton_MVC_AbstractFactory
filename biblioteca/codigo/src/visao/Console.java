package visao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    @SuppressWarnings("finally")
    public static String readLine() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";

        try {
            s = br.readLine();
        } catch(NumberFormatException nfe) {
            System.err.println("Ivalid Forma!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return s;
        }
    }

}