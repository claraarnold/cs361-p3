package tm;
import tm.State;
public class TMState extends State {

    public String name;

    /**
     * Constructor to each State's multiple path options
     *
     * @param name - name of state
     */
    public TMState(String name) {
        super(name);
        this.name = name;
    }

    /**
     * If transitions contains the transition character,
     * get the set and add to it. if not, create a set with the toState in it,
     * then put the transition character and this new set.
     *
     * @param onSymb - transition character
     * @param toState - state transitioning to
     */
    public void addTransition(char onSymb, TMState toState) {

    }

    public void addToTap() {

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
