package task3;

import java.util.List;
import java.util.Scanner;

public class BloodDBProxy implements DB{
    private Scanner in = new Scanner(System.in);
    private SecuritySystem security;
    private BloodDB db;
    private final BloodSample denied = new BloodSample(0, "acces", "denied", null,null,null);


    public BloodDBProxy(){
        security = new SecuritySystem();
        security.authorize(in.next(), in.next());
        if(security.isAuthorized()){
            db = new BloodDB();
        }else {
            System.out.println("Not authorized");
        }
    }

    @Override
    public BloodSample getById(int id) {
        return db.getById(id);
    }

    @Override
    public List<BloodSample> find(String request) {
        return List.of();
    }
}
