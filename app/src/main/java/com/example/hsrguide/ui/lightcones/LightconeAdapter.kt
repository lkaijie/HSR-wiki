package com.example.hsrguide.ui.lightcones

import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.hsrguide.R
import com.example.hsrguide.data.model.Lightcone
import com.example.hsrguide.databinding.ItemLightconeBinding

class LightconeAdapter(private val lightcones: List<Lightcone>): RecyclerView.Adapter<LightconeAdapter.LightconeViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LightconeViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_lightcone, parent, false)

            val displayMetrics = parent.context.resources.displayMetrics
            val screenHeight = if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                // Portrait mode
                displayMetrics.heightPixels
            } else {
                // Landscape mode
                displayMetrics.widthPixels
            }
            val portionRatio = 0.3 // 40% of the screen height
            val portionHeight = (screenHeight * portionRatio).toInt()

            val layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, portionHeight)
            itemView.layoutParams = layoutParams

            return LightconeViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: LightconeViewHolder, position: Int) {
            val lightcone = lightcones[position]
            holder.bind(lightcone)
        }

        override fun getItemCount(): Int {
            return lightcones.size
        }

//    override fun getItemId(position: Int): Long {
        class LightconeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

            fun bind(lightcone: Lightcone) {
                val binding = ItemLightconeBinding.bind(itemView)
                binding.apply {
                    lightconeName.text = lightcone.name
                    characterHp.text = lightcone.hp.toString()
                    characterAtk.text = lightcone.atk.toString()
                    characterDef.text = lightcone.def.toString()


//                    val assetManager = itemView.context.assets
//                    val resourceName = "lightcones/${lightcone.name.lowercase()}.png"
//                    val inputStream = assetManager.open(resourceName)
//                    val drawable = Drawable.createFromStream(inputStream, null)
//                    characterImg.setImageDrawable(drawable)


                    val assetManager = itemView.context.assets
                    val resourceName = "lightcones/${lightcone.name.lowercase()}.png"
                    val assetPath = "file:///android_asset/$resourceName"

                    Glide.with(itemView)
                        .load(Uri.parse(assetPath))
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(characterImg)

                    if (lightcone.rarity == "4"){
                        rarityStar1.setImageResource(R.drawable.rarity_4)
                        binding.root.setBackgroundResource(R.drawable.four_star_background)
                    } else{
                        rarityStar1.setImageResource(R.drawable.rarity_5)
                        binding.root.setBackgroundResource(R.drawable.five_star_background)
                    }

                    when (lightcone.path){
                        "Nihility" -> {
                            lightconePath.text = "The "+ lightcone.path
                            characterElement.setImageResource(R.drawable.nihility_hsr)
                            pathIcon.setImageResource(R.drawable.nihility_hsr)
                        }
                        "Destruction" -> {
                            lightconePath.text = "The "+ lightcone.path
                            characterElement.setImageResource(R.drawable.destruction_hsr)
                            pathIcon.setImageResource(R.drawable.destruction_hsr)
                        }
                        "Erudition" -> {
                            lightconePath.text = "The "+ lightcone.path
                            characterElement.setImageResource(R.drawable.erudition_hsr)
                            pathIcon.setImageResource(R.drawable.erudition_hsr)
                        }
                        "Harmony" -> {
                            lightconePath.text = "The "+ lightcone.path
                            characterElement.setImageResource(R.drawable.harmony_hsr)
                            pathIcon.setImageResource(R.drawable.harmony_hsr)
                        }
                        "Preservation" -> {
                            lightconePath.text = "The "+ lightcone.path
                            characterElement.setImageResource(R.drawable.preservation_hsr)
                            pathIcon.setImageResource(R.drawable.preservation_hsr)
                        }
                        "Abundance" -> {
                            lightconePath.text = "The "+ lightcone.path
                            characterElement.setImageResource(R.drawable.abundance_hsr)
                            pathIcon.setImageResource(R.drawable.abundance_hsr)
                        }
                        "Hunt" -> {
                            lightconePath.text = "The "+ lightcone.path
                            characterElement.setImageResource(R.drawable.hunt_hsr)
                            pathIcon.setImageResource(R.drawable.hunt_hsr)
                        }
                    }
                }
                }
            }


}