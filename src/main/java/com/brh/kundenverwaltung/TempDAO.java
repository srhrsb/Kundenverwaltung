package com.brh.kundenverwaltung;

import java.util.ArrayList;
import java.util.Optional;

public class TempDAO implements CustomerDAO{

    private ArrayList<Customer> customerList;

    public TempDAO(){
        customerList = new ArrayList<>();

        customerList.add(new Customer("B12345", "Mustermann", "Mario",
                "Musterstraße", "15B", "Musterstadt", "01234"));

        customerList.add(new Customer("B67891", "Musterfrau", "Mandy",
                "Musterstraße", "16B", "Musterstadt", "01234"));
    }

    /**
     * Argumente zur Erstellung eines Kunden werden geprüft auf null oder leer
     * Falls erfolgreich geprüft, wird ein Objekt Customer erzeugt
     * und in die customerList eingefügt.
     * @param id
     * @param name
     * @param firstname
     * @param street
     * @param number
     * @param place
     * @param postcode
     * @return Erfolg: true Misserfolg: false
     */
    @Override
    public boolean addCustomer(String id, String name, String firstname,
                               String street, String number, String place, String postcode) {

         if(checkArguments(id,name, firstname, street, number, place, postcode)){
             Customer customer = new Customer(id,name, firstname, street, number, place, postcode);
             return customerList.add(customer);
         };
         return false;
    }


    /**
     * Argumente zur Änderung eines Kunden werden geprüft auf null oder leer
     * Wenn Argumente zulässig und der Kunde gefunden wurde, werden die Daten
     * entsprechend geändert
     * @param id
     * @param name
     * @param firstname
     * @param street
     * @param number
     * @param place
     * @param postcode
     * @return Erfolg: true Misserfolg: false
     */
    @Override
    public boolean changeCustomerById(String id, String name, String firstname,
                                      String street, String number, String place, String postcode) {

        if(!checkArguments(id,name, firstname, street, number, place, postcode))
            return false;

       Optional<Customer> customerOptional = getCustomerById(id);
       if(customerOptional.isEmpty()) return false;

       Customer customer = customerOptional.get();
       customer.setId(id);
       customer.setName(name);
       customer.setFirstname(firstname);
       customer.setStreet(street);
       customer.setNumber(number);
       customer.setPlace(place);
       customer.setPostcode(postcode);

       return true;
    }

    /**
     * Prüfung der id auf nicht null und nicht leer
     * Falls id zulässig ist und der Kunde existiert
     * wird er gelöscht
     * @param id
     * @return Bei Löschung: true Falls Kunde nicht vorhanden: false
     */
    @Override
    public boolean deleteCustomerById(String id) {
        if( !checkArguments( id ) ) return false;
        Optional<Customer> customerOptional = getCustomerById(id);

        if( customerOptional.isEmpty()) return false;

        Customer customer = customerOptional.get();
        return customerList.remove( customer );
    }

    /**
     * Prüfung der Kundenlist auf Gültigkeit, falls gültig
     * erfolgt die Leerung der kompletten Liste
     * @return Erfolg(Leerung): true Misserfolg: false
     */
    @Override
    public boolean deleteAllCustomers() {
        if(customerList == null) return false;
        customerList.clear();
        return true;
    }

    /**
     * Prüfung ob eine Kunde mit gegebener Id existiert
     * wenn ja, Rückgabe des Kundenobjekts mit Hilfe eine Optionals
     * @param id
     * @return Optional Customer
     */
    @Override
    public Optional<Customer> getCustomerById(String id) {

        for(Customer costumer : customerList){
            if(costumer.getId().equals(id)){
                return Optional.of(costumer);
            }
        }
        return Optional.empty();
    }

    /**
     * Rückgabe der Kundenlist falls gültig
     * @return Arraylist als Optional oder leeres Optional
     */
    @Override
    public Optional<ArrayList<Customer>> getAllCustomers() {
        return Optional.ofNullable(customerList);
    }

    /**
     * Durchlaufen eine Sammlung von Argumenten, des Typs String
     * Prüfung auf Gültigkeit oder leer oder Steuerzeichen (blank)
     * @param values
     * @return Erfolgsmeldung (alles gültig): true, ansonsten: false
     */
    private boolean checkArguments(String... values ){
        for( String value : values) {
            if( value == null || value.isBlank())
                System.err.println("Illegal Argument ");
                return false;
        }

        return true;
    }
}
