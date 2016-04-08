package hu.cewi.client.user;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

import dagger.Module;

@Module
public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // This is a comment
        // myPC
    }
}
