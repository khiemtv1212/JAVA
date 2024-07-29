package solekia.dvdrental.model;

import java.util.List;

import org.springframework.stereotype.Component;

import solekia.dvdrental.repository.CustomerModel;

/**
 * CustomerModel
 */
@Component
public class CustomerPageModel {

    public String title;

    public List<CustomerModel> list;

    public int customer_id;
    public String first_name;
    public String last_name;
    public String email;

    /**
     * Getter/Setter
     */
    public int getCustomer_id() {
    return customer_id;
    }
    public void setCustomer_id(int customer_id){
    this.customer_id = customer_id;
    }
    public String getFirst_name() {
    return first_name;
    }
    public void setFirst_name(String first_name){
    this.first_name = first_name;
    }
    public String getLast_name() {
    return last_name;
    }
    public void setLast_name(String last_name){
    this.last_name = last_name;
    }
    public String getEmail() {
    return email;
    }
    public void setEmail(String email){
    this.email = email;
    }

}
