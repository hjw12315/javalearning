package project.service;

import project.bean.Customer;

public class CustomerList {
    private Customer[] customers;
    private int total=0;
    // new一个Customer数组
    public CustomerList(){ }
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
     * 添加用户
     * */
    public boolean addCustomer(Customer customer){
        if(total>=customers.length)
            return false;
        customers[total++] = customer;
        //total++;

        return true;
    }
    /*
     * 替换指定用户
     * */
    public boolean replaceCustomer(int index, Customer customer){
        if(index>=total || index<0)
            return false;
        customers[index] = customer;
        return true;
    }
    /*
     * 删除指定用户
     * */
    public boolean deleteCustomer(int index){
        if(index>=total || index<0)
            return false;
        //total-1
        for(int i=index; i<total - 1; i++)
            customers[index] = customers[index+1];
        customers[--total] = null;
        return true;
    }
    /**
     * 获取全部的顾客
     * */
    public Customer[] getAllCustomer(){
        Customer[] customer = new Customer[total];
        for(int i=0; i<total; i++)
            customer[i] = customers[i];
        return customer;
    }
    /**
     * 获取特定的顾客
     * */
    public Customer getCustomer(int index){
        if(index>=total || index<0)
            return null;
        return customers[index];
    }
    /**
     * 获取用户数
     * */
    public int getTotal(){
        return total;
    }
}
