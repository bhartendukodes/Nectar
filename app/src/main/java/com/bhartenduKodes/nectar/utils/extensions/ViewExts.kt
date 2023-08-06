package com.bhartenduKodes.nectar.utils.extensions

import android.Manifest
import android.animation.LayoutTransition
import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.ColorUtils
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.isVisible
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Fade
import androidx.transition.Transition
import androidx.transition.TransitionManager
import androidx.viewpager2.widget.ViewPager2
import com.bhartenduKodes.nectar.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle
import java.math.BigDecimal
import java.security.acl.Group
import java.text.DecimalFormat
import java.util.*
import kotlin.math.roundToInt


fun Context.showToastLong(message: String?) {
    Toast.makeText(
        this,
        message,
        Toast.LENGTH_SHORT
    ).show()
}

fun Fragment.showMotionToast(
    message: String,
    description: String,
    toastStyle: MotionToastStyle,
    gravity: Int = MotionToast.GRAVITY_BOTTOM,
    duration: Long = MotionToast.SHORT_DURATION,
    font: Typeface? = ResourcesCompat.getFont(requireContext(), www.sanju.motiontoast.R.font.montserrat_regular)
) {
    MotionToast.darkColorToast(
        requireActivity(),
        message,
        description,
        toastStyle,
        gravity,
        duration,
        font
    )
}

fun Double.formatIntoSmallDecimalValue(digits: Int): String {
    val bd = BigDecimal(this)
    return bd.setScale(digits, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString()
}


fun Fragment.showToastShort(message: String?) {
    Toast.makeText(
        this.activity,
        message.toString(),
        Toast.LENGTH_SHORT
    ).show()
}

//fun Fragment.toastWarning(message: String?, title: String? = getString(R.string.warning)) {
//    MotionToast.createColorToast(
//        requireActivity(),
//        title,
//        message = message.toString(),
//        MotionToastStyle.WARNING,
//        MotionToast.GRAVITY_BOTTOM,
//        MotionToast.LONG_DURATION,
//        ResourcesCompat.getFont(requireContext(), www.sanju.motiontoast.R.font.helvetica_regular)
//    )
//}

//fun Fragment.toastSuccess(message: String?, title: String? = "") {
//    toastSuccess(message, title, requireActivity())
//}
//
//fun AppCompatActivity.toastSuccess(message: String?, title: String? = "") {
//    toastSuccess(message, title, this)
//}

//private fun toastSuccess(message: String?, title: String? = "", activity: Activity) {
//    MotionToast.createColorToast(
//        activity,
//        title,
//        message = message.toString(),
//        MotionToastStyle.SUCCESS,
//        MotionToast.GRAVITY_BOTTOM,
//        MotionToast.LONG_DURATION,
//        ResourcesCompat.getFont(activity, www.sanju.motiontoast.R.font.helvetica_regular)
//    )
//}

//fun Fragment.toastError(message: String?, title: String? = getString(R.string.oops)) {
//    MotionToast.createColorToast(
//        requireActivity(),
//        title,
//        message = message.toString(),
//        MotionToastStyle.ERROR,
//        MotionToast.GRAVITY_BOTTOM,
//        MotionToast.LONG_DURATION,
//        ResourcesCompat.getFont(requireContext(), www.sanju.motiontoast.R.font.helvetica_regular)
//    )
//}

fun Fragment.showToastLong(message: String?) {
    Toast.makeText(
        this.activity,
        message,
        Toast.LENGTH_LONG
    ).show()
}


fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    return true
                }
            }
        }
    } else {
        @Suppress("DEPRECATION")
        val networkInfo =
            connectivityManager.activeNetworkInfo ?: return false

        @Suppress("DEPRECATION")
        return networkInfo.isConnected
    }
    return false
}

fun AppCompatActivity.isNetworkAvailable(): Boolean {
    val connectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                return true
            }
        }
    } else {
        @Suppress("DEPRECATION")
        val networkInfo =
            connectivityManager.activeNetworkInfo ?: return false

        @Suppress("DEPRECATION")
        return networkInfo.isConnected
    }
    return false
}

fun Fragment.isNetworkAvailable(): Boolean {
    val connectivityManager =
        requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                return true
            }
        }
    } else {
        @Suppress("DEPRECATION")
        val networkInfo =
            connectivityManager.activeNetworkInfo ?: return false

        @Suppress("DEPRECATION")
        return networkInfo.isConnected
    }
    return false
}

fun View.showSnackBar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
}


fun Context.showUndoSnackBar(view: View, message: String): Snackbar {
    return Snackbar.make(view, message, Snackbar.LENGTH_LONG)
}

