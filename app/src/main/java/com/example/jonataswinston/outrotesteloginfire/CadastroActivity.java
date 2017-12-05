package com.example.jonataswinston.outrotesteloginfire;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.jonataswinston.outrotesteloginfire.MainActivity.*;

public class CadastroActivity extends AppCompatActivity {
    MainActivity act = new MainActivity();
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText email;
    private EditText senha;
    private EditText confirmarSenha;
    private Button button;
    private String emailUser;
    private String senhaUser;
    private String confirmarSenhaUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        button = (Button) findViewById(R.id.CadastroConcButton);
        email = (EditText) findViewById(R.id.CadastroEmail);
        senha = (EditText) findViewById(R.id.CadastroSenha);
        confirmarSenha = (EditText) findViewById(R.id.CadastroConfirmarSenha);

        final Context context = getApplicationContext();
        final int duration = Toast.LENGTH_SHORT;
        final CharSequence text ="Senhas diferentes";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailUser = email.getText().toString();
                senhaUser = senha.getText().toString();
                confirmarSenhaUser = confirmarSenha.getText().toString();
                if (senhaUser.equals(confirmarSenhaUser)){
                    act.setEmailUser(emailUser);
                    act.setSenhaUser(senhaUser);
                    Intent intent = new Intent(CadastroActivity.this, Classe_De_Cadastro.class);
                    startActivity(intent);
                    finish();
                } else{
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });
    }
}
