package com.wsw.gankinfo.view;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.wsw.gankinfo.R;
import com.wsw.gankinfo.databinding.ActivityDailyBinding;
import com.wsw.gankinfo.di.component.AppComponent;
import com.wsw.gankinfo.di.component.DaggerDailyComponent;
import com.wsw.gankinfo.di.module.RecycleViewModule;
import com.wsw.gankinfo.presenter.DailyPresenter;
import com.wsw.gankinfo.view.adapter.DailyAdapter;
import com.wsw.gankinfo.view.transitions.FabTransform;

import javax.inject.Inject;

import vm.DailyImgViewModel;
import vm.EventViewModel;

public class DailyActivity extends BaseActivity<ActivityDailyBinding> {

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//    }

    @Inject
    EventViewModel viewEvents;
    @Inject
    DailyPresenter dailyPresenter;
    @Inject
    LinearLayoutManager linearLayoutManager;
    @Inject
    DailyAdapter dailyAdapter;
    @Inject
    DailyImgViewModel dailyImgViewModel;


    public static final int CHOICE_DATE = 0;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        //初始化Dagger依赖
        DaggerDailyComponent.builder()
                .appComponent(appComponent)
                .recycleViewModule(new RecycleViewModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_daily;
    }

    @Override
    protected void beforeSetViews() {
        b.setEvent(viewEvents);
        b.setImg(dailyImgViewModel);
        dailyAdapter.setActivity(this);
        dailyPresenter.setDailyImgViewModel(dailyImgViewModel);
    }

    @Override
    protected void setViews() {
        setSupportActionBar(b.appBarDaily.toolbar);
        viewEvents.onClick.set(view -> {
            if (view == b.appBarDaily.fab) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(this, DatePickerActivity.class);
                FabTransform.addExtras(intent,
                        ContextCompat.getColor(this, R.color.accent), R.drawable.ic_today_black_24dp);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, b.appBarDaily.fab,
                        getString(R.string.transition_date_picker));
                startActivityForResult(intent, CHOICE_DATE, options.toBundle());
            }
        });
        b.appBarDaily.contentDaily.contentDaily.setLayoutManager(linearLayoutManager);
        b.appBarDaily.contentDaily.contentDaily.setAdapter(dailyAdapter);
    }

    @Override
    protected void doTransaction() {
        dailyPresenter.attemptGetTodayData();
    }

    @Override
    public void onBackPressed() {
        if (b.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            b.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.daily, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
