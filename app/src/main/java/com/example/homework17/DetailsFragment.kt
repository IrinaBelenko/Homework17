package com.example.homework17

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class DetailsFragment : Fragment() {
    private var description = ""
    private var name = ""
    private var imageH = ""
    private var detailsTitle: TextView? = null
    private var nameHero: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailsTitle = view.findViewById(R.id.details)
        nameHero = view.findViewById(R.id.nameHero)
        val imageHero: ImageView = view.findViewById(R.id.imageHero)
        detailsTitle?.text = description
        nameHero?.text = name
        Glide.with(view.context)
            .load(imageH)
            .into(imageHero)
    }

    fun setDescription(imageURL: String, nameHero: String, listValue: String) {
        description = listValue
        name = nameHero
        imageH = imageURL
    }

    fun show() {
        detailsTitle?.text = description
    }
}