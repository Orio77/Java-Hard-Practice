package generics.exericse10.scenario1;

import java.util.List;

public class UserPlugin implements Plugin<User> {
    private UserBase base;

    public UserPlugin() {
        base = UserBase.getInstance();
    }

    @Override
    public void initialize(User user) {
        base.addData(user);
    }

    @Override
    public void execute() {
        System.out.println("Data: ");
        for (List<String> list : base.retrieveAllData()) {
            System.out.println(list);
        }
        System.out.println("End of data. All the data is visible above.");
    }

    
}