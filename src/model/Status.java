package model;
import lombok.Getter;

import java.util.Arrays;

@Getter


public enum Status {
    ADMIN("admin"),CLIENT ("client");
    private String name;
    Status(String name){
        this.name = name;
    }
    public static Status getByName(String name) {
        return Arrays.stream(values())
                .filter(it -> it.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
    public static int getIntStatus(Status status) {
        int result;
        if(status.name.equals("client"))
            return 1;
        else return 2;
    }
    public static Status getIntToStringStatus(String status) {
        if(status.equals("1")){
            return Status.getByName("client");
        }
        else return Status.getByName("admin");
    }
    public static String getStringStatus(Status status) {
        if(status.name.equals("client"))
            return "client";
        else return "admin";
    }

}
