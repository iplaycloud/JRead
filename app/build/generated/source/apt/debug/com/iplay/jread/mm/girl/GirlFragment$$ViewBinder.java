// Generated code from Butter Knife. Do not modify!
package com.iplay.jread.mm.girl;

import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class GirlFragment$$ViewBinder<T extends GirlFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(Finder finder, T target, Object source) {
    return new InnerUnbinder<>(target, finder, source);
  }

  protected static class InnerUnbinder<T extends GirlFragment> implements Unbinder {
    protected T target;

    protected InnerUnbinder(T target, Finder finder, Object source) {
      this.target = target;

      target.mViewPager = finder.findRequiredViewAsType(source, 2131493013, "field 'mViewPager'", ViewPager.class);
      target.mRootView = finder.findRequiredViewAsType(source, 2131493012, "field 'mRootView'", LinearLayout.class);
    }

    @Override
    public void unbind() {
      T target = this.target;
      if (target == null) throw new IllegalStateException("Bindings already cleared.");

      target.mViewPager = null;
      target.mRootView = null;

      this.target = null;
    }
  }
}
