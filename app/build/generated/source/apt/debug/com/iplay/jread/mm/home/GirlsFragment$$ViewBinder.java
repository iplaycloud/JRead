// Generated code from Butter Knife. Do not modify!
package com.iplay.jread.mm.home;

import android.view.ViewStub;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class GirlsFragment$$ViewBinder<T extends GirlsFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(Finder finder, T target, Object source) {
    return new InnerUnbinder<>(target, finder, source);
  }

  protected static class InnerUnbinder<T extends GirlsFragment> implements Unbinder {
    protected T target;

    protected InnerUnbinder(T target, Finder finder, Object source) {
      this.target = target;

      target.mGirlsRecyclerView = finder.findRequiredViewAsType(source, 2131493016, "field 'mGirlsRecyclerView'", EasyRecyclerView.class);
      target.mNetworkErrorLayout = finder.findRequiredViewAsType(source, 2131493015, "field 'mNetworkErrorLayout'", ViewStub.class);
    }

    @Override
    public void unbind() {
      T target = this.target;
      if (target == null) throw new IllegalStateException("Bindings already cleared.");

      target.mGirlsRecyclerView = null;
      target.mNetworkErrorLayout = null;

      this.target = null;
    }
  }
}
