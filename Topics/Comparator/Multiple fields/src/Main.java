import java.util.List;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "=" + age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Utils {

    public static void sortUsers(List<User> users) {
        // your code here
        users.sort((s1,s2)->{
            if(!s1.getName().equals(s2.getName())){
                return s1.getName().compareTo(s2.getName());
            }else{
                return Integer.compare(s2.getAge(),s1.getAge());
            }
        });

    }
}