package bdd.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class App {

    private App() {
    }

    /**
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        // Ajouter un nouveau contact
        // Contact newContact = new Contact(5, "Alice", "Wonderland", "F", "alice", "alice@example.com", LocalDate.of(1990, 1, 1), "123 Rue Imaginaire", "0102030405", "0607080910", "https://linkedin.com/in/alice", "https://github.com/alice");
        // addContact(newContact);
        
        // Supprimer un contact par ID
        // deleteById(2);
        
        // Supprimer un contact par nom et prénom
        // deleteByLastNameAndFirstName("Wonderland", "Alice");
        
        // Mettre à jour un contact
        Contact contactToUpdate = getContactById(1);
        if (contactToUpdate != null) {
            contactToUpdate.setLastName("Zoubir");
            updateContact(contactToUpdate);
        }
            
            List<Contact> contacts = getAll();
            System.out.println(contacts.toString());
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
            String sql = ("DELETE FROM contact WHERE id = ?;");
            // création d'un "Statement" pour effectuer la requête
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);

            // fermeture des ressources
            stm.execute();
            stm.close();
            con.close();
            System.out.println("le contact avec id est : " + id + " a bien été supprimé");
            return true;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du contact : " + id +" " + e.getMessage());
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
            String sql = ("DELETE FROM contact WHERE last_name = ? AND first_name = ?");
            // création d'un "Statement" pour effectuer la requête
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, lastName);
            stm.setString(2, firstName);

            // fermeture des ressources
            stm.execute();
            stm.close();
            con.close();
            System.out.println("le contact avec lastName et firstName sont : " + lastName + " " + firstName + " ont bien été supprimés");
            return true;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression Id du contact : " + e.getMessage());
            return false;
        }
    }

    public static Contact addContact(Contact contact) {
        try {
            // chaîne de connexion à la base de données
            String url = "jdbc:postgresql://localhost:5432/javac";
            // création d'un objet de la classe "Connection" en utilisant DriverManager
            Connection con = DriverManager.getConnection(url, "postgres", "admin");

// Requête SQL d'insertion des valeurs dans la table 'contact'
            String sql = "INSERT INTO contact (id, first_name, last_name, gender, pseudo, email, birth_date, address, personal_phone_number, professional_phone_number, linkedin_link, git_link) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Création du PreparedStatement pour l'exécution de la requête SQL
            PreparedStatement stm = con.prepareStatement(sql);

            // Paramétrage des valeurs à insérer
            stm.setInt(1, contact.getId());
            stm.setString(2, contact.getFirstName());
            stm.setString(3, contact.getLastName());
            stm.setString(4, contact.getGender());
            stm.setString(5, contact.getPseudo());
            stm.setString(6, contact.getEmail());
            stm.setDate(7, java.sql.Date.valueOf(contact.getBirthDate()));
            stm.setString(8, contact.getAddress());
            stm.setString(9, contact.getpersonalPhoneNumber());
            stm.setString(10, contact.getpersonalPhoneNumber());
            stm.setString(11, contact.getLinkedInLink());
            stm.setString(12, contact.getGitLink());

            // Exécution de la requête SQL
            stm.executeUpdate();

            // Fermeture des ressources
            stm.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout du contact : " + e.getMessage());
        }
        return contact;
    }

    public static boolean updateContact(Contact contact) {
        try {
            // chaîne de connexion à la base de données (adaptée)
            String url = "jdbc:postgresql://localhost:5432/javac";
            // création d'un objet de la classe "Connection" en utilisant DriverManager
            Connection con = DriverManager.getConnection(url, "postgres", "admin");

            // Requête SQL pour mettre à jour toutes les informations d'un contact
            String sql = "UPDATE contact SET first_name = ?, last_name = ?, gender = ?, pseudo = ?, email = ?, birth_date = ?, address = ?, personal_phone_number = ?, professional_phone_number = ?, linkedin_link = ?, git_link = ? WHERE id = ?";

            // Création d'un PreparedStatement pour l'exécution de la requête
            PreparedStatement stm = con.prepareStatement(sql);

            // Mise à jour des paramètres (dans l'ordre de la requête SQL)
            stm.setString(1, contact.getFirstName());
            stm.setString(2, contact.getLastName());
            stm.setString(3, contact.getGender());
            stm.setString(4, contact.getPseudo());
            stm.setString(5, contact.getEmail());
            stm.setDate(6, java.sql.Date.valueOf(contact.getBirthDate()));
            stm.setString(7, contact.getAddress());
            stm.setString(8, contact.getpersonalPhoneNumber());
            stm.setString(9, contact.getpersonalPhoneNumber());
            stm.setString(10, contact.getLinkedInLink());
            stm.setString(11, contact.getGitLink());
            stm.setInt(12, contact.getId());  // Le dernier paramètre correspond à l'ID du contact à mettre à jour

            // Exécution de la requête SQL
            int rowsAffected = stm.executeUpdate();

            // Fermeture des ressources
            stm.close();
            con.close();

                    // Vérification si une ligne a été affectée
            if (rowsAffected > 0) {
                System.out.println("Le contact avec l'ID : " + contact.getId() + " a bien été modifié.");
                return true;
            } else {
                System.out.println("Aucun contact trouvé avec l'ID donné.");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du contact : " + e.getMessage());
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
