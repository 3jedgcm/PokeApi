package fr.coopuniverse.api.pokeapi.activity.activity

import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import fr.coopuniverse.api.pokeapi.R
import fr.coopuniverse.api.pokeapi.activity.callback.CallBackFragment
import fr.coopuniverse.api.pokeapi.activity.data.Account
import fr.coopuniverse.api.pokeapi.activity.fragment.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*


class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, CallBackFragment
{
    private var acc = Account()

    override fun setFragment(dest: Destination) {
        var fragment = when(dest)
        {
            Destination.Home -> HomeFragment()
            Destination.Market -> MarketFragment()
            Destination.Craft -> CraftFragment()
            Destination.Melt -> MeltFragment()
            Destination.Quizz -> QuizzFragment()
            Destination.Shop -> ShopFragment()
            Destination.Exchange -> ExchangeFragment()
            Destination.Settings -> SettingsFragment()
            Destination.Inventory -> InventoryFragment()
            Destination.CardDetail -> CardDetailFragment()
        }
        fragment.arguments = this.getBundle()
        supportFragmentManager.beginTransaction().replace(R.id.contentHome,fragment).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        val defaultFragment = InventoryFragment()
        val header: View
        val userNameField: TextView
        val connectWithField: TextView

        this.acc?.name = intent.extras.getString("name")
        this.acc?.surname = intent.extras.getString("lastname")
        this.acc?.id = intent.extras.getString("id")
        this.acc?.urlPicture = intent.extras.getString("url")
        this.acc?.connectWith = intent.extras.getString("connectWith")

        defaultFragment.arguments = this.getBundle()
        supportFragmentManager.beginTransaction().add(R.id.contentHome,defaultFragment).commit()
        nav_view.setNavigationItemSelectedListener(this)
        header = nav_view.getHeaderView(0)
        userNameField = header.findViewById(R.id.userNameField)
        connectWithField = header.findViewById(R.id.connectWithField)
        userNameField.text = acc?.name
        connectWithField.text = "Connect with " + acc?.connectWith
    }

    override fun onBackPressed()
    {
        if (drawer_layout.isDrawerOpen(GravityCompat.START))
        {
            drawer_layout.closeDrawer(GravityCompat.START)
        }
        else
        {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean
    {
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        return when (item.itemId)
        {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean
    {
        when (item.itemId)
        {
            R.id.nav_inventory ->
            {
                this.setFragment(Destination.Inventory)
            }
            R.id.nav_market ->
            {
                this.setFragment(Destination.Market)
            }
            R.id.nav_settings ->
            {
                this.setFragment(Destination.Settings)
            }
            R.id.nav_game ->
            {
                this.setFragment(Destination.Home)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun getBundle(): Bundle?
    {
        val bundle: Bundle? = Bundle()
        bundle?.putString("id",acc?.id)
        bundle?.putString("money",acc?.money)
        return bundle
    }
}
