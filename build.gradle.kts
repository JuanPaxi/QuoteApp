// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false

    // Room
    alias(libs.plugins.devtoolsKsp)

    // dagger hilt
    alias(libs.plugins.dagger.hilt.android) apply false
}