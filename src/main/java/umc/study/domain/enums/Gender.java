package umc.study.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum Gender {
    MALE(0), FEMALE(1), OTHER(2);

    private final Integer genderNumber;
    private static final Map<Integer, Gender> genderExpression = new HashMap<>();

    static {
        for (Gender gender : values()){
            genderExpression.put(gender.genderNumber, gender);
        }
    }

    Gender(Integer genderNumber){
        this.genderNumber = genderNumber;
    }

    public static Gender getGender(Integer genderNumber){
        return genderExpression.get(genderNumber);
    }
}
