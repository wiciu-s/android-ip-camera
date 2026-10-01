package com.github.digitallyrefined.androidipcamera.helpers

/** A camera-supported zoom-ratio interval. Ratios below 1.0 represent a wider field of view. */
data class ZoomRange private constructor(val min: Float, val max: Float) {
    fun clamp(value: Float): Float = value.coerceIn(min, max)

    companion object {
        /**
         * Creates a usable range only when both camera-reported bounds are finite, positive and
         * ordered. CameraX rejects zero and negative zoom ratios.
         */
        fun from(min: Float, max: Float): ZoomRange? =
            if (min.isFinite() && max.isFinite() && min > 0f && max >= min) ZoomRange(min, max) else null
    }
}
