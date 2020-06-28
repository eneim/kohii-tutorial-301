package kohii.tut.c301.ui.home

import android.content.Context
import com.google.android.exoplayer2.DefaultLoadControl
import kohii.v1.exoplayer.ExoPlayerConfig
import kohii.v1.exoplayer.Kohii
import kohii.v1.exoplayer.createKohii
import kohii.v1.utils.Capsule

object KohiiProvider {

  private val capsule = Capsule<Kohii, Context>(creator = { context ->
    createKohii(
      context.applicationContext, ExoPlayerConfig(
        minBufferMs = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS / 10,
        maxBufferMs = DefaultLoadControl.DEFAULT_MAX_BUFFER_MS / 10,
        bufferForPlaybackMs = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS / 10,
        bufferForPlaybackAfterRebufferMs = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS / 10
      )
    )
  })

  fun get(context: Context) = capsule.get(context)
}
