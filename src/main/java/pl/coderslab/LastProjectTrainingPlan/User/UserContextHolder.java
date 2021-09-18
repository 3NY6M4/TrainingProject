package pl.coderslab.LastProjectTrainingPlan.User;

public class UserContextHolder {

    private static final UserContextHolder INSTANCE = new UserContextHolder();

    private Long userId;

    private UserContextHolder(){}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public static UserContextHolder getContext() {
        return INSTANCE;
    }
}