fun View.visible(): View {
    if (isVisible)
        return this

    this.visibility = View.VISIBLE
    if (this is Group) {
        this.requestLayout()
    }
    return this
}

fun View.inVisible(): View {
    this.visibility = View.INVISIBLE
    if (this is Group) {
        this.requestLayout()
    }
    return this
}

fun View.gone(): View {
    this.visibility = View.GONE
    if (this is Group) {
        this.requestLayout()
    }
    return this
}

fun View.goneFade(duration: Long = 500) {
    val transition: Transition = Fade()
    transition.duration = duration
    transition.addTarget(this)
    TransitionManager.beginDelayedTransition(this.parent as ViewGroup, transition)
    transition.addListener(object : Transition.TransitionListener {
        override fun onTransitionStart(transition: Transition) {
        }

        override fun onTransitionEnd(transition: Transition) {
            gone()
        }

        override fun onTransitionCancel(transition: Transition) {
        }

        override fun onTransitionPause(transition: Transition) {
        }

        override fun onTransitionResume(transition: Transition) {
        }

    })
}

fun View.visibleFade(duration: Long = 500) {
    val transition: Transition = Fade()
    transition.duration = duration
    transition.addTarget(this)
    TransitionManager.beginDelayedTransition(this.parent as ViewGroup, transition)
    this.visibility = View.VISIBLE
}

fun AppCompatActivity.showToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showSnackBar(message: String) {
    val mParentView = this.requireActivity().window.decorView.rootView
    if (mParentView != null) {
        Snackbar.make(mParentView, message, Snackbar.LENGTH_LONG).setBackgroundTint(Color.WHITE)
            .setTextColor(Color.BLACK).show()
    }
}

fun AppCompatActivity.showSnackBar(message: String) {
    val mParentView = this.window.decorView.rootView
    if (mParentView != null) {
        Snackbar.make(mParentView, message, Snackbar.LENGTH_LONG).setBackgroundTint(Color.WHITE)
            .setTextColor(Color.BLACK).show()
    }
}

fun Fragment.appInstalledOrNot(uri: String): Boolean {
    val pm = requireActivity().packageManager
    return try {
        pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
        true
    } catch (e: PackageManager.NameNotFoundException) {
        false
    }
}

fun AppCompatActivity.disableScreenCapture(buildType: String) {
    if (buildType == "release") {
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
    }
}


fun RecyclerView.setDivider(@DrawableRes drawableRes: Int) {
    val divider = DividerItemDecoration(
        this.context,
        DividerItemDecoration.VERTICAL
    )
    val drawable = ContextCompat.getDrawable(
        this.context,
        drawableRes
    )
    drawable?.let {
        divider.setDrawable(it)
        addItemDecoration(divider)
    }
}

fun RecyclerView.setVerticalDivider() {
    this.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
}


fun RecyclerView.setGridDivider() {
    this.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
    this.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
}

fun ScrollView.scrollToBottom() {
    val lastChild = getChildAt(childCount - 1)
    val bottom = lastChild.bottom + paddingBottom
    val delta = bottom - (scrollY + height)
    smoothScrollBy(0, delta)
}

fun NestedScrollView.scrollToBottom() {
    val lastChild = getChildAt(childCount - 1)
    val bottom = lastChild.bottom + paddingBottom
    val delta = bottom - (scrollY + height)
    smoothScrollBy(0, delta)
}

fun NestedScrollView.scrollToUp() {
    fullScroll(View.FOCUS_UP)
}


// send alpha under from 0.0f to 1.0f.
fun Context.getAlphaColor(@ColorRes color: Int, alpha: Float): Int {
    return ColorUtils.setAlphaComponent(
        ContextCompat.getColor(this, color),
        255.times(alpha).roundToInt()
    )
}

fun EditText.showSoftKeyboard() {
    postDelayed({
        if (this.requestFocus()) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
        }
    }, 200)
}

fun AppCompatActivity.pxToDp(px: Float): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics)
        .toInt()
}

fun Fragment.pxToDp(px: Float): Int {
    return if (activity != null && isAdded && context != null)
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics)
            .toInt()
    else
        px.toInt()
}

fun AppCompatButton.disableAlpha() {
    this.isEnabled = false
    this.isClickable = false
    this.alpha = 0.5f
}

fun AppCompatButton.enableWithDefaultAlpha() {
    this.isEnabled = true
    this.isClickable = true
    this.alpha = 1f
}


fun Fragment.hideKeyboard() {
    WindowInsetsControllerCompat(requireActivity().window, requireActivity().window.decorView).hide(
        WindowInsetsCompat.Type.ime()
    )
}

