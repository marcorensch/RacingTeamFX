package nxd.racingteamfx;

public class Driver {
    private int id;
    private String firstname;
    private String lastname;
    private int number;
    private int teamId;
    private String teamName;

    public Driver(){
        this(0,"","",0,0,"");
    }

    public Driver(int id, String firstname, String lastname, int number, int teamId, String teamName) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.number = number;
        this.teamId = teamId;
        this.teamName = teamName;
    }

    public int getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "My To String Driver{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", number=" + number +
                ", teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
