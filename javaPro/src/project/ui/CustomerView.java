package project.ui;

import project.bean.Customer;
import project.service.CustomerList;
import project.util.CMUtility;

import java.util.Scanner;

public class CustomerView {
    // 初始化一个Customer数组
    private CustomerList customers = new CustomerList(10);

//    public CustomerView(){
//        Customer customer = new Customer("hu", 'm', 18, "123", "12345");
//        customers.addCustomer(customer);
//    }

    /**
     * 显示界面
     * */
    public void enterMainMenu(){
        while(true) {
            System.out.println("------------------------------" +
                    "客户信息管理软件" + "---------------------------");
            System.out.println("                              " + "1. 添加客户");
            System.out.println("                              " + "2. 修改客户");
            System.out.println("                              " + "3. 删除客户");
            System.out.println("                              " + "4. 客户列表");
            System.out.println("                              " + "5. 退出");
            System.out.print("                           请选择(1-5): ");

            char choice = CMUtility.readChoice();
            switch(choice){
                case '1': addNewCustomer();break;
                case '2': modifyCustomer();break;
                case '3': deleteCustomer();break;
                case '4': listAllCustomer();break;
                case '5': {
                    System.out.print("请确认是否退出(y/n): ");
                    char c = CMUtility.readConfirmSelect();
                    if(c=='y')
                        return;
                }
            }
        }

    }

    private Customer recodeCustomer(){
        System.out.print("请输入姓名: ");
        String name = CMUtility.readString(5);
        System.out.print("请输入性别: ");
        char sex = CMUtility.readChar();
        System.out.print("请输入年龄: ");
        int age = CMUtility.readInt();
        System.out.print("请输入电话号: ");
        String phoneNumber = CMUtility.readString(11);
        System.out.print("请输入邮箱号: ");
        String email = CMUtility.readString(20);

        Customer customer = new Customer(name, sex, age, phoneNumber, email);

        return customer;
    }

    private void addNewCustomer(){
        Customer customer = this.recodeCustomer();
        boolean ret = customers.addCustomer(customer);

        if(ret)
            System.out.println("添加成功！");
        else
            System.out.println("添加失败！");
    }

    private void modifyCustomer(){
        System.out.print("请输入要修改的客户的序号: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        // 获取某个客户
        Customer cust= customers.getCustomer(index-1);
        if(cust==null)
            System.out.println("没找到对应用户！");

        Customer customer = this.recodeCustomer();
        boolean ret = customers.replaceCustomer(index-1, customer);
        if(ret)
            System.out.println("修改成功");
        else
            System.out.println("修改失败");
    }

    private void deleteCustomer(){
        System.out.print("请输入要删除的用户的序号: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        boolean ret = customers.deleteCustomer(index-1);
        if(ret)
            System.out.println("用户删除成功！");
        else
            System.out.println("此用户不存在");
    }

    private void listAllCustomer(){
        System.out.println("---------------------——————————客户列表————————————————————————————————");
        if(customers.getTotal()==0)
            System.out.println("没有记录客户信息");
        else {
            System.out.println("序号\t\t姓名\t\t性别\t\t年龄\t\t电话号\t\t邮箱号");
            Customer[] customer = customers.getAllCustomer();
            for (int i = 0; i < customers.getTotal(); i++) {
                System.out.println((i+1) + "\t\t" + customer[i].getName() + "\t\t" + customer[i].getGender() + "\t\t" +
                        customer[i].getAge() + "\t\t" + customer[i].getPhone() + "\t\t"  + customer[i].getEmail());
            }
        }
        System.out.println("---------------------————————客户列表完成—————————————————————————————--");
    }

    public static void main(String[] args){
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }

}
