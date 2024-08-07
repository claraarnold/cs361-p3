package tm;

import java.util.Set;

/**
 * Interface to methods for building a machine that can
 * simulate a Turing Machine
 *
 * @author claraarnold, joelathrop
 */
public interface TMInterface {

    /**
     * Adds a state to the tm.TM instance
     * @param name is the label of the state
     * @return true if a new state created successfully and false if there is already state with such name
     */
    public boolean addState(String name);

    /**
     * Marks an existing state as an accepting state
     * @param name is the label of the state
     * @return true if successful and false if no state with such name exists
     */
    public boolean setFinal(String name);

    /**
     * Adds the initial state to the tm.TM instance
     * @param name is the label of the start state
     * @return true if successful and false if no state with such name exists
     */
    public boolean setStart(String name);

    /**
     * Adds a symbol to Sigma
     * @param symbol to add to the alphabet set
     */
    public void addSigma(char symbol);

    /**
     * Simulates a tm.TM on input s to walk through
     * the tm.TM and keep track of what tape positions
     * were visited then print the final contents of
     * those tape positions.
     *
     * @param s - the input string
     * @return true if s in the language of the tm.TM and false otherwise
     */
    public abstract String walkThrough(String s);


    /**
     * Getter for Sigma
     * @return the alphabet of tm.TM
     */
    public Set<Character> getSigma();


    /**
     * Returns state with the given name, or null if none exists
     * @param name of a state
     * @return state object or null
     */
    public State getState(String name);


    /**
     * Determines if a state with a given name is final
     * @param name the name of the state
     * @return true if a state with that name exists and it is final
     */
    public boolean isFinal(String name);

    /**
     * Determines if a state with name is final
     * @param name the name of the state
     * @return true if a state with that name exists and it is the start state
     */
    public boolean isStart(String name);
}
