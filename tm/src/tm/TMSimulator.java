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
            String strLine = br.readLine();

            // create new TM
            TM tm = new TM();
            String currentState = "";
            int iterations = 0;     // number of times the while loop has looped
            int numStates = 0;
            int statesThatHaveTransitions = 0;  // increment the state to add transition to
            int numSigma = 0;   // number of characters in the alphabet
            String toState = ""; // to state to pass into addTransition
            char writeChar = 'z'; // onSymb to pass into addTransition
            char direction = 'j'; // direction to pass into addTransition

            while (strLine != null) {

                // read and add states
                if (iterations == 0) {
                    for (int i = 0; i < Integer.parseInt(strLine); i++) {
                        tm.addState(Integer.toString(i));
                    }
                    strLine = br.readLine();
                }

                // read and add sigma
                if (iterations == 1) {
                    for (int i = 0; i <= Integer.parseInt(strLine); i++) {
                        tm.addSigma((char) i);
                        numSigma++;
                    }
                    strLine = br.readLine();
                }

                // read and add transitions
                if (iterations > 1) {
                    // iterate as many times as there are sigma characters
                    for (int i = 0; i < numSigma; i++) {
                        // call tm.addTransition with the following things:
                        // get current state (changes every 4 sigmas) (string)
                        currentState = Integer.toString(statesThatHaveTransitions);
                        if (i == (numSigma - 1)) {
                            statesThatHaveTransitions++;
                        }

                        toState = String.valueOf(strLine.charAt(0));
                        writeChar = strLine.charAt(2);
                        direction = strLine.charAt(4);

                        System.out.println("fromState: " + currentState + ", onSymb: " + i
                                + ", toState: " + toState + ", writeChar: " + writeChar + ", direction: " + direction);

                        tm.addTransition(currentState, (char) i, toState, writeChar, direction);
                        strLine = br.readLine();
//                        System.out.println(i);
//                        System.out.println(strLine);
                    }
                }


                iterations++;
//                System.out.println(strLine);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
