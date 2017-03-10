package eduardocruz.mydocuments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    EditText login;
    EditText senha;
    TextView textError;
    CheckBox persist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (EditText) findViewById(R.id.editText_Login_login);
        senha = (EditText) findViewById(R.id.editText_Login_senha);
        textError = (TextView) findViewById(R.id.textView_Login_error);
        persist = (CheckBox) findViewById(R.id.checkBox_login_persist);

    }


    public void abrirCriarUsuario(View v){

        Intent i = new Intent(Login.this, CriarLogin.class);
        startActivity(i);

    }

}
