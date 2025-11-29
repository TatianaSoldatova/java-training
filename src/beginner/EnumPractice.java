package beginner;

enum UserStatus{
    PENDING,
    ACTIVE,
    BLOCKED
}

enum DayOfWeek{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY,
}

public class EnumPractice {

    static void main() {
        UserStatus active = UserStatus.ACTIVE;
        System.out.println(active);
        UserStatus blocked = UserStatus.valueOf("BLOCKED"); // case-sensitive
        System.out.println(blocked);
        System.out.println(blocked.ordinal()); // 2
        System.out.println();

        UserStatus[] statuses = UserStatus.values(); // [PENDING, ACTIVE, BLOCKED]

        for(UserStatus status : UserStatus.values()){
            if(status.equals(UserStatus.ACTIVE)){
                System.out.println(status);
            }else if(status == UserStatus.BLOCKED){
                System.out.println(status);
            }else {
                System.out.println(status);
            }
        }

        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day);
        }

        int dayNumber = 1;
        DayOfWeek day = DayOfWeek.values()[dayNumber - 1];
        System.out.print(day);
    }
}
