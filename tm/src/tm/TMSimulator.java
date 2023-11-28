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

            // create new TM
            TM tm = new TM();
            int iterations = 0;

            while ((strLine = br.readLine()) != null) {

                // read and add states
                if (iterations == 0) {
                    for (int i = 0; i < Integer.parseInt(strLine); i++) {
                        tm.addState(Integer.toString(i));
                    }
                }

                // read and add sigma
                if (iterations == 1) {
                    for (int i = 0; i <= Integer.parseInt(strLine); i++) {
                        tm.addSigma((char) i);
                    }
                }

                // read and add transitions


                iterations++;
                System.out.println(strLine);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
