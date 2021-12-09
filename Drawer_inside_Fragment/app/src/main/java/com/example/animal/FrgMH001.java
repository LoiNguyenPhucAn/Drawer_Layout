package com.example.animal;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.animal.databinding.DrawerBinding;

/** https://developer.android.com/guide/fragments/appbar#java
 * When using fragments, the app bar can be implemented as an ActionBar that is owned by the host activity or a toolbar within your fragment's layout.
 * Ownership of the app bar varies depending on the needs of your app.
 *
 * If all your screens use the same app bar that's always at the top and spans the width of the screen,
 * then you should use a theme-provided action bar hosted by the activity. Using theme app bars helps
 * to maintain a consistent look and provides a place to host option menus and an up button.
 *
 * Use a toolbar hosted by the fragment if you want more control over the size, placement, and animation of the app bar across multiple screens.
 * For example, you might need a collapsing app bar or one that spans only half the width of the screen and is vertically centered.
 *
 * */


public class FrgMH001 extends Fragment {

    Context mContext;

    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;

    DrawerBinding drawerBinding;

    /** https://developer.android.com/guide/fragments/appbar#activity-register
     * The app bar is most commonly owned by the host activity.
     * When the app bar is owned by an activity, fragments can interact with the app bar by overriding framework methods that are called during fragment creation.
     *You must inform the system that your app bar fragment is participating in the population of the options menu.
     * To do this, call setHasOptionsMenu(true) in your fragment's onCreate(Bundle) method.
     *
     * setHasOptionsMenu(true) tells the system that your fragment would like to receive menu-related callbacks.
     * When a menu-related event occurs (creation, clicks, and so on), the event handling method is first called on the activity before being called on the fragment.
     * Note that your application logic should not depend on this order. If multiple fragments are hosted by the same activity, each fragment can supply menu options.
     * */

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        drawerBinding = DrawerBinding.inflate(inflater,container,false);
        init();
        View rootView = drawerBinding.getRoot();
        return rootView;
    }

    private void init() {
        toolbar = drawerBinding.hostContentWithAppbar.toolBar;
        drawer = drawerBinding.drawer;

        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle((MainActivity) getActivity(),drawer,R.string.open,R.string.close );
        toggle.getDrawerArrowDrawable().setColor(ContextCompat.getColor(mContext,R.color.white));
        toggle.syncState();
        drawer.addDrawerListener(toggle);


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }


    /** https://developer.android.com/guide/fragments/appbar#activity-click
     * Every activity and fragment that participates in the options menu is able to respond to touches.
     * Fragment's onOptionsItemSelected() receives the selected menu item as a parameter and returns a boolean to indicate whether or not the touch has been consumed.
     * Once an activity or fragment returns true from onOptionsItemSelected(), no other participating fragments will receive the callback.
     * */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
