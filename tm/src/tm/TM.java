package tm;

import java.util.LinkedHashSet;
import java.util.Set;

public class TM implements TMInterface {

    /* Instance Variables */
    public LinkedHashSet<Character> sigma;
    public LinkedHashSet<TMState> states;
    public String startState;
    public String finalState;
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
        finalState = "";
    }

    @Override
    public boolean addState(String name) {
        return false;
    }

    @Override
    public boolean setFinal(String name) {
        return false;
    }

    @Override
    public boolean setStart(String name) {
        return false;
    }

    @Override
    public void addSigma(char symbol) {

    }

    @Override
    public boolean accepts(String s) {
        return false;
    }

    @Override
    public Set<Character> getSigma() {
        return null;
    }

    @Override
    public tm.State getState(String name) {
        return null;
    }

    @Override
    public boolean isFinal(String name) {
        return false;
    }

    @Override
    public boolean isStart(String name) {
        return false;
    }
}