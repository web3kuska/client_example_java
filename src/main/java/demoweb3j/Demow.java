package demoweb3j;

import java.math.BigInteger;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.core.methods.response.EthGetBalance;

 
public class Demow {
    public static void main(String[] args) {
 
        System.out.println("*Start" );
        try
        {
        String account="0x8f401f28a4993894EFA3f39f962c34D33e16F9cB";
        Web3j web3j = Web3j.build(new HttpService("http://137.131.180.21:8545"));
        EthGetBalance balanceResponse = web3j.ethGetBalance(account, DefaultBlockParameterName.LATEST).send();
        if (balanceResponse.hasError()) {
            System.out.println("Error occurred: " + balanceResponse.getError().getMessage());
        } else {
            BigInteger balanceWei = balanceResponse.getBalance();
            System.out.println("Balance in Wei: " + balanceWei);
        }
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
    }
}
