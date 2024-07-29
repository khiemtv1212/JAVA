package solekia.dvdrental.model;

import java.util.List;

import solekia.dvdrental.entities.CustomerCategory;

public class CustomerPageCategory {
    public int category_id;
    public String name;
    
    public int getCategory_id() {
        return category_id;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<CustomerCategory> getList() {
        return list;
    }
    public void setList(List<CustomerCategory> list) {
        this.list = list;
    }
    public List<CustomerCategory> list;
}
