package com.zwt.charsboard.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.carousel.CarouselLayoutManager
import com.zwt.charsboard.R
import com.zwt.charsboard.databinding.FragmentGalleryBinding

import com.zwt.charsboard.viewmodel.GalleryViewModel

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this)[GalleryViewModel::class.java]

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val carouselRecyclerView = _binding?.carouselRecyclerView
        val multiBrowseCenteredCarouselLayoutManager = CarouselLayoutManager()
        carouselRecyclerView?.layoutManager = multiBrowseCenteredCarouselLayoutManager
        carouselRecyclerView?.isNestedScrollingEnabled = false


        val carouselImageList = CarouselData.createItems()
        val adapter =
            CarouselAdapter { item, position ->
                carouselRecyclerView?.scrollToPosition(
                    position
                )
                //Enlarge the selected picture
                binding.carouselImgFull.setImageResource(carouselImageList[position].drawableRes)
            }
        carouselRecyclerView?.adapter = adapter

        adapter.submitList(carouselImageList)

        //Set default value of the enlarged image
        _binding?.carouselImgFull?.setImageResource(R.mipmap.unlock)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}