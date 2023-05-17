package com.example.hsrguide.ui.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hsrguide.R
import com.example.hsrguide.databinding.ItemCharacterBinding
import com.example.hsrguide.data.model.Character


class CharacterAdapter(private val characters: List<Character>): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)


        // testing
        val screenHeight = parent.context.resources.displayMetrics.heightPixels
        val portionRatio = 0.6 // 60% of the screen height
        val portionHeight = (screenHeight * portionRatio).toInt()

        val layoutParams = itemView.layoutParams
        layoutParams.height = portionHeight
        itemView.layoutParams = layoutParams

        return CharacterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(character: Character) {
            val binding = ItemCharacterBinding.bind(itemView)
            binding.apply {
                characterName.text = character.name
                characterFaction.text = "Faction: "+ character.faction

                val resourceName = character.name.lowercase() + "_big"
                val resId = itemView.context.resources.getIdentifier(resourceName, "drawable", itemView.context.packageName)
                characterImg.setImageResource(resId)

                if (character.rarity == "4"){
                    rarityStar5.visibility = View.GONE
                    binding.root.setBackgroundResource(R.drawable.four_star_background)

                } else{
                    binding.root.setBackgroundResource(R.drawable.five_star_background)
                }

                when (character.path){
                    "Nihility" -> {
                        characterPath.text = "Path: "+ character.path
                        pathIcon.setImageResource(R.drawable.nihility_hsr)
                    }
                    "Destruction" -> {
                        characterPath.text = "Path: "+ character.path
                        pathIcon.setImageResource(R.drawable.destruction_hsr)
                    }
                    "Erudition" -> {
                        characterPath.text = "Path: "+ character.path
                        pathIcon.setImageResource(R.drawable.erudition_hsr)
                    }
                    "Harmony" -> {
                        characterPath.text = "Path: "+ character.path
                        pathIcon.setImageResource(R.drawable.harmony_hsr)
                    }
                    "Preservation" -> {
                        characterPath.text = "Path: "+ character.path
                        pathIcon.setImageResource(R.drawable.preservation_hsr)
                    }
                    "Abundance" -> {
                        characterPath.text = "Path: "+ character.path
                        pathIcon.setImageResource(R.drawable.abundance_hsr)
                    }
                    "Hunt" -> {
                        characterPath.text = "Path: "+ character.path
                        pathIcon.setImageResource(R.drawable.hunt_hsr)
                    }

                }
                when (character.element){
                    "Wind" -> {
                        characterElementText.text = "Element: "+ character.element
                        characterElementImg.setImageResource(R.drawable.wind_hsr)
                        characterElement.setImageResource(R.drawable.wind_hsr)
                    }
                    "Fire" -> {
                        characterElementText.text = "Element: "+ character.element
                        characterElementImg.setImageResource(R.drawable.fire_hsr)
                        characterElement.setImageResource(R.drawable.fire_hsr)
                    }
                    "Ice" -> {
                        characterElementText.text = "Element: "+ character.element
                        characterElementImg.setImageResource(R.drawable.ice_hsr)
                        characterElement.setImageResource(R.drawable.ice_hsr)
                    }
                    "Quantum" -> {
                        characterElementText.text = "Element: "+ character.element
                        characterElementImg.setImageResource(R.drawable.quantum_hsr)
                        characterElement.setImageResource(R.drawable.quantum_hsr)
                    }
                    "Imaginary" -> {
                        characterElementText.text = "Element: "+ character.element
                        characterElementImg.setImageResource(R.drawable.imaginary_hsr)
                        characterElement.setImageResource(R.drawable.imaginary_hsr)
                    }
                    "Physical" -> {
                        characterElementText.text = "Element: "+ character.element
                        characterElementImg.setImageResource(R.drawable.physical_hsr)
                        characterElement.setImageResource(R.drawable.physical_hsr)
                    }
                    "Lightning" -> {
                        characterElementText.text = "Element: "+ character.element
                        characterElementImg.setImageResource(R.drawable.lightning_hsr)
                        characterElement.setImageResource(R.drawable.lightning_hsr)
                    }
                }


            }

        }
    }
}