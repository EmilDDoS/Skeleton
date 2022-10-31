package com.example.skeleton.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.ethanhua.skeleton.Skeleton
import com.example.skeleton.R
import com.example.skeleton.databinding.FragmentMainBinding
import com.example.skeleton.databinding.SkeletonLayoutBinding
import com.example.skeleton.di.ViewModelFactory
import com.example.skeleton.presentation.adapters.PhotosAdapter
import kotlinx.coroutines.delay


class PhotosFragment : Fragment() {

    private var adapter = PhotosAdapter()

    private lateinit var binding: FragmentMainBinding
    private val viewModel: PhotosViewModel by viewModels { ViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.photosRecyclerView.adapter = adapter
        val skeleton = Skeleton.bind(binding.photosRecyclerView)
            .adapter(adapter)
            .load(R.layout.skeleton_layout)
            .angle(0)
            .show();

        lifecycleScope.launchWhenCreated {
            viewModel.photosData.collect {
                adapter.photosList = it
                delay(4000)//для наглядности
                skeleton.hide();
            }
        }

        viewModel.getData()
    }
}