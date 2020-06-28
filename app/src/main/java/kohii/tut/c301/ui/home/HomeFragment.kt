package kohii.tut.c301.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import kohii.tut.c301.R
import kohii.v1.core.MemoryMode.HIGH

class HomeFragment : Fragment(R.layout.fragment_home) {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val kohii = KohiiProvider.get(requireContext())

    val pager: ViewPager2 = view.findViewById(R.id.container)
    kohii.register(this, memoryMode = HIGH)
      .addBucket(pager)

    val adapter = HomeAdapter(kohii)
    pager.adapter = adapter
    pager.offscreenPageLimit = 1
  }
}
