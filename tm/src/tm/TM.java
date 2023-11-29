package tm;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class TM implements TMInterface {

    /* Instance Variables */
    public LinkedHashSet<Character> sigma;
    public LinkedHashSet<TMState> states;
    public String startState;
    public LinkedHashSet<TMState> finalState;
    public String q0;

    /**
     * Constructor for Turing Machine (TM)
     * Initiates TM 6-tuple
     */
    public TM() {
        sigma = new LinkedHashSet<>();
        states = new LinkedHashSet<>();
        startState = "0";
        q0 = "0";
        finalState = new LinkedHashSet<>();;
    }

    @Override
    public boolean addState(String name) {
        boolean retVal = false;
        TMState newState = new TMState(name);
        if(states.isEmpty()) {
            states.add(newState);
            retVal = true;
        } else {
            for(TMState s : states) {
                if(s.toString().equals(name)) { // if there is already a state with 'name'
                    return retVal;
                }
            }
        }
        if(!retVal) { // if state created successfully
            states.add(newState);
            retVal = true;
        }
        return retVal;
    }

    @Override
    public boolean setFinal(String name) {
        boolean retVal = false;
        boolean done = false;
        TMState newState = new TMState(name);
        if (states.isEmpty()) {
            return retVal;
        } else {
            while (!done) {
                for (TMState s : states) {
                    if (s.toString().equals(name)) {
                        finalState.add(newState);
                        retVal = true; // successfully added 'name' to finalStates
                        break;
                    } else {
                        retVal = false; // no state with 'name' exists
                    }
                }
                done = true;
            }
        }
        return retVal;
    }

    @Override
    public boolean setStart(String name) {
        boolean retVal = false;
        boolean done = false;
        if (states.isEmpty()) {
            return retVal;
        } else {
            while (!done) {
                for (TMState s : states) {
                    if (s.toString().equals(name)) {
                        startState = name;
                        retVal = true; // successfully set 'name' to startState
                        break;
                    } else {
                        retVal = false; // no state with 'name' exists
                    }
                }
                done = true;
            }
        }
        return retVal;
    }

    /**
     * Adds a transition to the TM
     *
     * @param fromState - state transitioning from
     * @param onSymb - transitions on this character
     * @param toState - state transitioning to on onSymb
     * @param writeChar - character written to tape
     * @param direction - direction moved on tape
     */
    public void addTransition(String fromState, char onSymb, String toState, char writeChar, char direction) {
        TMState goToState = new TMState("");

        // find toState
        for (TMState s : states) {
            if (s.getName().equals(toState)) {
                goToState = s;
            }
        }

        // find fromState and add transition to it with parsed values
        for (TMState s : states) {
            if (s.getName().equals(fromState)) {
                s.addTransition(onSymb, goToState, writeChar, direction);
            }
        }

        // might have to write to the tape (linkedlist) in this method
    }

    @Override
    public void addSigma(char symbol) {
        sigma.add(symbol);
    }

    @Override
    public String accepts(String s) {
        return "";
    }

    @Override
    public Set<Character> getSigma() {
        return sigma;
    }

    @Override
    public tm.State getState(String name) {
        for (TMState s : states) {
            if (s.toString().equals(name)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean isFinal(String name) {
        boolean retVal = false;
        for (TMState s : finalState) {
            if (s.toString().equals(name)) {
                retVal = true;
                break;
            }
        }
        return retVal;
    }

    @Override
    public boolean isStart(String name) {
        return startState.equals(name);
    }
}