fun AppCompatActivity.hideKeyboard() {
    WindowInsetsControllerCompat(window, window.decorView).hide(WindowInsetsCompat.Type.ime())
}


fun Context.showShortToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Context.showLongToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun EditText.isValid(): Boolean {
    if (text.isNullOrEmpty()) {
        error = "Required Field"
        requestFocus()
        return false
    } else {
        clearFocus()
    }
    return true
}


fun AutoCompleteTextView.setTextWithFocus(text: String?, filter: Boolean) {
    setText(text, false)
    setSelection(text?.length ?: 0)
    requestFocus()
}

//fun Context.vibratePhone() {
//    val vibrator = this.getSystemService(VIBRATOR_SERVICE) as Vibrator
//    if (Build.VERSION.SDK_INT >= 26) {
//        vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
//    } else {
//        vibrator.vibrate(200)
//    }
//}

//fun Fragment.vibratePhone() {
//    val vibrator = requireContext().getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
//    if (Build.VERSION.SDK_INT >= 26) {
//        vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.EFFECT_TICK))
//    } else {
//        vibrator.vibrate(200)
//    }
//}
//
//fun View.vibratePhone() {
//    val vibrator = this?.context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
//    if (Build.VERSION.SDK_INT >= 26) {
//        vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
//    } else {
//        vibrator.vibrate(200)
//    }
//}

//show date and time picker dialog
@RequiresApi(Build.VERSION_CODES.O)
fun Context.pickDateTime(onDateTimePicked: (dateTime: String /*, formattedDateTime: String*/) -> Unit) {
    val datePicker =
        DatePickerDialog(this, { _, year, month, day ->
            //TimePickerDialog(this, { _, hour, minute ->

            val dateTime =
                "${day.format()}/${month.format()}/$year"    //T${hour.format()}:${minute.format()}:00Z"

            /*val formattedDateTime = "$day ${
                Month.of(month).getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH)
            } $year ${hour.format()}:${minute.format()}"*/

            onDateTimePicked(dateTime)

            //}, Calendar.HOUR_OF_DAY, Calendar.MINUTE, true).show()

        }, Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH)

    datePicker.datePicker.minDate = Calendar.getInstance().timeInMillis
    datePicker.show()
}



private fun Int.format(): String {
    val date = this.toString()
    return if (date.length == 1) {
        "0$date"
    } else {
        date
    }
}

fun Double.roundOffDecimal(): Double {
    val df = DecimalFormat("#.##")
    return df.format(this).toDouble() ?: 0.0
}

fun Int.dpToPx(displayMetrics: DisplayMetrics): Int = (this * displayMetrics.density).toInt()

val Int.toDp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

private val displayMetrics: DisplayMetrics by lazy { Resources.getSystem().displayMetrics }
val Number.px2dp: Float
    get() = this.toFloat() / displayMetrics.density

fun Context.getDrawableById(id: Int) = ResourcesCompat.getDrawable(this.resources, id, null)

fun View.showListMenu(list: List<String>, onMenuItemSelected: (menuItem: MenuItem) -> Unit) {
    val popup = PopupMenu(this.context, this)
    for (c in list) {
        popup.menu.add(c)
    }
    popup.setOnMenuItemClickListener {
        onMenuItemSelected(it)
        true
    }
    popup.show()
}

suspend fun tryCatch(block: suspend () -> Unit) {
    try {
        block()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}


fun ImageView.makeBlack() {
    this.setColorFilter(ResourcesCompat.getColor(resources, R.color.black, null))
}

fun ImageView.undoColor() {
    this.colorFilter = null
}

fun TextView.makeBlack() {
    this.setTextColor(ResourcesCompat.getColor(resources, R.color.black, null))
}


fun TextView.undoColor() {
    this.setTextColor(null)
}

fun TextView.strike() {
    paintFlags = this.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
}


fun RadioButton.makeYellow() {
    this.makeBlack()
    buttonTintList = ColorStateList.valueOf(
        ResourcesCompat.getColor(
            resources,
            com.airbnb.lottie.R.color.material_blue_grey_800,
            null
        )
    )
}

fun Drawable.tint(@ColorInt color: Int): Drawable {
    val wrapped = DrawableCompat.wrap(this)
    DrawableCompat.setTint(wrapped, color)
    return wrapped
}

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}


fun View.visibleByAnimation(anim: Int, startOffSet: Long) {
    val animation: Animation = android.view.animation.AnimationUtils.loadAnimation(context, anim)
    animation.startOffset = startOffSet
    this.visible()
    this.startAnimation(animation)
}

//fun View.shakeVertical() {
//    this.startAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_shake_vertical))
//}
//
//fun View.shakeHorizontal() {
//    this.startAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_shake_horizontal))
//}

