package task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class BloodDB implements DB {

    private static final Map<Integer, BloodSample> DB = new HashMap<>() {{
        put(122, new BloodSample(122, "Mike", "Donovan", new Object(), BloodSample.BloodType.A, BloodSample.RhFactor.NEGATIVE));
        put(123, new BloodSample(123, "Jamie", "Jaworski", new Object(), BloodSample.BloodType.O, BloodSample.RhFactor.POSITIVE));
        put(124, new BloodSample(124, "Matt", "Chambers", new Object(), BloodSample.BloodType.AB, BloodSample.RhFactor.POSITIVE));
        put(125, new BloodSample(125, "Jorge", "Castillo", new Object(), BloodSample.BloodType.O, BloodSample.RhFactor.POSITIVE));
        put(126, new BloodSample(126, "Valerie", "Castillo", new Object(), BloodSample.BloodType.B, BloodSample.RhFactor.NEGATIVE));
        put(127, new BloodSample(127, "Emmett", "Meridian", new Object(), BloodSample.BloodType.B, BloodSample.RhFactor.POSITIVE));
        put(128, new BloodSample(128, "Brian", "Moser", new Object(), BloodSample.BloodType.A, BloodSample.RhFactor.NEGATIVE));
    }};

    public BloodSample getById(int id) {
        return DB.get(id);
    }

    public List<BloodSample> find(String request) {
        return DB.values().stream()
                .filter(s -> s.getUser().getFirstName().contains(request) ||
                        s.getUser().getLastName().contains(request) ||
                        s.getBloodType().name().contains(request) ||
                        s.getRhFactor().name().contains(request))
                .collect(Collectors.toList());
    }
}