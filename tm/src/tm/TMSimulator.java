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
            TMState currentState = new TMState("");
            int iterations = 0;
            int numStates = 0;
            int statesAdded = 0;
            int numSigma = 0;

            while ((strLine = br.readLine()) != null) {

                // if numsigma is 0, set to 3

                // read and add states
                if (iterations == 0) {
//                    numStates = Integer.parseInt(strLine);
                    for (int i = 0; i < Integer.parseInt(strLine); i++) {
                        tm.addState(Integer.toString(i));
                        System.out.println("State added: " + i);
                    }
                }

                // read and add sigma
                if (iterations == 1) {
                    for (int i = 0; i <= Integer.parseInt(strLine); i++) {
                        tm.addSigma((char) i);
                        numSigma++;
                    }
                }

                // read and add transitions
                if (iterations > 1) {
                    // iterate as many times as there are sigma characters
                    for (int i = 0; i < numSigma; i++) {
                        // call tm.addTransition with the following things:
                        // get current state (changes every 4 sigmas)
                        // get onSymb (should just be i)
                        // get toState (first value of readLine()) - use a delimiter ','??"
                        // get character to write (second value of readLine())
                        // get direction (third value of readLine())
                    }
                }


                iterations++;
                System.out.println(strLine);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
