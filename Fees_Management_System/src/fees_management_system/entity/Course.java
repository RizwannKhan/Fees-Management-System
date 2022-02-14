package fees_management_system.entity;

/**
 * @author Rijwank
 */
public class Course {

    private int id;
    private String cName;
    private String cost;

    public Course() {
    }

    public Course(int id, String cName, String cost) {
        this.id = id;
        this.cName = cName;
        this.cost = cost;
    }

    public Course(String cName, String cost) {
        this.cName = cName;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

}
