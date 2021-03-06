package com.gatheringhallstudios.mhworlddatabase.features.locations.detail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import com.gatheringhallstudios.mhworlddatabase.R
import com.gatheringhallstudios.mhworlddatabase.common.BasePagerFragment
import com.gatheringhallstudios.mhworlddatabase.data.models.Location

/**
 * UNUSED. Here because it may be used again
 * Location detail hub. Displays information for a single location
 * The information is split between a number of tabs
 **/
//
//class LocationDetailPagerFragment : BasePagerFragment() {
//    companion object {
//        const val ARG_LOCATION_ID = "LOCATION_ID"
//    }
//
//    override fun onAddTabs(tabs: BasePagerFragment.TabAdder) {
//        //Retrieve LocationID from args
//        val args = arguments;
//        val locationId = args!!.getInt(ARG_LOCATION_ID)
//
//        //Retrieve and set up our ViewModel
//        val viewModel = ViewModelProviders.of(this).get(LocationDetailViewModel::class.java)
//        viewModel.setLocation(locationId)
//
//        viewModel.location.observe(this, Observer<Location> { this.setTitle(it?.name) })
//
//        tabs.addTab(getString(R.string.locations_detail_summary)) {
//            LocationSummaryFragment()
//        }
//
//        tabs.addTab(getString(R.string.locations_detail_gathering)) {
//            LocationGatheringListFragment()
//        }
//    }
//
//    private fun setTitle(title: String?) {
//        activity?.title = title;
//    }
//}