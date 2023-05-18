package com.example.hsrguide.ui.characters

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hsrguide.R
import com.example.hsrguide.databinding.CharactersMainBinding
import com.example.hsrguide.data.model.Character
import com.example.hsrguide.ui.characters.GridSpacingItemDecoration
import java.util.*


class Characters : Fragment() {
    private var _binding: CharactersMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = CharactersMainBinding.inflate(inflater, container, false)


        // set up the recycler view
        val recyclerView = binding.charactersRecyclerView
        val layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.layoutManager = layoutManager
        val charactersList = listOf(
//            Character("SilverWolf", "image_url_1", "5", "Quantum", "TEst", "Nihility", id = UUID.randomUUID().toString()),
//            Character("Tingyun", "image_url_2", "4", "Lightning", "Faction 2", "Harmony", id = UUID.randomUUID().toString()),
//            // Add more characters as needed
//            Character("SilverWolf", "image_url_1", "5", "Quantum", "TEst", "Nihility", id = UUID.randomUUID().toString()),
//            Character("SilverWolf", "image_url_1", "5", "Quantum", "TEst", "Nihility", id = UUID.randomUUID().toString()),
//            Character("SilverWolf", "image_url_1", "5", "Quantum", "TEst", "Nihility", id = UUID.randomUUID().toString()),
//            Character("SilverWolf", "image_url_1", "5", "Quantum", "TEst", "Nihility", id = UUID.randomUUID().toString()),
//
//            Character("Tingyun", "image_url_2", "4", "Lightning", "Faction 2", "Harmony", id = UUID.randomUUID().toString()),
//            Character("Tingyun", "image_url_2", "4", "Lightning", "Faction 2", "Harmony", id = UUID.randomUUID().toString()),
//            Character("Tingyun", "image_url_2", "4", "Lightning", "Faction 2", "Harmony", id = UUID.randomUUID().toString()),
//            Character("Tingyun", "image_url_2", "4", "Lightning", "Faction 2", "Harmony", id = UUID.randomUUID().toString()),
//
//            Character("Jing Yuan", "image_url_2", "5", "Lightning", "GEnshin impact", "Erudition", id = UUID.randomUUID().toString()),
            // paths : "Nihility" "Harmony" "Destruction" "Quantum" "Lightning" "Erudition" "Hunt" "Abundance" "Preservation"
            Character("SilverWolf", "image_url_1", "5", "Quantum", "TEst", "Nihility"),
            Character("Tingyun", "image_url_2", "4", "Lightning", "Faction 2", "Harmony"),
            // Add more characters as needed
            Character("SilverWolf", "image_url_1", "5", "Quantum", "TEst", "Nihility"),
            Character("SilverWolf", "image_url_1", "5", "Quantum", "TEst", "Nihility"),
            Character("SilverWolf", "image_url_1", "5", "Quantum", "TEst", "Nihility"),
            Character("SilverWolf", "image_url_1", "5", "Quantum", "TEst", "Nihility"),
            Character("Tingyun", "image_url_2", "4", "Lightning", "Faction 2", "Harmony"),
            Character("Tingyun", "image_url_2", "4", "Lightning", "Faction 2", "Harmony"),
            Character("Tingyun", "image_url_2", "4", "Lightning", "Faction 2", "Harmony"),
            Character("Tingyun", "image_url_2", "4", "Lightning", "Faction 2", "Harmony"),
            Character("Tingyun", "image_url_2", "4", "Lightning", "Faction 2", "Harmony"),
            Character("Jing Yuan", "image_url_2", "5", "Lightning", "GEnshin impact", "Erudition"),
            )
//        for (item in charactersList) {
//            val randomId = UUID.randomUUID().toString()
//            item.id = randomId
//        }

        val adapter = CharacterAdapter(charactersList)

//        test
//        adapter.setHasStableIds(true)
        recyclerView.adapter = adapter

        val spanCount = 2 // Number of columns in the grid

//        val desiredColumnWidth = resources.getDimensionPixelSize(R.dimen.desired_column_width)  // max width?
//        val displayMetrics = resources.displayMetrics
//        val screenWidth = displayMetrics.widthPixels
//        val spanCount = screenWidth / desiredColumnWidth
//        layoutManager.spanCount = spanCount



        val spacing = resources.getDimensionPixelSize(R.dimen.grid_spacing) // Spacing between items in pixels
        val includeEdge = true // Include spacing at the edges of the grid

        recyclerView.addItemDecoration(GridSpacingItemDecoration(spanCount, spacing, includeEdge))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

//    override fun onConfigurationChanged(newConfig: Configuration) {
//        super.onConfigurationChanged(newConfig)
//        val recyclerView = binding.charactersRecyclerView
//        val layoutManager = GridLayoutManager(requireContext(), calculateSpanCount(newConfig))
//        recyclerView.layoutManager = layoutManager
//    }
//
//    private fun calculateSpanCount(configuration: Configuration): Int {
//        // Calculate the number of columns based on the new configuration
//        // You can customize the logic here based on your requirements
//        return if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            3 // 3 columns in landscape orientation
//        } else {
//            2 // 2 columns in portrait orientation
//        }
//    }
//    TODO: implement infinite scrolling kinda? only show pics and stuff when scrolled to

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}