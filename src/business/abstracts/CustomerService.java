package business.abstracts;

import core.helpers.IdMaker;
import entities.concretes.Customers;

import java.util.List;

@SuppressWarnings("unused")
public abstract class CustomerService implements IdMaker {

    public abstract void register();

    public abstract void addCustomerToNewList();
}
