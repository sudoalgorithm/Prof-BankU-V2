package profbanku.profbanku.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import profbanku.profbanku.R;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    private LoginButton mLoginButton;
    private CallbackManager mCallbackManager;
    private LinearLayout mLinearLayout;
    private GoogleApiClient mGoogleApiClient;
    private ImageButton mSignInButton;
    private static final int RC_SIGN_IN = 9009;
    private static final String TAG = "GooglePlusLogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        mCallbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main);
        facebookLogin();
        googleLogin();
    }

    private void facebookLogin(){
        mLoginButton = (LoginButton) findViewById(R.id.login_button);
        mLinearLayout = (LinearLayout) findViewById(R.id.activity_main);
        mLoginButton.setReadPermissions("email");
        mLoginButton.setBackgroundResource(R.drawable.flogoblue72);
        mLoginButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,0);
        mLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                finish();
            }

            @Override
            public void onCancel() {
                Snackbar.make(mLinearLayout," Transaction Canceled",Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Snackbar.make(mLinearLayout,"Network Error, Please Try Again",Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    private void googleLogin(){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addOnConnectionFailedListener(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        mSignInButton = (ImageButton) findViewById(R.id.sign_in_button);
        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });
    }

    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            GoogleSignInAccount acct = result.getSignInAccount();
            startActivity(new Intent(MainActivity.this, DashboardActivity.class));
            finish();
        } else {
            //updateUI(false);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Snackbar.make(mLinearLayout,"Network Error, Please Try Again Later", Snackbar.LENGTH_SHORT).show();

    }

    public void signIn(View v){
        startActivity(new Intent(MainActivity.this, DashboardActivity.class));
        finish();
    }


}
