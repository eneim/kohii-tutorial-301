package kohii.tut.c301.ui.home

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kohii.tut.c301.R

class PlayerViewHolder(itemView: View) : ViewHolder(itemView) {

  val playerContainer: ViewGroup = itemView.findViewById(R.id.playerContainer)
  val playerView: ViewGroup = itemView.findViewById(R.id.playerView)
}
