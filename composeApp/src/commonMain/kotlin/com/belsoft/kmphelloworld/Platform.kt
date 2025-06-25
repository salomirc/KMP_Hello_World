package com.belsoft.kmphelloworld

import com.belsoft.kmphelloworld.UIContract.Default

interface Platform {
    val name: String
    val type: PlatformType
    val uiContract: UIContract
        get() = Default
}

enum class PlatformType {
    ANDROID, IOS, DESKTOP, WEB
}

sealed interface UIContract {
    val isThemeToggleVisible: Boolean
    val isSystemTheme: Boolean

    data object Default: UIContract {
        override val isThemeToggleVisible: Boolean = false
        override val isSystemTheme: Boolean = true
    }

    data object Web: UIContract {
        override val isThemeToggleVisible: Boolean = true
        override val isSystemTheme: Boolean = false
    }

}

expect fun getPlatform(): Platform