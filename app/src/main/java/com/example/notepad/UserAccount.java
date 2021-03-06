package com.example.notepad;

import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class UserAccount {
    private GoogleSignInAccount mAccount;
    private static UserAccount mUserAccount;
    private static Context mContext;

    private UserAccount(){}
    public static UserAccount getInstance(Context context){
        if(mUserAccount == null) {
            mUserAccount = new UserAccount();
        }
        mContext = context;
        return mUserAccount;
    }

    public boolean isSignedIn(){
        return mAccount != null;
    }

    public void setAccount(GoogleSignInAccount account) {
        mAccount = account;
    }

    public GoogleSignInAccount getAccount() {
        return mAccount;
    }

    public boolean ifPreviouslyLogin() {
        mAccount = GoogleSignIn.getLastSignedInAccount(mContext);
        return isSignedIn();
    }
}
