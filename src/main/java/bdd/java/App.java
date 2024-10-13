package bdd.java;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bdd.java.Contact;

/**
 * Hello world!
 */
public final class App {

    private App() {
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        List<Contact> contacts = getAll();
        System.out.println(contacts.toString());
        //    // Suppression d'un utilisateur
        //    deleteByFirstnameAndSurname("Bobby","Bob");
        //     // Récupération d'un contact par identifiant
        //     Contact contact = getContactById(1);
        //     deleteByFirstnameAndSurname(contact);
    }

    public static List<Contact> getAll() {
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        try {
            // chaîne de connexion à la base de données
            String url = "jdbc:postgresql://localhost:5432/javac";
            // création d'un objet de la classe "Connection" en utilisant DriverManager
            Connection con = DriverManager.getConnection(url, "postgres", "admin"); // création d'un "Statement" (objet qui permet d'exéctuer une requête SQL)
            Statement stm = con.createStatement();
            // récupération de toutes les lignes de résultat (objet de la classe "ResultSet")
            ResultSet result = stm.executeQuery("SELECT * FROM contact");
            // on passe en revue toutes les lignes
            while (result.next()) {
                // récupération des valeurs des colonnes
                int id = result.getInt("id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String gender = result.getString("gender");
                String pseudo = result.getString("pseudo");
                String email = result.getString("email");
                LocalDate birthDate = result.getDate("birth_date").toLocalDate();
                String address = result.getString("address");
                String personalPhoneNumber = result.getString("personal_phone_number");
                String professionalPhoneNumber = result.getString("professional_phone_number");
                String linkedInLink = result.getString("linkedin_link");
                String gitLink = result.getString("git_link");
                // affichage du résultat
                Contact contact = new Contact(id, firstName, lastName, gender, pseudo, email, birthDate, address, personalPhoneNumber, professionalPhoneNumber, linkedInLink, gitLink);
                contacts.add(contact);
            }
            // fermeture des ressources
            stm.close();
            result.close();
            con.close();
            return contacts;
        } catch (Exception e) {
            System.err.println("Error");
            System.err.println(e.getMessage());
        }
        System.out.println(contacts);
        return contacts;
    }

    public static Contact getContactById(int id) {
        try {
            // chaîne de connexion à la base de données
            String url = "jdbc:postgresql://localhost:5432/javac";
            // création d'un objet de la classe "Connection" en utilisant DriverManager
            Connection con = DriverManager.getConnection(url, "postgres", "admin"); 
            // récupération de toutes les lignes de résultat (objet de la classe "ResultSet")
            String sql = ("SELECT * FROM contact WHERE id = ?");
            // création d'un "Statement" pour effectuer la requête
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet result = stm.executeQuery();

            // on passe en revue toutes les lignes
            while (result.next()) {
                // récupération des valeurs des colonnes
                int idContact = result.getInt("id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String gender = result.getString("gender");
                String pseudo = result.getString("pseudo");
                String email = result.getString("email");
                LocalDate birthDate = result.getDate("birth_date").toLocalDate();
                String address = result.getString("address");
                String personalPhoneNumber = result.getString("personal_phone_number");
                String professionalPhoneNumber = result.getString("professional_phone_number");
                String linkedInLink = result.getString("linkedin_link");
                String gitLink = result.getString("git_link");
                // affichage du résultat
                Contact contact = new Contact(id, firstName, lastName, gender, pseudo, email, birthDate, address, personalPhoneNumber, professionalPhoneNumber, linkedInLink, gitLink);
                
            
            // fermeture des ressources
            
            stm.close();
            con.close();
            return contact;
        }
        } catch (Exception e) {
            System.err.println("Error");
            System.err.println(e.getMessage());
        }
        return null;
    }       

    
    public static boolean deleteById(int id) {
   try {
          // chaîne de connexion à la base de données
          String url = "jdbc:postgresql://localhost:5432/javac";
          // création d'un objet de la classe "Connection" en utilisant DriverManager
          Connection con = DriverManager.getConnection(url, "postgres", "admin"); 
          // récupération de toutes les lignes de résultat (objet de la classe "ResultSet")
          String sql = ("DELETE FROM contact WHERE contact.id = ?");
          // création d'un "Statement" pour effectuer la requête
          PreparedStatement stm = con.prepareStatement(sql);
          stm.setInt(1, id);
        
            // fermeture des ressources
            stm.execute();
            stm.close();
            con.close();
            System.out.println("le contact avec id est : "  + id +" a bien été supprimé");
            return true;
        } catch (SQLException e) {
            System.err.println("Error");
            System.err.println(e.getMessage());
            e.printStackTrace();
                    return false;
    }
}
public static boolean deleteByLastNameAndFirstName(String lastName, String firstName) {
    try {
           // chaîne de connexion à la base de données
           String url = "jdbc:postgresql://localhost:5432/javac";
           // création d'un objet de la classe "Connection" en utilisant DriverManager
           Connection con = DriverManager.getConnection(url, "postgres", "admin"); 
           // récupération de toutes les lignes de résultat (objet de la classe "ResultSet")
           String sql = ("DELETE FROM contact WHERE contact.id = ?");
           // création d'un "Statement" pour effectuer la requête
           PreparedStatement stm = con.prepareStatement(sql);
           stm.setString(1, lastName);
           stm.setString(2, firstName);

         
             // fermeture des ressources
             stm.execute();
             stm.close();
             con.close();
             System.out.println("le contact avec lastName et firstName sont : "  + lastName +" "+ firstName+ " ont bien été supprimés");
             return true;
         } catch (SQLException e) {
             System.err.println("Error");
             System.err.println(e.getMessage());
             e.printStackTrace();
                     return false;
     }
 }
}



// public static List<Contact> getAllContact() {
//     ArrayList<Contact> sqlAllContact = new ArrayList<Contact>();
//     try {
//         // chaîne de connexion à la base de données
//         String url = "jdbc:postgresql://localhost:5432/javac";
//         // création d'un objet de la classe "Connection" en utilisant DriverManager
//         Connection con = DriverManager.getConnection(url, "postgres", "admin");
//         // création d'un "Statement" (objet qui permet d'exéctuer une requête SQL)
//         Statement stm = con.createStatement();
//         // récupération de toutes les lignes de résultat (objet de la classe
//         // "ResultSet")
//         ResultSet result = stm.executeQuery("SELECT * FROM contact");
//         // on passe en revue toutes les lignes
//         while (result.next()) {
//             // récupération des valeurs des colonnes pour chaque contact
//             int id = result.getInt("id");
//             String lastName = result.getString("lastName");
//             String firstName = result.getString("firstName");
//             String gender = result.getString("gender");
//             String pseudo = result.getString("pseudo");
//             String email = result.getString("email");
//             LocalDate birthDate = LocalDate.parse(result.getString("birthDate"));
//             String address = result.getString("adress");
//             String personalPhoneNumber = result.getString("personalPhoneNumber");
//             String professionalPhoneNumber = result.getString("professionalPhoneNumber");
//             String linkedInLink = result.getString("linkedInLink");
//             String gitLink = result.getString("gitLink");
//             Contact contact = new Contact(id, firstName, lastName, gender, pseudo, email, birthDate, address, personalPhoneNumber, professionalPhoneNumber, linkedInLink, gitLink);
//             sqlAllContact.add(contact);
//             //     // affichage du résultat
//             //     // System.out.format("[%d] %s %s\n", id, nom, prenom, genre, dateDeNaissance,
//             //     // pseudo, adresse,
//             //     // telPerso, telPro, mail, codePostale, gitLink);
//             //     // Contact contact = new Contact(id, nom, prenom, genre, dateDeNaissance,
//             //     // pseudo, adresse, telPerso, telPro, mail, codePostale, gitLink);
//             //     // SqlallContacts.add(contact);
//         }
//         // fermeture des ressources
//         stm.close();
//         result.close();
//         con.close();
//         System.out.println("try success");
//         return sqlAllContact;
//     } catch (Exception e) {
//         System.err.println("Error");
//     }
//     return sqlAllContact;
// }