package eduardocruz.mydocuments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import eduardocruz.mydocuments.entidades.Usuario;

public class Home extends AppCompatActivity {

    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent i = getIntent();
        getUser(i.getLongExtra("userId",-1));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == android.R.id.home){

            finish();
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    private void getUser(long id){

        try{

            Usuario u = Usuario.findById(Usuario.class, id);
            this.user = u;

        }catch (Exception e){

            Toast.makeText(getApplicationContext(), R.string.error, Toast.LENGTH_LONG).show();
            System.out.println("Mensagem de erro: "+e.getMessage());
            finish();

        }

    }

    @Override
    public void finish(){
        super.finish();

        Intent i = new Intent(Home.this, Login.class);

        if(this.user == null){

            i.putExtra("autoPrepare", false);

        }else{

            i.putExtra("autoPrepare", true);
            i.putExtra("userId", this.user.getId());

        }

        startActivity(i);

    }
}
