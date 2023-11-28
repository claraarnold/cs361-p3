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

}
