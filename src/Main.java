public class Main {
    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();
        Account account = accountManager.login();
        System.out.println("Welcome " + account.getUser().getName() + " " +
                account.getUser().getSurName());
        account.addAddress("Kızılay / Ankara");
        account.addAddress("Beşiktaş / İstanbul");
        account.addAddress("Konyaaltı / Antalya");
        account.addInsurance(new CarInsurance());
        account.showUserInfo();
    }
}