fun View.disable() {
    isEnabled = false
    alpha = 0.5f
}

fun View.enable() {
    isEnabled = true
    alpha = 1f
}

fun View.disabledForSec(milliSeconds: Long = 1000) {
    isEnabled = false
    CoroutineScope(Dispatchers.IO).launch {
        delay(milliSeconds)
        withContext(Dispatchers.Main) {
            isEnabled = true
        }
    }
}


//fun ViewPager2.autoScroll(lifecycleScope: LifecycleCoroutineScope, interval: Long) {
//    lifecycleScope.launchWhenResumed {
//        scrollIndefinitely(interval)
//    }
//}

private suspend fun ViewPager2.scrollIndefinitely(interval: Long) {
    delay(interval)
    val numberOfItems = adapter?.itemCount ?: 0
    val lastIndex = if (numberOfItems > 0) numberOfItems - 1 else 0
    val nextItem = if (currentItem == lastIndex) 0 else currentItem + 1

    setCurrentItem(nextItem, true)

    scrollIndefinitely(interval)
}

@RequiresApi(api = Build.VERSION_CODES.M)
fun Context.neverAskAgainSelected(activity: Activity, permission: String?): Boolean {
    val prevShouldShowStatus = getRationaleDisplayStatus(activity, permission)
    val currShouldShowStatus = activity.shouldShowRequestPermissionRationale(permission!!)
    return prevShouldShowStatus != currShouldShowStatus
}

fun Context.setShouldShowStatus(context: Context, permission: String?) {
    val genPrefs = context.getSharedPreferences("GENERIC_PREFERENCES", Context.MODE_PRIVATE)
    val editor = genPrefs.edit()
    editor.putBoolean(permission, true)
    editor.apply()
}

fun Context.getRationaleDisplayStatus(context: Context, permission: String?): Boolean {
    val genPrefs = context.getSharedPreferences("GENERIC_PREFERENCES", Context.MODE_PRIVATE)
    return genPrefs.getBoolean(permission, false)
}

fun View.showFromRight(duration: Int = 500) {
    if (visibility == View.VISIBLE)
        return

    visible()
    val animate = TranslateAnimation(this.width.toFloat(), 0f, 0f, 0f)
    animate.duration = duration.toLong()
    animate.fillAfter = true
    this.startAnimation(animate)
}

fun View.hideToRight(duration: Int = 500) {
    if (visibility == View.GONE)
        return

    val animate = TranslateAnimation(0f, this.width.toFloat(), 0f, 0f)
    animate.duration = duration.toLong()
    animate.fillAfter = true
    animate.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(p0: Animation?) {}
        override fun onAnimationRepeat(p0: Animation?) {}
        override fun onAnimationEnd(p0: Animation?) {
            visibility = View.GONE
        }
    })

    this.startAnimation(animate)
}

fun View.slideRight(duration: Int = 300, onSlideEnd: () -> Unit) {
    val animate = TranslateAnimation(0f, this.width.toFloat(), 0f, 0f)
    animate.duration = duration.toLong()
    animate.interpolator = AccelerateInterpolator()
    animate.fillAfter = true

    animate.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(p0: Animation?) {
            goneFade(200)
        }

        override fun onAnimationRepeat(p0: Animation?) {}
        override fun onAnimationEnd(p0: Animation?) {
            visibility = View.INVISIBLE
            onSlideEnd.invoke()
        }
    })

    this.startAnimation(animate)
}

fun View.slideLeft(duration: Int = 300, onSlideEnd: () -> Unit) {
    visibility = View.VISIBLE
    val animate = TranslateAnimation(this.width.toFloat(), 0f, 0f, 0f)
    animate.fillAfter = true
    animate.duration = duration.toLong()
    animate.interpolator = AccelerateInterpolator()
    animate.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(p0: Animation?) {
            visibleFade(200)
        }

        override fun onAnimationRepeat(p0: Animation?) {}
        override fun onAnimationEnd(p0: Animation?) {
            onSlideEnd.invoke()
        }
    })
    this.startAnimation(animate)
}


fun ViewGroup.forceLayoutChanges() {
    try {
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

inline fun <reified T : RecyclerView.ViewHolder> RecyclerView.forEachVisibleHolder(
    action: (T) -> Unit
) {
    for (i in 0 until childCount) {
        action(getChildViewHolder(getChildAt(i)) as T)
    }
}


fun Context.isLocationPermissionGranted(): Boolean {
    return ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED
}

infix fun View.click(onClick: () -> Unit) {
    setOnClickListener {
        onClick()
    }
}

operator fun <T> T.invoke(foo: T.() -> Unit) {
    foo.invoke(this)
}

