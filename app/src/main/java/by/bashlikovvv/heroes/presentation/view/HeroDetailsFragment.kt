package by.bashlikovvv.heroes.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.bashlikovvv.heroes.databinding.FragmentHeroDetailsBinding
import by.bashlikovvv.heroes.domain.model.Hero
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

const val KEY_DETAIL = "detailsKey"

@AndroidEntryPoint
class HeroDetailsFragment : Fragment() {

    private var details: Hero? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().apply {
            details = getParcelable(KEY_DETAIL, Hero::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHeroDetailsBinding.inflate(inflater, container, false)

        Glide.with(binding.heroImageView)
            .asBitmap()
            .load(details?.imageUrl)
            .centerCrop()
            .into(binding.heroImageView)
        binding.nameTextView.text = details?.name

        return binding.root
    }
}