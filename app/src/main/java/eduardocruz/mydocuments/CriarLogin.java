package eduardocruz.mydocuments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CriarLogin extends AppCompatActivity {

    EditText nome;
    EditText login;
    EditText senha;
    EditText confSenha;
    TextView textError;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nome = (EditText) findViewById(R.id.editText_CriarLogin_nome);
        login = (EditText) findViewById(R.id.editText_CriarLogin_login);
        senha = (EditText) findViewById(R.id.editText_CriarLogin_senha);
        confSenha = (EditText) findViewById(R.id.editText_CriarLogin_confSenha);
        textError = (TextView) findViewById(R.id.textView_CriarLogin_error);

    }

}
