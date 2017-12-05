package com.example.jonataswinston.outrotesteloginfire;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    protected Button button;
    protected Button button2;
    protected EditText email;
    protected EditText senha;
    private static String emailUser = "xxxx";
    private static String senhaUser = "xxxx";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.loginButton);
        button2 = (Button) findViewById(R.id.CadastroButton);
        email = (EditText) findViewById(R.id.usuario);
        senha = (EditText) findViewById(R.id.senha);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailUser = email.getText().toString();
                senhaUser = senha.getText().toString();
                System.out.println("email: "+emailUser+"| Senha: "+senhaUser);
                Intent intent = new Intent(MainActivity.this, Classe_De_Autenticacao.class);
                startActivity(intent);
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public String getEmailUser(){
        return emailUser;
    }
    public String getSenhaUser(){
        return senhaUser;
    }
    public void setEmailUser(String emailUser){
        this.emailUser = emailUser;
    }
    public void setSenhaUser(String senhaUser){
        this.senhaUser = senhaUser;
    }
}
