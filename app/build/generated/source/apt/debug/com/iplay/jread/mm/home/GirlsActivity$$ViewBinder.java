// Generated code from Butter Knife. Do not modify!
package com.iplay.jread.mm.home;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class GirlsActivity$$ViewBinder<T extends GirlsActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(Finder finder, T target, Object source) {
    return new InnerUnbinder<>(target, finder, source);
  }

  protected static class InnerUnbinder<T extends GirlsActivity> implements Unbinder {
    protected T target;

    private View view2131493009;

    protected InnerUnbinder(final T target, Finder finder, Object source) {
      this.target = target;

      View view;
      view = finder.findRequiredView(source, 2131493009, "field 'mFab' and method 'onClick'");
      target.mFab = finder.castView(view, 2131493009, "field 'mFab'");
      view2131493009 = view;
      view.setOnClickListener(new DebouncingOnClickListener() {
        @Override
        public void doClick(View p0) {
          target.onClick(p0);
        }
      });
    }

    @Override
    public void unbind() {
      T target = this.target;
      if (target == null) throw new IllegalStateException("Bindings already cleared.");

      target.mFab = null;

      view2131493009.setOnClickListener(null);
      view2131493009 = null;

      this.target = null;
    }
  }
}
