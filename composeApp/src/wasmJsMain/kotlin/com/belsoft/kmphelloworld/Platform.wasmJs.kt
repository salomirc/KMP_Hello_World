package com.belsoft.kmphelloworld

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
    override val type: PlatformType = PlatformType.WEB
    override val uiContract: UIContract = UIContract.Web
}

actual fun getPlatform(): Platform = WasmPlatform()