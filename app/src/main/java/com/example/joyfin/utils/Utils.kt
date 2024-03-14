package com.example.joyfin.utils

import android.text.TextUtils
import android.util.Patterns
import java.text.NumberFormat


fun formatCurrency(value: Number):String {
  return  NumberFormat.getCurrencyInstance().format(value)
}

fun isValidEmail(target: CharSequence): Boolean {
  return if (TextUtils.isEmpty(target)) {
    false
  } else {
    Patterns.EMAIL_ADDRESS.matcher(target).matches()
  }
}