package com.github.digitallyrefined.androidipcamera.helpers

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ZoomRangeTest {
    @Test
    fun `keeps a supported ultra-wide zoom ratio`() {
        val range = ZoomRange.from(0.7f, 5f)!!

        assertEquals(0.7f, range.clamp(0.7f))
    }

    @Test
    fun `clamps persisted zoom to both camera bounds`() {
        val range = ZoomRange.from(0.7f, 5f)!!

        assertEquals(0.7f, range.clamp(0.1f))
        assertEquals(5f, range.clamp(8f))
    }

    @Test
    fun `rejects unusable camera metadata`() {
        assertNull(ZoomRange.from(0f, 5f))
        assertNull(ZoomRange.from(2f, 1f))
        assertNull(ZoomRange.from(Float.NaN, 5f))
    }
}
