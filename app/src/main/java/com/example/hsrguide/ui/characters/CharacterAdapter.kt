package com.example.hsrguide.ui.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hsrguide.R
import com.example.hsrguide.databinding.ItemCharacterBinding

class CharacterAdapter(private val characters: List<Char>): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
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
        fun bind(character: com.example.hsrguide.data.model.Character) {
            val binding = ItemCharacterBinding.bind(itemView)
            binding.apply {
                characterName.text = character.name



                if (character.rarity == "4"){
                    rarityStar5.visibility = View.GONE
                }
                when (character.path){
                    "Nihility" -> {
                        characterPath.text = "Path: "+ Character.path
                        pathIcon.setImageResource(R.drawable.nihility_hsr)
                    }
                    "Destruction" -> {
                        characterPath.text = "Path: "+ Character.path
                        pathIcon.setImageResource(R.drawable.destruction_hsr)
                    }
                    "Erudition" -> {
                        characterPath.text = "Path: "+ Character.path
                        pathIcon.setImageResource(R.drawable.erudition_hsr)
                    }
                    "Harmony" -> {
                        characterPath.text = "Path: "+ Character.path
                        pathIcon.setImageResource(R.drawable.harmony_hsr)
                    }
                    "Preservation" -> {
                        characterPath.text = "Path: "+ Character.path
                        pathIcon.setImageResource(R.drawable.preservation_hsr)
                    }
                    "Abundance" -> {
                        characterPath.text = "Path: "+ Character.path
                        pathIcon.setImageResource(R.drawable.abundance_hsr)
                    }
                    "Hunt" -> {
                        characterPath.text = "Path: "+ Character.path
                        pathIcon.setImageResource(R.drawable.hunt_hsr)
                    }

                }
                when (character.element){
                    "Wind" -> {
                        characterElementText.text = "Element: "+ Character.element
                        characterElementImg.setImageResource(R.drawable.wind_hsr)
                        characterElement.setImageResource(R.drawable.wind_hsr)
                    }
                    "Fire" -> {
                        characterElementText.text = "Element: "+ Character.element
                        characterElementImg.setImageResource(R.drawable.fire_hsr)
                        characterElement.setImageResource(R.drawable.fire_hsr)
                    }
                    "Ice" -> {
                        characterElementText.text = "Element: "+ Character.element
                        characterElementImg.setImageResource(R.drawable.ice_hsr)
                        characterElement.setImageResource(R.drawable.ice_hsr)
                    }
                    "Quantum" -> {
                        characterElementText.text = "Element: "+ Character.element
                        characterElementImg.setImageResource(R.drawable.quantum_hsr)
                        characterElement.setImageResource(R.drawable.quantum_hsr)
                    }
                    "Imaginary" -> {
                        characterElementText.text = "Element: "+ Character.element
                        characterElementImg.setImageResource(R.drawable.imaginary_hsr)
                        characterElement.setImageResource(R.drawable.imaginary_hsr)
                    }
                    "Physical" -> {
                        characterElementText.text = "Element: "+ Character.element
                        characterElementImg.setImageResource(R.drawable.physical_hsr)
                        characterElement.setImageResource(R.drawable.physical_hsr)
                    }
                    "Lightning" -> {
                        characterElementText.text = "Element: "+ Character.element
                        characterElementImg.setImageResource(R.drawable.lightning_hsr)
                        characterElement.setImageResource(R.drawable.lightning_hsr)
                    }
                }


            }

        }
    }
}