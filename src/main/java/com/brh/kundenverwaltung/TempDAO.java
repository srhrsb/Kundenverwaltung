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

    @Override
    public boolean addCustomer(String id, String name, String firstname,
                               String street, String number, String place, String postcode) {

         if(checkArguments(id,name, firstname, street, number, place, postcode)){
             Customer customer = new Customer(id,name, firstname, street, number, place, postcode);
             return customerList.add(customer);
         };
         return false;
    }

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

    @Override
    public boolean deleteCustomerById(String id) {
        if( !checkArguments( id ) ) return false;
        Optional<Customer> customerOptional = getCustomerById(id);

        if( customerOptional.isEmpty()) return false;

        Customer customer = customerOptional.get();
        return customerList.remove( customer );
    }

    @Override
    public boolean deleteAllCustomers() {
        if(customerList == null) return false;
        customerList.clear();
        return true;
    }

    @Override
    public Optional<Customer> getCustomerById(String id) {

        for(Customer costumer : customerList){
            if(costumer.getId().equals(id)){
                return Optional.of(costumer);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<ArrayList<Customer>> getAllCustomers() {
        return Optional.ofNullable(customerList);
    }

    private boolean checkArguments(String... values ){
        for( String value : values) {
            if( value == null || value.isBlank())
                System.err.println("Illegal Argument ");
                return false;
        }

        return true;
    }
}
