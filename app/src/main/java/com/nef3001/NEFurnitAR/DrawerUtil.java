package com.nef3001.NEFurnitAR;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import static android.support.v4.content.ContextCompat.startActivity;


public class DrawerUtil {

    private static GoogleApiClient mGoogleApiClient;
    private static Context c;

    public static void getDrawer(final Activity activity, Toolbar toolbar) {
        //if you want to update the items at a later time it is recommended to keep it in a variable

        PrimaryDrawerItem products = new PrimaryDrawerItem().withIdentifier(1)
                .withName(R.string.products).withIcon(R.drawable.ic_subject_black_24dp);
        SecondaryDrawerItem show_cart = new SecondaryDrawerItem()
                .withIdentifier(2).withName(R.string.show_cart).withIcon(R.drawable.ic_shopping_cart_black_24dp);
        SecondaryDrawerItem about = new SecondaryDrawerItem()
                .withIdentifier(3).withName(R.string.about).withIcon(R.drawable.ic_about_24);
        SecondaryDrawerItem help = new SecondaryDrawerItem()
                .withIdentifier(4).withName(R.string.help).withIcon(R.drawable.ic_help_24);
        SecondaryDrawerItem logout = new SecondaryDrawerItem()
                .withIdentifier(5).withName(R.string.log_out).withIcon(R.drawable.ic_exit_to_app_black_24dp);

// Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(activity)
                .withHeaderBackground(R.color.overlaybackground)
                .addProfiles(
                        new ProfileDrawerItem().withName(common.currentUser.getName()).withEmail(common.currentUser.getEmail()).withIcon(common.currentUser.photo)
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(activity)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
                .withCloseOnClick(true)
                .withSelectedItem(-1)
                .withTranslucentNavigationBar(true)
                .addDrawerItems(
                        products,
                        new DividerDrawerItem(),
                        show_cart,
                        about,
                        help,
                        logout
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem.getIdentifier() == 1 && !(activity instanceof MainActivity)) {
                            Intent intent = new Intent(activity, MainActivity.class);
                            view.getContext().startActivity(intent);
                        } else if (drawerItem.getIdentifier() == 2) {
                            Intent intent = new Intent(activity, cart_activity.class);
                            view.getContext().startActivity(intent);
                        }else if (drawerItem.getIdentifier() == 3) {
                            Intent intent = new Intent(activity, about.class);
                            view.getContext().startActivity(intent);
                        }else if (drawerItem.getIdentifier() == 4) {
                            Intent intent = new Intent(activity, help.class);
                            view.getContext().startActivity(intent);
                        } else if (drawerItem.getIdentifier() == 5) {
                            FirebaseAuth.getInstance().signOut();
                            Intent intent = new Intent(activity, Login.class);
                            view.getContext().startActivity(intent);

                        }
                        return true;
                    }
                })
                .build();

    }
}

