// Generated code from Butter Knife. Do not modify!
package com.iplay.jread.img.about;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class AboutActivity$$ViewBinder<T extends AboutActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(Finder finder, T target, Object source) {
    return new InnerUnbinder<>(target, finder, source);
  }

  protected static class InnerUnbinder<T extends AboutActivity> implements Unbinder {
    protected T target;

    protected InnerUnbinder(T target, Finder finder, Object source) {
      this.target = target;

      target.mBackdrop = finder.findRequiredViewAsType(source, 2131493006, "field 'mBackdrop'", ImageView.class);
      target.mAboutToolbar = finder.findRequiredViewAsType(source, 2131493007, "field 'mAboutToolbar'", Toolbar.class);
      target.mToolbarLayout = finder.findRequiredViewAsType(source, 2131493005, "field 'mToolbarLayout'", CollapsingToolbarLayout.class);
    }

    @Override
    public void unbind() {
      T target = this.target;
      if (target == null) throw new IllegalStateException("Bindings already cleared.");

      target.mBackdrop = null;
      target.mAboutToolbar = null;
      target.mToolbarLayout = null;

      this.target = null;
    }
  }
}
