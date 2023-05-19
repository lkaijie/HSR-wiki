package com.example.hsrguide.ui.lightcones

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hsrguide.R
import com.example.hsrguide.data.model.Lightcone
import com.example.hsrguide.databinding.LightconesMainBinding
import com.example.hsrguide.ui.BasedFragment
import com.example.hsrguide.ui.characters.GridSpacingItemDecoration
import com.google.android.material.transition.MaterialFadeThrough

class LightconeFragment : Fragment()  {
    private var _binding: LightconesMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = LightconesMainBinding.inflate(inflater, container, false)

        enterTransition = MaterialFadeThrough()
        exitTransition = MaterialFadeThrough()

        // set up recycler view
        val recyclerView = binding.lightconesRecyclerView
        val layoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = layoutManager
        val lightconeList = listOf(
            Lightcone("The Birth of the Self", "This is the first lightcone", "4", path = "Erudition", hp = "43", atk = "21", def="15"),
            Lightcone("Swordplay", "This is the first lightcone", "4", path = "Erudition", hp = "43", atk = "21", def="15"),
            Lightcone("The Birth of the Self", "This is the first lightcone", "4", path = "Erudition", hp = "43", atk = "21", def="15"),
            Lightcone("The Birth of the Self", "This is the first lightcone", "4", path = "Erudition", hp = "43", atk = "21", def="15"),
            Lightcone("The Birth of the Self", "This is the first lightcone", "4", path = "Erudition", hp = "43", atk = "21", def="15"),
            Lightcone("The Birth of the Self", "This is the first lightcone", "4", path = "Erudition", hp = "43", atk = "21", def="15"),

            )
        val adapter = LightconeAdapter(lightconeList)
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
}