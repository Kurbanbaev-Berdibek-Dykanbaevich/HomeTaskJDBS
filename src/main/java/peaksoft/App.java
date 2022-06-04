package peaksoft;


import peaksoft.util.DataBaseHM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {

//        DataBaseHM.connection( );
//        System.out.println( getInfo1());
//        getInfo(1);
//           createTeble();
//
//             addInfo(1,1,"Эмилбек","Абдыкадыров ",64);
//             addInfo(2,2,"Сергей","Собянин",63);
//             addInfo(3,3,"Алтай","Кульгинов",44);
//             addInfo(4,4,"Джахонги́р","Артыкходжа́ев",47);
//             addInfo(5,5,"Руста́м","Эмомали́",35);
//             addInfo(6,6,"Шамухаммет","Дурдылыев",59);
//             addInfo(7,7,"Мансур","Яваш",67);
//             addInfo(8,8,"Грачья","Саргсян",37);
//             addInfo(9,9,"Виталий "," Кличко",51);
//             addInfo(10,10,"Владимир","Кухарев ",50);
        System.out.println(getCities(3));

    }

    public static void createTeble() {

        String SQL = "CREATE TABLE IF NOT EXISTS mayors" +
                "(id INTEGER PRIMARY KEY," +
                "cities_id INTEGER REFERENCES cities(id)," +
                "name VARCHAR(55)NOT NULL," +
                "surname VARCHAR(100) NOT NULL," +
                "age INTEGER )";
        try (Connection connection = DataBaseHM.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
            System.out.println("Table is succesfully created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void addInfo(int id,int cities_id,String name,String surname,int age)throws SQLException {
        String SQL = "Insert into mayors(id,cities_id,name,surname,age)values(?,?,?,?,?)";
        Connection connection = DataBaseHM.connection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,id);
        preparedStatement.setInt(2,cities_id);
        preparedStatement.setString(3,name);
        preparedStatement.setString(4,surname);
        preparedStatement.setInt(5,age);
        preparedStatement.executeUpdate();
        System.out.println("Successfully added "+ name);
        connection.close();
    }



   public static List<Countries> getInfo1(){
        String SQL = "SELECT * FROM countries;";
        List<Countries> countries = new ArrayList<>();
        try(Connection connection = DataBaseHM.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL)){
            while (resultSet.next()){
                Countries country = new Countries();
                country.setId(resultSet.getInt("id"));
                country.setCountry(resultSet.getString("country"));
                country.setPresident(resultSet.getString("president"));
                country.setPopulation(resultSet.getString("population"));
                countries.add(country);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return countries;
   }
    public static List<Cities> getInfo(){

        String SQL = "SELECT * FROM cities ;";
        List<Cities> cities = new ArrayList<>();
        try(Connection connection = DataBaseHM.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL)){
            while (resultSet.next()){
                Cities city = new Cities();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setAge(resultSet.getInt("age"));
                city.setSquare(resultSet.getString("square"));
                cities.add(city);

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return cities;
    }
    public static Cities  getCities(int id) {
        Cities city = new Cities();
        String SQL = "SELECT * FROM cities WHERE id = ?;";
        try (Connection connection = DataBaseHM.connection();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setAge(resultSet.getInt("age"));
                city.setSquare(resultSet.getString("square"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }
}
