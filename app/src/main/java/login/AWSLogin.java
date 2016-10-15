package login;

import android.app.Application;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.xenxui.cenxui.extremelystupid.R;

/**
 * Created by Cenxui on 10/15/16.
 */
public class AWSLogin extends Login {

    private final CognitoCachingCredentialsProvider provider;

    /* constructor */
    AWSLogin(Application context) {
        super(context);
        provider = new CognitoCachingCredentialsProvider(
                this.context,    /* get the context for the application */
                this.context.getString(R.string.cognito_identity_pool),    /* Identity Pool ID */
                Regions.AP_NORTHEAST_1      /* Region for your identity pool--US_EAST_1 or EU_WEST_1*/
        );
    }
}
