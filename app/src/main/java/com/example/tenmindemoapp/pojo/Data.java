package com.example.tenmindemoapp.pojo;

public class Data {
    private String itemName;
    private int icon_address;
    private boolean isExpendend = false, hasSublist;

    public Data(String itemName, int icon_address, boolean hasSublist) {
        this.itemName = itemName;
        this.icon_address = icon_address;
        this.hasSublist = hasSublist;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setIcon_address(int icon_address) {
        this.icon_address = icon_address;
    }

    public String getItemName() {
        return itemName;
    }

    public void setExpendend(boolean expendend) {
        isExpendend = expendend;
    }

    public int getIcon_address() {
        return icon_address;
    }

    public boolean isExpendend() {
        return isExpendend;
    }

    public boolean isHasSublist() {
        return hasSublist;
    }
}
