package com.bhartenduKodes.nectar.ui.fragments

import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import coil.load
import com.bhartenduKodes.nectar.R
import com.bhartenduKodes.nectar.base.BaseFragment
import com.bhartenduKodes.nectar.data.model.Product
import com.bhartenduKodes.nectar.database.viewmodel.CartViewModel
import com.bhartenduKodes.nectar.database.viewmodel.CartViewModelFactory
import com.bhartenduKodes.nectar.databinding.FragmentDetailsBinding
import com.bhartenduKodes.nectar.ui.activity.MainActivity
import com.bhartenduKodes.nectar.utils.extensions.showMotionToast
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    private val args: DetailsFragmentArgs by navArgs()

    private val cartViewModel by lazy {
        ViewModelProvider(this, CartViewModelFactory(requireContext()))[CartViewModel::class.java]
    }

    lateinit var product: Product

    override fun initView() {
        initi()
        getData()
        favorateButton()
    }


    private fun getData() {
        binding.apply {
            tvGroceryName.text = args.product.name
            groceryImageSlider.load(args.product.img)
            tvDescription.text = args.product.description
            tvItemPrice.text = args.product.amount.toString()
            tvQuantityDescription.text = args.product.quantityDescription.plus("Kg, price")


            lifecycleScope.launch {
                cartViewModel.getFavProducts()?.collectLatest { productList ->
                    withContext(Dispatchers.Main) {
                        val product = productList.find { it.id == args.product.id }
                        product?.let {
                            updateFavoriteButton(it.isFavorite)
                        }
                    }
                }
            }
        }
    }

    private fun initi() {

    }

    private fun updateFavoriteButton(favorite: Boolean) {
        binding.apply {
            ibNew.setImageResource(
                if (favorite) R.drawable.ic_fav_selected
                else R.drawable.ic_fav_unselected
            )
        }
    }

    private fun favorateButton() {
        binding.apply {
            ibNew.setOnClickListener {
                toogleFavorite()
            }

            mbuttonCart.setOnClickListener {
                cartViewModel.updateProductInCart(args.product.copy(quantity = args.product.quantity + 1))
                showMotionToast(
                    "Success",
                    "Cart Update Successfully",
                    MotionToastStyle.SUCCESS,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.SHORT_DURATION
                )

            }
        }
    }

    private fun toogleFavorite() {
        val newFavoriteState = !args.product.isFavorite
        binding.ibNew.setImageResource(
            if (newFavoriteState) R.drawable.ic_fav_selected
            else R.drawable.ic_fav_unselected
        )

        args.product.isFavorite = newFavoriteState

        if (newFavoriteState) {
            cartViewModel.insertProductInFavorite(args.product)
        }else{
            cartViewModel.insertProductInFavorite(args.product)
        }

        MotionToast.darkColorToast(
            requireActivity(),
            if (newFavoriteState) "success 😍" else "Warning",
            if (newFavoriteState) "Item Favorite successfully!" else "Item Removed from Favorites!",
            if (newFavoriteState) MotionToastStyle.SUCCESS else  MotionToastStyle.ERROR,
            MotionToast.GRAVITY_BOTTOM,
            MotionToast.SHORT_DURATION,
            ResourcesCompat.getFont(
                requireContext(),
                www.sanju.motiontoast.R.font.montserrat_regular
            )
        )
    }

    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigation).visibility = View.GONE
    }
}

