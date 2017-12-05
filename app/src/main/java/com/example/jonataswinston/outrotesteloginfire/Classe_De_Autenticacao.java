package com.example.jonataswinston.outrotesteloginfire;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Classe_De_Autenticacao extends AppCompatActivity {
    MainActivity act = new MainActivity();
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = getApplicationContext();
        final int duration = Toast.LENGTH_SHORT;
        final int SplashTime = 3000;

        mAuth = FirebaseAuth.getInstance();
        //firebase auth
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user !=null){
                    Log.d("AUTH", "onAuthStateChanged:signed_in:" + user.getUid());
                }else{
                    Log.d("AUTH", "onAuthStateChanged:signed_out");
                }
            }
        };
        //firebase auth
        mAuth.signInWithEmailAndPassword(act.getEmailUser(), act.getSenhaUser()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (!task.isSuccessful()){
                    Log.w("AUTH", "Falha ao efetuar o login: ", task.getException());
                    CharSequence text = "Falha no login";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    new Handler().postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            Intent homeIntent = new Intent(Classe_De_Autenticacao.this, MainActivity.class);
                            startActivity(homeIntent);
                            finish();
                        }
                    }, SplashTime);
                } else {
                    Log.d("AUTH", "Login efetuado com sucesso!!!");
                    CharSequence text = "Login aceito";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    new Handler().postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            Intent homeIntent = new Intent(Classe_De_Autenticacao.this, MenuActivity.class);
                            startActivity(homeIntent);
                            finish();
                        }
                    }, SplashTime);
                }
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
