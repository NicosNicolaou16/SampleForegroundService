package com.nicos.sampleforegroundservice.utils.secure_share_preferences

import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

/**
 * Created by Nicos on 01/10/2016.
 */
class SecureSharePreferences(context: Context) {
    companion object {
        private const val myEncryptedSharePreferencesName = "my_encrypted_share_preferences_name"
    }

    private val keyGenParameterSpec = KeyGenParameterSpec.Builder(
        MasterKey.DEFAULT_MASTER_KEY_ALIAS,
        KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
    ).setBlockModes(KeyProperties.BLOCK_MODE_GCM)
        .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
        .setKeySize(MasterKey.DEFAULT_AES_GCM_MASTER_KEY_SIZE)
        .build()
    private var masterKeyAlias = MasterKey.Builder(context)
        .setKeyGenParameterSpec(keyGenParameterSpec)
        //.setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private var encryptedSharedPreferences =
        EncryptedSharedPreferences.create(
            context,
            myEncryptedSharePreferencesName,
            masterKeyAlias,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

    private var editor = encryptedSharedPreferences.edit()

    fun saveBooleanValue(key: String?, value: Boolean) =
        with(editor) { putBoolean(key, value)?.apply() }

    fun getBooleanValue(
        key: String?,
        defaultValue: Boolean = false
    ): Boolean = with(encryptedSharedPreferences) { getBoolean(key, defaultValue) ?: false }

}