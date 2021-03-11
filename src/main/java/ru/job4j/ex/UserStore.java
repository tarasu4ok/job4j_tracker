package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User foundUser = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                foundUser = user;
                break;
            }
        }
        if (foundUser == null) {
            throw new UserNotFoundException("User not found");
        }
        return foundUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Taras Kramarenko", false),
                new User("TK", true)
        };
        try {
            User user = findUser(users, "TK");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException uie) {
            System.out.println("User is not valid");
        } catch (UserNotFoundException unf) {
            System.out.println("User not found");
        }
    }
}
