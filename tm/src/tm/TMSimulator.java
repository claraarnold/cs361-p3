package tm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class TMSimulator {
    public static void main(String[] args) {

        if (args.length != 1) {
                System.err.println("Single command line argument expected");
                System.exit(1);
        }

        try {
            FileInputStream fstream = new FileInputStream(args[0]);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;

            while ((strLine = br.readLine()) != null) {

                // read and add states

                // read and add sigma

                // read and add transitions


                System.out.println(strLine);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
