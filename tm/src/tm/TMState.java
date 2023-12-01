package tm;

import java.util.*;

public class TMState extends State {

    public String name;
    private Map<Character, Object[]> transitions; // Object[] holds all transition info

    /**
     * Constructor to each State's multiple path options
     *
     * @param name - name of state
     */
    public TMState(String name) {
        super(name);
        this.name = name;
        this.transitions = new HashMap<>();
    }

    /**
     * If transitions contain the transition character,
     * get the Object[] and add transition information to it.
     * Otherwise, create a new Object[] with transition details.
     *
     * @param onSymb - transition character
     * @param toState - state transitioning to
     * @param writeSymb - symbol to write on tape
     * @param direction - direction to move the tape head
     */
    public void addTransition(char onSymb, TMState toState, char writeSymb, char direction) {
        if (transitions.containsKey(onSymb)) {
            Object[] transitionInfo = transitions.get(onSymb);
            // in the file: toState, writeSymb, direction
            transitionInfo[0] = toState;
            transitionInfo[1] = writeSymb;
            transitionInfo[2] = direction;
        } else {
            Object[] newTransition = new Object[]{toState, writeSymb, direction};
            transitions.put(onSymb, newTransition);
        }
    }

    /**
     * getTransition() returns the transition map
     *
     * @return - transitions
     */
    public Map<Character, Object[]> getTransitions() {
        return transitions;
    }

    /**
     * toString for an TM State returns name of the state
     *
     * @return - name
     */
    public String toString() {
        return name;
    }

}
