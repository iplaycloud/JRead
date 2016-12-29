// Generated code from Butter Knife. Do not modify!
package com.iplay.jread.main.splash;

import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class SplashFragment$$ViewBinder<T extends SplashFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(Finder finder, T target, Object source) {
    return new InnerUnbinder<>(target, finder, source);
  }

  protected static class InnerUnbinder<T extends SplashFragment> implements Unbinder {
    protected T target;

    protected InnerUnbinder(T target, Finder finder, Object source) {
      this.target = target;

      target.mSplashImg = finder.findRequiredViewAsType(source, 2131493018, "field 'mSplashImg'", ImageView.class);
    }

    @Override
    public void unbind() {
      T target = this.target;
      if (target == null) throw new IllegalStateException("Bindings already cleared.");

      target.mSplashImg = null;

      this.target = null;
    }
  }
}
