package tm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * TMSimulator reads in an input file in order to simulate
 * a Turing Machine using the program methods
 *
 * @author claraarnold, joelathrop
 */
public class TMSimulator {
    private static TM tm;
    private static String string;
    public static void main(String[] args) {

        if (args.length != 1) {
                System.err.println("Single command line argument expected");
                System.exit(1);
        }

        try {
            FileInputStream fileStream = new FileInputStream(args[0]);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileStream));

            // create new TM
            tm = new TM();
            String currentState;
            int iterations = 0;     // number of times the while loop has looped
            int statesThatHaveTransitions = 0;  // increment the state to add transition to
            int numSigma = 0;   // number of characters in the alphabet
            int numStates = 0; // number of states
            String toState; // to state to pass into addTransition
            char writeChar; // onSymb to pass into addTransition
            char direction; // direction to pass into addTransition
            boolean stringGotSet = false;
            char onSymb;
            string = "";

            String strLine = br.readLine();
            while (strLine != null) {
                iterations++;


                // read and add states
                if (iterations == 1) {
                    for (int i = 0; i < Integer.parseInt(strLine); i++) {
                        tm.addState(Integer.toString(i));
                        numStates++;
                    }
                    strLine = br.readLine();
                }

                // read and add sigma
                 else if (iterations == 2) {
                    for (int i = 0; i <= Integer.parseInt(strLine); i++) {
                        tm.addSigma((char) i);
                        numSigma++;
                    }
                    strLine = br.readLine();
                }

                // read and add transitions
                else if (iterations > 2 && iterations <= (numStates - 1) + 2) {
                    // iterate as many times as there are sigma characters
                    for (int i = 0; i < numSigma; i++) {
                        // get current state (changes every 4 sigmas) (string)
                        currentState = Integer.toString(statesThatHaveTransitions);
                        if (i == (numSigma - 1)) {
                            statesThatHaveTransitions++;
                        }

                        toState = String.valueOf(strLine.charAt(0));
                        writeChar = strLine.charAt(2);
                        direction = strLine.charAt(4);

                        /* TESTING INPUT TAKEN CORRECTLY */
//                        System.out.println("fromState: " + currentState + ", onSymb: " + i
//                                + ", toState: " + toState + ", writeChar: " + writeChar + ", direction: " + direction);

                        if (i == 0) {
                            onSymb = '0';
                        } else {
                            onSymb = (char) ('0' + i);
                        }
                        tm.addTransition(currentState, onSymb, toState, writeChar, direction);
                        strLine = br.readLine();
                    }
                }

                else {
                    string = strLine;
                    stringGotSet = true;

                    strLine = br.readLine();
                }

            }

            if (!stringGotSet) {
                string = "0";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(tm.walkThrough(string));
    }
}
