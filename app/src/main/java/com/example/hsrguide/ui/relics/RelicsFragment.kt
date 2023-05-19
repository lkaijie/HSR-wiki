package com.example.hsrguide.ui.relics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hsrguide.R
import com.example.hsrguide.data.model.Relic
import com.example.hsrguide.databinding.RelicsMainBinding
import com.example.hsrguide.ui.BasedFragment
import com.example.hsrguide.ui.characters.GridSpacingItemDecoration
import com.google.android.material.transition.MaterialFadeThrough

class RelicsFragment: Fragment() {
    private var _binding: RelicsMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = RelicsMainBinding.inflate(inflater, container, false)
        enterTransition = MaterialFadeThrough()
        exitTransition = MaterialFadeThrough()


        val recyclerView = binding.relicsRecyclerView
        val layoutManager = GridLayoutManager(context,2)
        recyclerView.layoutManager = layoutManager

        val relicsList = listOf(
            Relic ("Firesmith of Lava-Forging", "image_url_1", "Increases Fire DMG by 10%.", "Increases Overloaded and Burning DMG by 40%. Increases Vaporize and Melt DMG by 15%. Using an Elemental Skill increases the 2-Piece Set Bonus by 50% of its starting value for 10s. Max 3 stacks."),
            Relic ("Firesmith of Lava-Forging", "image_url_1", "Increases Fire DMG by 10%.", "Increases Overloaded and Burning DMG by 40%. Increases Vaporize and Melt DMG by 15%. Using an Elemental Skill increases the 2-Piece Set Bonus by 50% of its starting value for 10s. Max 3 stacks."),
            Relic ("Firesmith of Lava-Forging", "image_url_1", "Increases Fire DMG by 10%.", "Increases Overloaded and Burning DMG by 40%. Increases Vaporize and Melt DMG by 15%. Using an Elemental Skill increases the 2-Piece Set Bonus by 50% of its starting value for 10s. Max 3 stacks."),
            Relic ("Firesmith of Lava-Forging", "image_url_1", "Increases Fire DMG by 10%.", "Increases Overloaded and Burning DMG by 40%. Increases Vaporize and Melt DMG by 15%. Using an Elemental Skill increases the 2-Piece Set Bonus by 50% of its starting value for 10s. Max 3 stacks."),
        )

        val adapter = RelicAdapter(relicsList)
        recyclerView.adapter = adapter
        val spanCount = 2 // Number of columns in the grid

        val spacing = resources.getDimensionPixelSize(R.dimen.grid_spacing) // Spacing between items in pixels
        val includeEdge = true // Include spacing at the edges of the grid

        recyclerView.addItemDecoration(GridSpacingItemDecoration(spanCount, spacing, includeEdge))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}