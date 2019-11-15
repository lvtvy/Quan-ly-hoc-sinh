package sample.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {

    private static Memory instance;

    private List<Account> accounts;

    private Account tempAcc;

    private final boolean debugMode  = true;

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public Account getTempAcc() {
        return tempAcc;
    }

    public void setTempAcc(Account tempAcc) {
        this.tempAcc = tempAcc;
    }

    private Memory() {
        accounts = new ArrayList<>();
    }

    public static Memory getInstance() {
        if (instance == null) {
            instance = new Memory();
        }
        return instance;
    }
}
