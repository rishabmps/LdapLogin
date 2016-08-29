
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.Advapi32Util.Account;

public class UserGroupPrinter {
    public static void main( String[] args ) {
    	for(Account account: Advapi32Util.getCurrentUserGroups())
    	    System.out.println(account.fqn);
    }
}