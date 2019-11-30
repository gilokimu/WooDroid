package me.gilo.woodroid.app.adapter


import android.content.Context
import androidx.viewpager.widget.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import me.gilo.woodroid.app.R
import me.gilo.woodroid.models.Image


class ImagePagerAdapter(val context: Context, private val images: List<Image>) : PagerAdapter() {


    override fun instantiateItem(collection: ViewGroup, position: Int): View {
        val inflater = LayoutInflater.from(context)

        val layout = inflater.inflate(R.layout.single_product_image, collection, false)
        val ivImage = layout.findViewById<ImageView>(R.id.ivImage)

        val image = images[position]
        Picasso
            .with(context)
            .load(image.src)
            .into(ivImage)

        collection.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }

    override fun getCount(): Int {
        return this.images.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

}