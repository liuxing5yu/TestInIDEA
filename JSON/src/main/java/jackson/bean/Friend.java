package jackson.bean;

public class Friend {
    private String nickname;
    private int age;

    public Friend() {
    }

    public Friend(String nickname, int age) {
        this.nickname = nickname;
        this.age = age;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
