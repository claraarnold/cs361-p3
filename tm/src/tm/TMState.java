package tm;

import java.util.*;

public class TMState extends State {

    public String name;
    private Map<Character, Object[]> transitions; // Object[] holds all transition info
    private LinkedList<Character> tape;
    private int tapeHead;

    /**
     * Constructor to each State's multiple path options
     *
     * @param name - name of state
     */
    public TMState(String name) {
        super(name);
        this.name = name;
        this.transitions = new HashMap<>();
        this.tape = new LinkedList<>();
        this.tapeHead = 0; // assuming tape head position is at 0
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
     * Handling the tape: adding character to tape, moving tape, and handling
     * exception cases using a linked list
     * TODO: tape cases
     *
     * @param writeSymb - read symbol (or write)
     * @param direction - direction to move on tape
     */
    public void addToTape(char writeSymb, char direction) {
        // Add the symbol to the current position on the tape
        tape.add(tapeHead, writeSymb);

        // Move tape head according to the direction
        if (direction == 'L') {
            // Move left
            tapeHead--;
            if (tapeHead < 0) {
                // Handle reaching the start of the tape
                // For example, extend the tape to the left or throw an exception
                // Here's a simple extension example:
                tape.addFirst('_'); // '_' represents a blank symbol or any default symbol
                tapeHead = 0; // Reset the tape head position
            }
        } else if (direction == 'R') {
            // Move right
            tapeHead++;
            if (tapeHead >= tape.size()) {
                // Handle reaching the end of the tape
                // For example, extend the tape to the right or throw an exception
                // Here's a simple extension example:
                tape.addLast('_'); // '_' represents a blank symbol or any default symbol
            }
        } else {
            // Stay at the same position
        }
        // ... other handling or logic as needed
    }

    /**
     * Handling the tape: reading character from tape, editing tape, and handling
     * exception cases using a linked list
     *
     * @return - char
     */
    public char readFromTape() {
        if (tapeHead >= 0 && tapeHead < tape.size()) {
            return tape.get(tapeHead);
        } else {
            // Handle the case when the tape head is out of bounds
            // For instance, return a default symbol or throw an exception
            return '_'; // Returning '_' as a default symbol for demonstration
        }
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
