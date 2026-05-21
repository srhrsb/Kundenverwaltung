package com.brh.kundenverwaltung;

import java.util.ArrayList;
import java.util.Optional;

public interface CustomerDAO {

    boolean addCustomer( String id, String name, String firstname, String street,
                      String number, String place, String postcode );

    boolean changeCustomerById( String id, String name, String firstname, String street,
                            String number, String place, String postcode );

    boolean deleteCustomerById( String id );

    boolean deleteAllCustomers();

    Optional<Customer> getCustomerById( String id );

    Optional< ArrayList<Customer> > getAllCustomers();
}
