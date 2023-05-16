package com.example.hsrguide.ui.characters

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
            Character("SilverWolf", "image_url_1", "5", "Quantum", "TEst", "Nihility"),
            Character("Tingyun", "image_url_2", "4", "Lightning", "Faction 2", "Harmony"),
            // Add more characters as needed
        )
        val adapter = CharacterAdapter(charactersList)
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}