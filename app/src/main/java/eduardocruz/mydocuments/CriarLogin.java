package eduardocruz.mydocuments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import eduardocruz.mydocuments.entidades.Usuario;

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
        toolbar.setTitle(R.string.label_title_criar_login);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nome = (EditText) findViewById(R.id.editText_CriarLogin_nome);
        login = (EditText) findViewById(R.id.editText_CriarLogin_login);
        senha = (EditText) findViewById(R.id.editText_CriarLogin_senha);
        confSenha = (EditText) findViewById(R.id.editText_CriarLogin_confSenha);
        textError = (TextView) findViewById(R.id.textView_CriarLogin_error);

    }

    public void cadastrar(View v){

        String nome = this.nome.getText().toString();
        String login = this.login.getText().toString();
        String senha = this.senha.getText().toString();
        String confSenha = this.confSenha.getText().toString();

        if(nome.isEmpty() || login.isEmpty()){

            textError.setText(R.string.error_preencher_todos_campos);

        }else{

            if(senha.equals(confSenha)){

                if(senha.isEmpty()){

                    textError.setText(R.string.error_preencher_campo_senha);

                }else{

                    textError.setText("");

                    try{

                        Usuario u = new Usuario();
                        u.setNome(nome);
                        u.setLogin(login);
                        u.setSenha(senha);
                        u.setPersist(false);

                        u.save();

                        finish();

                    }catch(Exception e){

                        Toast.makeText(getApplicationContext(), R.string.error, Toast.LENGTH_LONG).show();
                        System.out.println("Codigo de erro: "+e.getMessage());

                    }

                }

            }else{

                textError.setText(R.string.error_senha_invalida);

            }

        }

    }


}
