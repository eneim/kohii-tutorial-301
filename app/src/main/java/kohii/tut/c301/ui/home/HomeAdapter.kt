package kohii.tut.c301.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import kohii.tut.c301.R
import kohii.v1.core.Common
import kohii.v1.core.Playback
import kohii.v1.core.Playback.Controller
import kohii.v1.exoplayer.Kohii

class HomeAdapter(
  private val kohii: Kohii
) : Adapter<PlayerViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.holder_video_item, parent, false)
    return PlayerViewHolder(view)
  }

  override fun getItemCount(): Int = Int.MAX_VALUE / 2

  override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
    val videoItem = VideoItem(position = position)
    kohii.setUp(videoItem.videoUrl) {
      tag = "${videoItem.videoUrl}+${position}"
      preload = true
      repeatMode = Common.REPEAT_MODE_ONE
      controller = object : Controller {
        override fun kohiiCanStart(): Boolean = true
        override fun kohiiCanPause(): Boolean = true
        override fun setupRenderer(playback: Playback, renderer: Any?) {
          holder.playerContainer.setOnClickListener {
            val playable = playback.playable ?: return@setOnClickListener
            if (playable.isPlaying()) {
              playback.manager.pause(playable)
            } else {
              playback.manager.play(playable)
            }
          }
        }

        override fun teardownRenderer(playback: Playback, renderer: Any?) {
          holder.playerContainer.setOnClickListener(null)
        }
      }
    }.bind(holder.playerView)
  }
}
