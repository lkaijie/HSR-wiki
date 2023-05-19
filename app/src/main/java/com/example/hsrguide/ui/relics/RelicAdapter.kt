package com.example.hsrguide.ui.relics

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hsrguide.R
import com.example.hsrguide.data.model.Relic
import com.example.hsrguide.databinding.ItemRelicBinding
import com.example.hsrguide.ui.lightcones.LightconeAdapter

class RelicAdapter(private val relics: List<Relic>): RecyclerView.Adapter<RelicAdapter.RelicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelicViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_relic, parent, false)
//
//        val displayMetrics = parent.context.resources.displayMetrics
//        val screenHeight = if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
//            // Portrait mode
//            displayMetrics.heightPixels
//        } else {
//            // Landscape mode
//            displayMetrics.widthPixels
//        }
//        val portionRatio = 0.3 // 40% of the screen height
//        val portionHeight = (screenHeight * portionRatio).toInt()
//
//        val layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, portionHeight)
//        itemView.layoutParams = layoutParams

        return RelicViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: RelicViewHolder, position: Int) {
            val relic = relics[position]
            holder.bind(relic)
        }

        override fun getItemCount(): Int = relics.size

        inner class RelicViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            fun bind(relic: Relic) {
                val binding = ItemRelicBinding.bind(itemView)
                binding.apply {
                    relicName.text = relic.name
                    relic2p.text = relic.two_pc
                    relic4p.text = relic.four_pc
                    val assetManager = itemView.context.assets
                    val resourceName = "relics/${relic.name.lowercase()}.png"
                    val inputStream = assetManager.open(resourceName)
                    val drawable = Drawable.createFromStream(inputStream, null)
                    characterImg.setImageDrawable(drawable)


                }
            }
        }

}