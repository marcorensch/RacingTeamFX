package nxd.racingteamfx;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBTasks {
    public static ArrayList<Driver> getAllDrivers(){
        ArrayList<Driver> drivers = new ArrayList<Driver>();

        // get the Connector
        Connector connector = new Connector();

        try(Connection connection = connector.getConnection()){

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT d.id, d.firstname, d.lastname, d.number, d.team_id, t.name as teamname FROM drivers as d JOIN teams as t ON d.team_id = t.id");

            while(rs.next()){
                Driver d = new Driver(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getInt("number"),rs.getInt("team_id"), rs.getString("teamname"));
                drivers.add(d);
            }

        }catch(SQLException sqle){
            System.out.println("SQL Exception aufgetreten beim Versuch die Fahrer auszulesen");
            sqle.printStackTrace();
        }
        return drivers;
    }

    public static ArrayList<Team> getAllTeams(){

        ArrayList<Team> teams = new ArrayList();

        // get the Connector
        Connector connector = new Connector();

        try(Connection connection = connector.getConnection()){

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, name FROM teams");

            while(rs.next()){
                Team t = new Team(rs.getInt("id"), rs.getString("name"));
                teams.add(t);
            }

        }catch(SQLException sqle){
            System.out.println("SQL Exception aufgetreten beim Versuch die Fahrer auszulesen");
            sqle.printStackTrace();
        }
        return teams;

    }

    public static Team getTeamByName(String name){

        Team team = null;
        // get the Connector
        Connector connector = new Connector();

        try(Connection connection = connector.getConnection()){

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id,name FROM teams WHERE name = '"+name+"'");

            rs.last();
            team = new Team(rs.getInt("id"),rs.getString("name"));

        }catch(SQLException sqle){
            System.out.println("SQL Exception aufgetreten beim Versuch die ID des gewählten Teams auszulesen");
            sqle.printStackTrace();
        }

        return team;
    }

    public static int addDriver(String fn, String ln, int num, int teamId){

        // get the Connector
        Connector connector = new Connector();

        int result = 0;
        String values = "'"+fn+"','"+ln+"',"+num+","+teamId;
        try(Connection connection = connector.getConnection()){
            Statement statement = connection.createStatement();
            result = statement.executeUpdate("INSERT INTO drivers(firstname,lastname,number,team_id) values("+values+")");
            System.out.println("Fahrer hinzugefügt: "+result);

        }catch (SQLException sqle){
            System.out.println("SQL Exception aufgetreten");
            System.out.println(sqle.getMessage());
        }

        return result;
    }
}
