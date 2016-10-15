package login;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by Cenxui on 10/15/16.
 */
abstract public class Login {

    private static Login instance;

    protected final Application context;

    protected Login(Application context) {
        this.context = context;
    }

    public static Login getLogin(Pool pool, Application context) {
        if (Login.instance == null) {
            switch (pool) {
                case AWS:
                    Login.instance = new AWSLogin(context);
                break;
                default:
                    Login.instance = new AWSLogin(context);
            }
        }
        return  Login.instance;
    }

    public void signInFB() {
        FacebookSdk.sdkInitialize(Login.instance.context);
    }

    public enum Pool {
        AWS, Google
    }
}
