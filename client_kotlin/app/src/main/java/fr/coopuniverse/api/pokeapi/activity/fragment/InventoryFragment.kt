package fr.coopuniverse.api.pokeapi.activity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import fr.coopuniverse.api.pokeapi.R
import fr.coopuniverse.api.pokeapi.activity.callback.CallBackDisplay
import fr.coopuniverse.api.pokeapi.activity.callback.CallBackOnClickCard
import fr.coopuniverse.api.pokeapi.activity.adapter.CardsListAdapter
import fr.coopuniverse.api.pokeapi.activity.httpRequestManager.CallBackGenerator
import fr.coopuniverse.api.pokeapi.activity.data.Card
import fr.coopuniverse.api.pokeapi.activity.data.Reponse



class InventoryFragment : androidx.fragment.app.Fragment(), CallBackDisplay, CallBackOnClickCard {

    var recView_Inventory: androidx.recyclerview.widget.RecyclerView? = null;
    private var anotherView: View? = null;
    private var cards: ArrayList<Card> = ArrayList()
    override fun onClickCard(cardId: String) {
        var fragment = CardDetailFragment()
        for (c: Card in cards)
        {
            if (c.id.equals(cardId))
           {
            fragment.card = c
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.contentHome,fragment)?.commit()
           }
        }
    }

    override fun display(rep: Reponse, action: String) {
        cards = rep.data.cards
        this.recView_Inventory = anotherView!!.findViewById(R.id.recView_Inventory)
        var adapterReclView = CardsListAdapter(cards, targetFragment, this)
        recView_Inventory?.layoutManager = androidx.recyclerview.widget.GridLayoutManager(this.context, 3)
        recView_Inventory?.adapter=  adapterReclView
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
       this.anotherView =  inflater.inflate(R.layout.inventory_fragment, container, false)
       CallBackGenerator(callback = this,action = "GetAllCard",isActivateCallBack = true, url = "https://api.coopuniverse.fr/").execute()
       return this.anotherView
    }
}
