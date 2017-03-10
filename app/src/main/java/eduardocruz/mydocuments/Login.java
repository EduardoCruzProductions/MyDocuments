package eduardocruz.mydocuments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import eduardocruz.mydocuments.entidades.Usuario;

public class Login extends AppCompatActivity {

    EditText login;
    EditText senha;
    TextView textError;
    CheckBox persist;

    Usuario user;
    List<Usuario> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        try{

            userList = Usuario.listAll(Usuario.class);

        }catch(Exception e){

            Toast.makeText(getApplicationContext(), R.string.error_get_user_list, Toast.LENGTH_LONG).show();
            System.out.println("Mensagem de erro: "+e.getMessage());
            finish();

        }

        if(persistVerifi()){
            abrirHome();
        }

        login = (EditText) findViewById(R.id.editText_Login_login);
        senha = (EditText) findViewById(R.id.editText_Login_senha);
        textError = (TextView) findViewById(R.id.textView_Login_error);
        persist = (CheckBox) findViewById(R.id.checkBox_login_persist);

    }

    public void abrirCriarUsuario(View v){

        Intent i = new Intent(Login.this, CriarLogin.class);
        startActivity(i);

    }

    public void logar(View v){

        String login = this.login.getText().toString();
        String senha = this.senha.getText().toString();

        if(login.isEmpty() || senha.isEmpty()){

            textError.setText(R.string.error_preencher_todos_campos);

        }else{

            if(autenticator(login, senha)){

                if(persist.isChecked()){

                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Ta vindo aqui");

                    try{

                        persistManage();
                        abrirHome();

                    }catch (Exception e){

                        Toast.makeText(getApplicationContext(), R.string.error, Toast.LENGTH_LONG).show();
                        System.out.println("Mensagem de erro: "+e.getMessage());

                    }

                }else{

                    abrirHome();

                }

            }else{

                textError.setText(R.string.error_login_senha_errado);

            }

        }

    }

    private boolean autenticator(String login, String senha){

        boolean valid = false;

        for(Usuario user: userList){

            if(login.equals(user.getLogin()) && senha.equals(user.getSenha())){
                valid = true;
                this.user = user;
            }

        }

        return valid;

    }

    private void abrirHome(){

        Intent i = new Intent(Login.this, Home.class);
        i.putExtra("userId",this.user.getId());
        startActivity(i);
        finish();

    }

    private void persistManage(){

        for(Usuario user: userList){

            if(user.isPersist()){

                Usuario u = Usuario.findById(Usuario.class, user.getId());
                u.setPersist(false);

            }

        }

        Usuario u = Usuario.findById(Usuario.class, this.user.getId());
        u.setPersist(true);
        u.save();

    }

    private boolean persistVerifi(){

        boolean valid = false;

        for(Usuario user: userList){

            if(user.isPersist()){

                this.user = user;
                valid = true;

            }

        }

        return valid;

    }
}
