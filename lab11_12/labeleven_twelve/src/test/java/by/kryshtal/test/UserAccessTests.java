package by.kryshtal.test;

import by.kryshtal.model.User;
import by.kryshtal.page.LoginPage;
import by.kryshtal.page.MainPage;
import by.kryshtal.page.ProfilePage;
import by.kryshtal.service.UserCreator;
import org.junit.Assert;
import org.testng.annotations.Test;

public class UserAccessTests extends CommonConditions {
    private static String favoriteTeam = "FC Barcelona";
    @Test
    public void oneCanLogin() throws InterruptedException {
        User testUser = UserCreator.withCredentialsFromProperty();
        LoginPage loggedInUserName = new LoginPage(driver)
                .openPage()
                .login(testUser);
    }
    @Test
    public void wrongLogin() throws InterruptedException {
        User wrongUser = UserCreator.withWrongPassword();
        LoginPage wrongLogged = new LoginPage(driver)
                .openPage()
                .login(wrongUser);
    }
    @Test
    public void chooseFavoriteTeam() throws InterruptedException {
        User testUser = UserCreator.withCredentialsFromProperty();
        String team = new LoginPage(driver)
                .openPage()
                .login(testUser)
                .openAccount()
                .openMyInterests()
                .setFavouriteTeam(favoriteTeam);
        Assert.assertEquals(team, favoriteTeam);
    }
}
