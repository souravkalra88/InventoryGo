package model;

public class DATA {
    private String name,price,amount;
    private String id;
    private String supplier,sContact;
    public DATA(){}

    public DATA(String name, String price, String amount, String supplier, String sContact) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.supplier = supplier;
        this.sContact = sContact;
    }

    public DATA(String id,String name, String price, String amount,  String supplier, String sContact) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.id = id;
        this.supplier = supplier;
        this.sContact = sContact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getsContact() {
        return sContact;
    }

    public void setsContact(String sContact) {
        this.sContact = sContact;
    }
}
